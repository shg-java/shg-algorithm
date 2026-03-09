package com.shg.sort;

/**
 * @Description 希尔排序
 * @Date 2024/12/18 13:44
 * @Created by sunhongguang
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {36, 27, 20, 60, 55, 7, 28, 36, 67, 44, 16};
        shellSort(arr);

        for (int j : arr) {
            System.out.println(j);
        }
    }

    private static void shellSort(int[] arr) {
        int length = arr.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                int temp = arr[i];
                int currentIndex = i - gap;
                while (currentIndex >= 0 && arr[currentIndex] > temp) {
                    arr[currentIndex + gap] = arr[currentIndex];
                    currentIndex = currentIndex - gap;
                }
                arr[currentIndex + gap] = temp;
            }
        }
    }

}