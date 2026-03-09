package com.shg.math;

class Reverse {
    public int reverse(int x) {

        int maxLeft = (int) Math.pow(2, 31) / 10;
        int maxRight = (int) Math.pow(2, 31) % 10;

        int minLeft = (int) (-Math.pow(2, 31) - 1) / 10;
        int minRight = (int) (-Math.pow(2, 31) - 1) % 10;
        int result = 0;
        while (x != 0) {
            int number = x % 10;

            if (result > maxLeft || (result == maxLeft && number > maxRight)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (result < minLeft || (result == minLeft && number < minRight)) {
                return 0;
            }

            result = result * 10 + number;

            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(-1463847412));
    }

}

class IsPalindrome {
    public boolean isPalindrome(int x) {

        String s = String.valueOf(x);
        int left = 0;
        int right = s.length() - 1;

        while (left == right || left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}