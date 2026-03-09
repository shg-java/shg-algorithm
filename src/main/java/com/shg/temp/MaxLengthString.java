package com.shg.temp;

/**
 * @Description TODO
 * @Date 2025/11/24 17:26
 * @Created by sunhongguang
 */
public class MaxLengthString {
    
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < chars.length) {
            int index = find(chars, start, end, chars[end]);
            if (index == -1){
                end ++;
                continue;
            }
            System.out.println(s.substring(start,end));
            max = Math.max(max, end - start);
            start = start + 1;
        }
        return max;
    }

    private int find(char[] chars, int start, int end, char aChar) {
        for (int i = start; i < end; i++) {
            if (chars[i] == aChar){
                return i;
            }
        }
        return -1;
    }
}
