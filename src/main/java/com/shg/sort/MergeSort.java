package com.shg.sort;

/**
 * @Description 归并排序
 * @Date 2024/12/18 17:04
 * @Created by sunhongguang
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] numbers = {3, 2, 4};
        mergeSort(numbers, 0, numbers.length - 1);
    
    }

    private static void mergeSort(int[] numbers, int left, int right) {
        int middle = (left+right)/2;
        if (right > left) {
            mergeSort(numbers, left, middle);
            mergeSort(numbers, middle + 1, right);
        }
        simpleSort(numbers, left, middle, right);
    }


    private static void simpleSort(int[] arr, int left, int middle, int right) {

        int[] newArr = new int[right - left + 1];
        int x = left;
        int y = middle + 1;
        int currentIndex = 0;
        while (x <= middle && y <= right) {
            if (arr[x] < arr[y]) {
                newArr[currentIndex] = arr[x];
                x++;
            } else {
                newArr[currentIndex] = arr[y];
                y++;
            }
            currentIndex++;
        }

        if (x <= middle) {
            for (int i = x; i <= middle; i++) {
                newArr[currentIndex] = arr[i];
            }
        }
        if (y <= right) {
            for (int i = y; i <= right; i++) {
                newArr[currentIndex] = arr[i];
                currentIndex++;
            }
        }

        int index = 0;
        for (int i = left; i <= right; i++) {
            arr[i] = newArr[index];
            index++;
        }
    }
}
