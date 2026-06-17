package com.ragku.limit.backtrack;

import junit.framework.TestCase;
import org.junit.Assert;

public class MinDistanceTest extends TestCase {

    MinDistance md = new MinDistance();

    public void testMinDistance() {
        Assert.assertEquals(3,md.minDistance("horse", "ros"));
        // word1 = "intention", word2 = "execution"
        Assert.assertEquals(5, md.minDistance("intention", "execution"));
    }
}