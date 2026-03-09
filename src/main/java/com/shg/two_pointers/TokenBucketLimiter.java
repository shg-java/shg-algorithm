package com.shg.two_pointers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 令牌桶限流
 */
public class TokenBucketLimiter {
    private final AtomicLong tokenCount; // 当前令牌数
    private final long maxToken; // 桶的最大容量
    private final long refillRate; // 令牌补充速率（个/秒）
    private final AtomicLong lastRefillTime; // 上次补充令牌的时间

    public TokenBucketLimiter(long maxToken, long refillRate) {
        this.maxToken = maxToken;
        this.refillRate = refillRate;
        this.tokenCount = new AtomicLong(maxToken); // 初始桶满
        this.lastRefillTime = new AtomicLong(System.currentTimeMillis());
    }

    /**
     * 尝试获取令牌
     * @return true-获取成功，false-失败
     */
    public boolean tryAcquire() {
        // 1. 补充令牌（根据上次补充时间到现在的时长，计算应补充的令牌数）
        refillToken();

        // 2. 尝试获取1个令牌
        long current = tokenCount.get();
        if (current > 0) {
            return tokenCount.compareAndSet(current, current - 1);
        }
        return false;
    }

    // 补充令牌
    private void refillToken() {
        long now = System.currentTimeMillis();
        long last = lastRefillTime.get();
        long duration = now - last;

        // 计算应补充的令牌数：时长(秒) * 补充速率
        long refillNum = (duration * refillRate) / TimeUnit.SECONDS.toMillis(1);
        if (refillNum <= 0) {
            return;
        }

        // 原子更新令牌数（不超过最大容量）
        if (lastRefillTime.compareAndSet(last, now)) {
            long current = tokenCount.get();
            long newCount = Math.min(current + refillNum, maxToken);
            tokenCount.set(newCount);
        }
    }

    // 测试
    public static void main(String[] args) throws InterruptedException {
        TokenBucketLimiter limiter = new TokenBucketLimiter(10, 5); // 桶容量10，每秒补充5个令牌

        // 突发10个请求（桶满，全部放行）
        for (int i = 1; i <= 10; i++) {
            System.out.println("第" + i + "次请求：" + (limiter.tryAcquire() ? "放行" : "拒绝"));
        }

        // 第11个请求（桶空，拒绝）
        System.out.println("第11次请求：" + (limiter.tryAcquire() ? "放行" : "拒绝"));

        // 等待1秒（补充5个令牌）
        Thread.sleep(1000);
        // 再发5个请求（放行）
        for (int i = 12; i <= 16; i++) {
            System.out.println("第" + i + "次请求：" + (limiter.tryAcquire() ? "放行" : "拒绝"));
        }
    }
}