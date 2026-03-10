package com.shg.two_pointers.sliding_window;

import org.checkerframework.checker.units.qual.N;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// 无重复最长字串
class LengthOfLongestSubstring {

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
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}

// 找出字符串中第一个匹配项的下标
class StrStr {
    public int strStr(String haystack, String needle) {

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String window = haystack.substring(i, i + needle.length());
            if (window.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

// 串联所有单词字符串
class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        // 处理边界情况
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return ans;
        }

        int wordLen = words[0].length(); // 单个单词长度（比如测试用例中是3）
        int wordCount = words.length;    // 单词数量

        int totalLen = wordLen * wordCount; // 组合总长度
        HashSet<String> validCombinations  = new HashSet<>();

        boolean[] used = new boolean[wordCount]; // 标记单词是否已使用

        backtrack(words, used, validCombinations,new StringBuffer(), totalLen);


        for (int i = 0; i < s.length() - totalLen; i++) {
            String window = s.substring(i, i + totalLen);
            if (validCombinations.contains(window)) {
                ans.add(i);
            }
        }
        return ans;

    }

    private void backtrack(String[] words, boolean[] used, HashSet<String> res, StringBuffer stringBuffer, int n) {
        if (stringBuffer.length() == n) {
            res.add(stringBuffer.toString());
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (used[i]) { // 跳过已使用的单词
                continue;
            }
            stringBuffer.append(words[i]);
            used[i] = true;
            backtrack(words, used, res, stringBuffer, n);
            // 回溯：撤销选择
            used[i] = false;
            // 删去最后添加的单词（长度为wordLen）
            stringBuffer.delete(stringBuffer.length() - words[i].length(), stringBuffer.length());
        }
    }

    public static void main(String[] args) {
        FindSubstring findSubstring = new FindSubstring();
        List<Integer> res = findSubstring.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
        System.out.println(res);
    }
}