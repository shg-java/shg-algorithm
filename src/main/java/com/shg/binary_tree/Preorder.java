package com.shg.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 前序遍历 根左右
 * @Date 2024/12/30 15:30
 * @Created by sunhongguang
 */
public class Preorder {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9};
        Integer root = 0;
//        preorderTraversal(arr, root);
        inorderTraversal(arr, root);
    }


//    public static void preorderTraversal(Integer[] arr, Integer root) {
//        int left = root * 2 + 1;
//        int right = root * 2 + 2;
//
//        if (root < arr.length && arr[root] != null) {
//            System.out.println(arr[root]);
//            preorderTraversal(arr, left);
//            preorderTraversal(arr, right);
//        }
//    }


    public static void preorderTraversal(Integer[] arr, Integer root) {
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            Integer top = stack.pop();
            result.add(arr[top]);
            int left = top * 2 + 1;
            int right = top * 2 + 2;
            if (right < arr.length && arr[right] != null) {
                stack.add(right);
            }

            if (left < arr.length && arr[left] != null) {
                stack.add(left);
            }

        }

        for (Integer item : result) {
            System.out.println(item);
        }
    }

    public static void inorderTraversal(Integer[] arr, Integer root) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        int current = root;
        while (current < arr.length || !stack.isEmpty()) {
            while (current < arr.length && arr[current] != null) {
                stack.push(current);
                current = current * 2 + 1;
            }
            current = stack.pop();
            result.add(arr[current]);

            current = current * 2 + 2;
        }

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }


}
