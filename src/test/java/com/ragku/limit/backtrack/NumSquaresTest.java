package com.ragku.limit.backtrack;

import junit.framework.TestCase;
import org.junit.Assert;

public class NumSquaresTest extends TestCase {

    NumSquares numSquares = new NumSquares();
    public void testNumSquares() {
        Assert.assertEquals(3,numSquares.numSquares(12));
        Assert.assertEquals(2,numSquares.numSquares(13));
        Assert.assertEquals(1,numSquares.numSquares(1));
    }
}