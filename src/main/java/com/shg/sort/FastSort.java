package com.shg.sort;

/**
 * @Description 快速排序
 * @Date 2024/12/19 16:28
 * @Created by sunhongguang
 */
public class FastSort {

//    public static void main(String[] args) {
//        int[] arr = {5, 2, 4, 6, 1, 3};
//
//        fastSort(arr, 0, arr.length - 1);
//
//        for (int i : arr) {
//            System.out.println(i);
//        }
//
//    }
//
//    private static void fastSort(int[] arr, int start, int end) {
//        if (start < end) {
//            int index = partitionSort(arr, start, end);
//            partitionSort(arr, start, index);
//            partitionSort(arr, index + 1, end);
//        }
//
//
//    }
//
//    private static int partitionSort(int[] arr, int start, int end) {
//
//        int privet = arr[end];
//        int left = start;
//        int right = end;
//        while (left < right) {
//            while (left < right && arr[left] <= privet) {
//                left++;
//            }
//            // 交换左侧和插槽位置
//            arr[right] = arr[left];
//            while (left < right && arr[right] >= privet) {
//                right--;
//            }
//            arr[left] = arr[right];
//        }
//        arr[left] = privet;
//        return left;
//    }


    // 快速排序方法
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 找到分区点
            int pi = partition(arr, low, high);

            // 递归快速排序左子数组
            quickSort(arr, low, pi - 1);
            // 递归快速排序右子数组
            quickSort(arr, pi + 1, high);
        }
    }

    // 分区方法
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // 选择最右边的元素作为枢轴
        int i = (low - 1);  // 当前元素的索引

        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于枢轴元素
            if (arr[j] <= pivot) {
                  i++;

                // 交换 arr[i] 和 arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 交换 arr[i + 1] 和 arr[high] (即枢轴元素)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // 打印数组
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 测试快速排序方法的主程序
    public static void main(String[] args) {
        int[] arr = {5, 4, 2 ,6, 1, 3};
        System.out.println("排序前数组:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后数组:");
        printArray(arr);
    }
}
