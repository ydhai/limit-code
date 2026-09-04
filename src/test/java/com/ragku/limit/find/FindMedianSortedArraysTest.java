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
}