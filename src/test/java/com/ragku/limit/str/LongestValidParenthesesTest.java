package com.ragku.limit.str;

import junit.framework.TestCase;
import org.junit.Assert;

public class LongestValidParenthesesTest extends TestCase {

    LongestValidParentheses lvp = new LongestValidParentheses();
    public void testLongestValidParentheses() {
        Assert.assertEquals(4, lvp.longestValidParentheses("(())"));
        Assert.assertEquals(4, lvp.longestValidParentheses(")()())"));
        Assert.assertEquals(2, lvp.longestValidParentheses(")()"));
    }
}