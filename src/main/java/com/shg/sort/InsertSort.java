package com.shg.sort;

/**
 * @Description 插入排序
 * @Date 2024/12/13 18:22
 * @Created by sunhongguang
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};

        insertSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int currentIndex = i - 1;
            while (currentIndex >= 0 && arr[currentIndex] > temp) {
                arr[currentIndex + 1] = arr[currentIndex];
                currentIndex--;
            }
            arr[currentIndex + 1] = temp;
        }

    }

}





