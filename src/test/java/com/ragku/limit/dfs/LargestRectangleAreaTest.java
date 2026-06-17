package com.ragku.limit.dfs;

import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleAreaTest {

    LargestRectangleArea lra = new LargestRectangleArea();

    @Test
    public void largestRectangleArea() {
        int[] arr = {2, 1, 5, 6, 2, 3};
        int v = lra.largestRectangleArea(arr);
        Assert.assertEquals(10, v);
    }

    @Test
    public void largestRectangleArea2() {
        int[] arr = {2, 4};
        int v = lra.largestRectangleArea(arr);
        Assert.assertEquals(4, v);
    }
}