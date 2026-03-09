package com.shg.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumber {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (indexMap.containsKey(target - num)) {
                return new int[]{indexMap.get(target - num), i};
            } else {
                indexMap.put(num, i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
