package com.ragku.limit.backtrack;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class LetterCombinationsTest extends TestCase {

    LetterCombinations lc = new LetterCombinations();
    public void testLetterCombinations() {
        List<String> res = lc.letterCombinations("2");
        Assert.assertTrue(res.contains("a"));
        Assert.assertTrue(res.contains("b"));
        Assert.assertTrue(res.contains("c"));
        res = lc.letterCombinations("23");
        Assert.assertTrue(res.contains("ad"));
        Assert.assertTrue(res.contains("ae"));
        Assert.assertTrue(res.contains("af"));
        Assert.assertTrue(res.contains("bf"));
        Assert.assertTrue(res.contains("cf"));
        res = lc.letterCombinations("345");
        Assert.assertTrue(res.contains("ehk"));


    }
}