package com.ragku.limit.find;

import junit.framework.TestCase;
import org.junit.Assert;

public class SearchMatrixTest extends TestCase {
    SearchMatrix sm = new SearchMatrix();

    public void testSearchMatrix() {
        int[][] arr = {{1,4,7},{2,5,8},{3,6,9}};
        Assert.assertTrue(sm.searchMatrix(arr, 5));
        Assert.assertFalse(sm.searchMatrix(arr, 10));
        Assert.assertTrue(sm.searchMatrix(arr, 9));
    }

    public void testSearchMatrix2() {
        int[][] arr = {{1,4,7},{2,5,8}};
        Assert.assertTrue(sm.searchMatrix(arr, 5));
        Assert.assertFalse(sm.searchMatrix(arr, 10));
        Assert.assertFalse(sm.searchMatrix(arr, 9));
    }
}