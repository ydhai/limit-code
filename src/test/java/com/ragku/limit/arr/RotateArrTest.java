package com.ragku.limit.arr;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;

public class RotateArrTest extends TestCase {

    RotateArr ra = new RotateArr();
    public void testRotate() {
        int[] arr = {1,2,3,4,5,6,7};
        ra.rotate(arr, 3);
        int[] arr2 = {5,6,7,1,2,3,4};
        Assert.assertArrayEquals(arr2, arr);

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
    }
}