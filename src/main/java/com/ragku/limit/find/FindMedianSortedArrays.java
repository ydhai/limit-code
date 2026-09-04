package com.ragku.limit.find;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length<nums2.length){
            return find(nums1, nums2);
        }
        return find(nums2, nums1);
    }

    private double find(int[] nums1, int[] nums2) {
        int len = (nums1.length + nums2.length + 1) / 2;
        int imin = 0, imax = nums1.length;

        boolean isPair = (nums1.length + nums2.length) % 2 == 0;
        if (nums1[nums1.length - 1] <= nums2[0]) {
            return isPair ? (nums2[len - nums1.length - 1] + nums2[len - nums1.length]) / 2.0 : nums2[len - nums1.length-1];
        } else if (nums2[nums2.length - 1] <= nums1[0]) {
            return isPair ? (nums2[len - 1] + nums2[len]) / 2.0 : nums2[len];
        }
        while (true) {
            int i = (imax + imin + 1) >> 2;
            int j = len - i;
            if (nums1[i - 1] > nums2[j]) {
                imax = i;
            } else if (nums1[j - 1] > nums1[i]) {
                imin = i;
            } else {
                int v = Math.max(nums1[i - 1], nums2[j - 1]);
                return isPair ? (Math.min(nums1[i], nums2[j]) + v) / 2.0 : v;
            }
        }
    }
}
