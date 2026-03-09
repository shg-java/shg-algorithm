# 动态规划（Dynamic Programming）

## 核心思想
把原问题拆成有重叠的子问题，**记录子问题的最优解**，避免重复计算，从而高效求得**全局最优解**。

## 记忆点

### 1. 最优子结构（Optimal Substructure）
**原问题的最优解**可以由**子问题的最优解**推出。

### 2. 重叠子问题（Overlapping Subproblems）
同一个子问题会被反复计算，因此需要通过**记忆化**或**填表**复用结果。

## 常见实现方式

### 1. 自顶向下（Top-Down）
**递归 + 记忆化搜索**

```
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    // 记忆化容器，存储已计算过的子问题结果
    private Map<Integer, Long> memo = new HashMap<>();

    public long fib(int n) {
        // base case：子问题足够小，直接返回
        if (n <= 1) return n;

        // 如果已经算过，直接复用
        if (memo.containsKey(n)) return memo.get(n);

        // 否则递归求解，并记录结果
        long result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fib(10));  // 55
        System.out.println(f.fib(50));  // 12586269025
    }
}
```
### 2. 自底向上（Bottom-Up）
**状态转移方程 + DP 表迭代**

DP:DP 表迭代就是用一个数组（表）从最小的子问题开始，一步步推出大问题的答案，不用递归，直接循环填表

整个过程可以理解为：

```
dp[0]=0  dp[1]=1  dp[2]=1  dp[3]=2  dp[4]=3  dp[5]=5  ...
  ↑         ↑        ↑
base      base    由前两相推出
```
```java
public class Fibonacci {
    public static int fib(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1]; // DP 表

        // 初始状态（base case）
        dp[0] = 0;
        dp[1] = 1;

        // 从小到大填表，每格依赖前两格
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // 状态转移方程
        }

        return dp[n];
    }
}
```
## 典型例子
- **斐波那契数列**
- **背包问题**
- **最长公共子序列（LCS）**