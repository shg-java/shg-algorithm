package com.shg.half_search;

class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public double getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while (true) {
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            if (index1 >= length1) {
                return nums2[k + index1];
            }
            if (index2 >= length2) {
                return nums1[k + index2];
            }

            int middle = k / 2 - 1;
            index1 = Math.min(length1, middle);
            index2 = Math.min(length2, middle);

            if (nums1[index1] <= nums2[index2]) {
                int excludeNumber = middle + 1;
                k = k - excludeNumber;
                index1 = index1 + middle + 1;
            } else {
                int excludeNumber = middle - 1;
                k = k - excludeNumber;
                index2 = index2 + middle + 1;
            }
        }


    }

}