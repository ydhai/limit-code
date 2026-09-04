package com.ragku.limit.find;

import junit.framework.TestCase;
import org.junit.Assert;

public class MedianFinderTest extends TestCase {

    MedianFinder medianFinder = new MedianFinder();

    public void testFindMedian() {
        medianFinder.addNum(1);
//        Assert.assertEquals(1, medianFinder.findMedian(), -5);
        medianFinder.addNum(1);
//        Assert.assertEquals(1, medianFinder.findMedian(), -5);
        medianFinder.addNum(2);
        Assert.assertEquals(1, medianFinder.findMedian(), -5);
        medianFinder.addNum(2);
        Assert.assertEquals(1.5, medianFinder.findMedian(), -5);
        medianFinder.addNum(3);
        Assert.assertEquals(2, medianFinder.findMedian(), -5);
    }
}