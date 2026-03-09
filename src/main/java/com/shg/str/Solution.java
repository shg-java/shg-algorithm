package com.shg.str;

// 最长公共前缀
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int nums = Integer.MAX_VALUE;
        for (String str : strs) {
            nums = Math.min(str.length(), nums);
        }
        int res = 0;
        for (int i = 0; i < nums; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                char temp = strs[j].charAt(i);
                if (temp != c) {
                    return strs[0].substring(0,res);
                }
            }
            res += 1;
        }
        return strs[0].substring(0,res);

    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}