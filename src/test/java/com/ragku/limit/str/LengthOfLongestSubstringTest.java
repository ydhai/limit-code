package com.ragku.limit.str;

import junit.framework.TestCase;
import org.junit.Assert;

public class LengthOfLongestSubstringTest extends TestCase {

    LengthOfLongestSubstring lols = new LengthOfLongestSubstring();

    public void testLengthOfLongestSubstring() {
        Assert.assertEquals(4,lols.lengthOfLongestSubstring("abcabc2"));
        Assert.assertEquals(3,lols.lengthOfLongestSubstring("abcabc"));
        Assert.assertEquals(4,lols.lengthOfLongestSubstring("1abcabc"));
        Assert.assertEquals(3,lols.lengthOfLongestSubstring("dvdf"));
        Assert.assertEquals(0,lols.lengthOfLongestSubstring(""));
        Assert.assertEquals(1,lols.lengthOfLongestSubstring("11"));

    }

    public void testLengthOfLongestSubstring2() {
        Assert.assertEquals(4,lols.lengthOfLongestSubstring2("abcabc2"));
        Assert.assertEquals(3,lols.lengthOfLongestSubstring2("abcabc"));
        Assert.assertEquals(4,lols.lengthOfLongestSubstring2("1abcabc"));
        Assert.assertEquals(3,lols.lengthOfLongestSubstring2("dvdf"));
        Assert.assertEquals(0,lols.lengthOfLongestSubstring2(""));
        Assert.assertEquals(1,lols.lengthOfLongestSubstring2("11"));

    }
}