package com.shg.sort;

/**
 * @Description 使用数组存储二叉堆
 * @Date 2024/12/20 18:03
 * @Created by sunhongguang
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {30, 27, 18, 48, 60, 7, 51, 19, 48, 53};

        heap(arr, arr.length - 1);

//        for (int i : arr) {
//            System.out.println(i);
//        }
    }

    private void sort(int[] arr) {

    }

    private static void heap(int[] arr, int n) {

        for (int parent = arr.length / 2 - 1; parent >= 0; parent--) {
            heap(arr, n, parent);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap(arr, i, 0);
        }

        for (int i : arr) {
            System.out.println(i);
        }

    }

    private static void heap(int[] arr, int n, int parent) {
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;

        int max = arr[parent];
        if (left < n && arr[left] > max) {
            arr[parent] = arr[left];
            arr[left] = max;
            max = arr[parent];
            // 更换后调整树
            heap(arr, n, left);
        }

        if (right < n && arr[right] > max) {
            arr[parent] = arr[right];
            arr[right] = max;
            heap(arr, n, right);
        }
    }
}
