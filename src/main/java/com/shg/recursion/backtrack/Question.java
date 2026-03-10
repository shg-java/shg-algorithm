package com.shg.recursion.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> inputs = new ArrayList<String>();
        for (int i = 0; i < digits.length(); i++) {
            inputs.add(phoneMap.get(digits.charAt(i)));
        }
        ArrayList<String> res = new ArrayList<>();
        dfs(inputs, 0, new StringBuffer(), res);
        return res;
    }

    private void dfs(List<String> inputs, int cur, StringBuffer path, List<String> res) {
        if (path.length() == inputs.size()) {
            res.add(path.toString());
            return;
        }
        String curStr = inputs.get(cur);
        for (int j = 0; j < curStr.length(); j++) {
            path.append(curStr.charAt(j));
            dfs(inputs, cur + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("23");
        System.out.println(strings);
    }
}
