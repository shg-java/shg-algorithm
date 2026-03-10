package com.shg.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0, 0, res, new StringBuffer(), n);
        return res;
    }

    private void backtrack(int open, int close, List<String> res, StringBuffer path, int n) {
        if (path.length() == 2 * n) {
//            res.add(path.toString());
            if (valid(path.toString().toCharArray())) {
                res.add(path.toString());
            }
            return;
        }
        if (open < n) {
            path.append("(");
            backtrack(open + 1, close, res, path, n);
            path.deleteCharAt(path.length() - 1);
        }

        if (close < open) {
            path.append(")");
            backtrack(open, close + 1, res, path, n);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(3);
        System.out.println(strings);
    }

}

class Subsets {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> t = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        return null;
    }

    public void dfs(int cur, int[] numbers) {

    }
}