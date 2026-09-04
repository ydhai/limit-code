package com.ragku.limit.str;

import junit.framework.TestCase;
import org.junit.Assert;

public class LongestPalindromeTest extends TestCase {

    LongestPalindrome lp = new LongestPalindrome();
    public void testLongestPalindrome() {

        Assert.assertEquals("aba",lp.longestPalindrome("abaa"));
        Assert.assertEquals("bb",lp.longestPalindrome("cbbd"));
        Assert.assertEquals("ccc",lp.longestPalindrome("ccc"));
        Assert.assertEquals("bacab",lp.longestPalindrome("bacabab"));
    }
}