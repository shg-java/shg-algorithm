package com.shg.two_pointers.sliding_window;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 滑动窗口频次统计工具
 */
public class SlidingWindowCounter {
    // 窗口长度（单位：ms），比如1秒
    private final long windowSize;
    // 存储每个Key的访问时间戳队列（线程安全）
    private final Map<String, Queue<Long>> keyTimeMap = new ConcurrentHashMap<>();

    // 构造函数：指定窗口长度
    public SlidingWindowCounter(long windowSize) {
        this.windowSize = windowSize;
    }

    /**
     * 记录一次Key的访问（核心埋点方法）
     */
    public void recordAccess(String key) {
        // 1. 获取该Key的时间戳队列，不存在则创建
        Queue<Long> timeQueue = keyTimeMap.computeIfAbsent(key, k -> new ConcurrentLinkedQueue<>());
        // 2. 添加当前时间戳（毫秒）
        long now = System.currentTimeMillis();
        timeQueue.add(now);
        // 3. 清理窗口外的过期时间戳（关键步骤）
        cleanExpiredTime(now, timeQueue);
    }

    /**
     * 清理窗口外的过期时间戳
     */
    private void cleanExpiredTime(long now, Queue<Long> timeQueue) {
        // 窗口的左边界：now - windowSize
        long expireTime = now - windowSize;
        // 循环移除队列头部的过期时间戳
        while (!timeQueue.isEmpty()) {
            Long firstTime = timeQueue.peek();
            if (firstTime == null || firstTime < expireTime) {
                // 时间戳已过期，移除
                timeQueue.poll();
            } else {
                // 队列头部未过期，停止清理
                break;
            }
        }
    }

    /**
     * 获取Key在当前窗口内的访问频次
     */
    public int getAccessCount(String key) {
        Queue<Long> timeQueue = keyTimeMap.get(key);
        if (timeQueue == null) {
            return 0;
        }
        // 先清理过期数据，再返回队列大小（即频次）
        cleanExpiredTime(System.currentTimeMillis(), timeQueue);
        return timeQueue.size();
    }

    // 测试示例
    public static void main(String[] args) throws InterruptedException {
        // 创建1秒（1000ms）的滑动窗口
        SlidingWindowCounter counter = new SlidingWindowCounter(1000);
        String hotKey = "秒杀商品_10086";

        // 模拟访问：第0ms、200ms、500ms各访问一次
        counter.recordAccess(hotKey);
        Thread.sleep(200);
        counter.recordAccess(hotKey);
        Thread.sleep(300);
        counter.recordAccess(hotKey);

        // 此时窗口内频次=3
        System.out.println("当前频次：" + counter.getAccessCount(hotKey)); // 输出3

        // 等待800ms（总时间过了1000ms+）
        Thread.sleep(800);
        // 此时窗口内的时间戳都已过期，频次=0
        System.out.println("过期后频次：" + counter.getAccessCount(hotKey)); // 输出0
    }
}