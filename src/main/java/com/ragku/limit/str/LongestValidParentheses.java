package com.ragku.limit.str;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
            if(!stack.empty() && s.charAt(stack.peek()) == '(' && s.charAt(i) == ')') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }
        if(stack.empty()) {
            return s.length();
        }
        int right = s.length()-1;
        int max = 0;
        while(!stack.empty()) {
            max = Math.max(max, right - stack.peek());
            right = stack.pop()-1;
        }
        max = Math.max(max, right + 1);
        return max;
    }
}
