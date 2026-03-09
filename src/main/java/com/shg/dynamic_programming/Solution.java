package com.shg.dynamic_programming;

// 最长回文子串
class LongestPalindrome {
    // todo 中心扩散法
    public String longestPalindrome(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];

        for (int i = 0; i <= s.length() - 1; i++) {
            dp[i][i] = true;
        }
        int begin = 0;
        int len = 1;
        for (int chuck = 2; chuck <= s.length(); chuck++) {
            for (int left = 0; left <= s.length() - 1; left++) {
                int right = left + chuck - 1;
                if (right >= s.length()) {
                    break;
                }
                if (s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = false;
                } else if (chuck == 2) {
                    dp[left][right] = true;
                } else {
                    dp[left][right] = dp[left + 1][right - 1];
                }

                if (dp[left][right]) {
                    begin = left;
                    len = chuck;
                }
            }
        }
        return s.substring(begin, begin + len);
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("bb"));
    }
}
// todo 继续理解
class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    public int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem-1] !=0) {
            return count[rem-1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res > 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem-1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 3}, 6));
    }
}