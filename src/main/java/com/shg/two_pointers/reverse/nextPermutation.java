package com.shg.two_pointers.reverse;

import java.util.Arrays;

class NextPermutation {
    public void nextPermutation(int[] nums) {
        int first = nums.length-2;
        while (first >= 0) {
            if (nums[first] >= nums[first+1]) {
                first--;
            }else {
                break;
            }

        }
        if (first >= 0) {
            int last = nums.length-1;
            while (last>=0){
                if (nums[last]<= nums[first]) {
                    last--;
                }else {
                    break;
                }
            }

            swap(nums,first,last);
        }

        reverse(nums,first+1,nums.length-1);
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] numbers = {1,2};
        nextPermutation.nextPermutation(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}