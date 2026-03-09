package com.shg.sort;

/**
 * @Description 基数排序
 * @Date 2024/12/24 16:16
 * @Created by sunhongguang
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {56, 23, 82, 45, 76, 69, 20, 45, 93, 16, 27};
        int max = arr[0];
        for (int item : arr) {
            if (item > max) {
                max = item;
            }
        }

        //  确定分桶次数
        for (int i = 1; max / i > 0; i *= 10) {
            int[] temp = new int[arr.length];
            int[] count = new int[10];
            // 统计每个桶中元素的个数
            for (int item : arr) {
                int index = (item / i) % 10;
                count[index]++;
            }

            for (int j = 1; j < 10; j++) {
                count[j] = count[j] + count[j - 1];
            }

            for (int j = arr.length - 1; j > 0; j--) {
                int index = (arr[j] / i) % 10;
                temp[count[index] - 1] = arr[j];
                count[index]--;
            }
            System.arraycopy(temp, 0, arr, 0, arr.length);
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}




