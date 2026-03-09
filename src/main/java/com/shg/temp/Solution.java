package com.shg.temp;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = mergeArray(nums1,nums2);
        for (int i : result) {
            System.out.println(i);
        }
        double middle; 
        if(result.length%2==0){
          middle  = (result[result.length/2] + result[result.length/2-1])/2.0;
        }else{
          middle =result[result.length/2];
        }
        System.out.println(middle);
        return middle;
    }

    public int[] mergeArray(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length + nums2.length];
        int firstIndex = 0;
        int secondIndex = 0;
        int resultIndex = 0;
        while(firstIndex < nums1.length && secondIndex<nums2.length){
            if(nums1[firstIndex]<=nums2[secondIndex]){
                result[resultIndex] = nums1[firstIndex];
                firstIndex++;
            } else {
                result[resultIndex] = nums2[secondIndex];
                secondIndex++;
            }
            resultIndex++;
        }

        if(secondIndex<nums2.length){
            for(int i=secondIndex;i<nums2.length;i++){
                result[resultIndex] = nums2[i];
                resultIndex++;
            }
        }

        if(firstIndex<nums1.length){
            for(int i=firstIndex;i<nums1.length;i++){
                result[resultIndex] = nums1[i];
                resultIndex++;
            }
        }
        return result;
    }
    
}