package com.shg.two_pointers.sliding_window;

import java.util.HashSet;
// 无重复最长字串
class lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int rk = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            rk = i;
            while (rk != s.length() && !set.contains(s.charAt(rk))) {
                set.add(s.charAt(rk));
                rk++;
            }
            maxLength = Math.max(set.size(), maxLength);
            set.clear();
        }


        return maxLength;
    }


    public static void main(String[] args) {
        lengthOfLongestSubstring solution = new lengthOfLongestSubstring();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}