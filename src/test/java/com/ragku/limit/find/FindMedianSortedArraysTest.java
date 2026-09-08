package com.ragku.limit.find;

import junit.framework.TestCase;
import org.junit.Assert;

public class FindMedianSortedArraysTest extends TestCase {

    private FindMedianSortedArrays fmsa = new FindMedianSortedArrays();
    public void testFindMedianSortedArrays() {
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,5,6,7};
        double v = fmsa.findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(4.0, v, 2);
    }

    public void testFindMedianSortedArrays2() {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {5,6,7};
        double v = fmsa.findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(4.0, v, 2);
    }

    public void testFindMedianSortedArrays3() {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {5,6,7,8};
        double v = fmsa.findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(4.5, v, 2);
    }

    public void testFindMedianSortedArrays4() {
        int[] nums1 = {};
        int[] nums2 = {8};
        double v = fmsa.findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(8.0, v, 2);
    }
}