package com.shg.sort;

/**
 * @Description 选择排序
 * @Date 2024/12/17 17:14
 * @Created by sunhongguang
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};

        selectSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int  temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


}
