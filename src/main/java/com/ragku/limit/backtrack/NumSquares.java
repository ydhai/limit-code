package com.ragku.limit.backtrack;

import java.util.ArrayList;
import java.util.List;

public class NumSquares {

    public int numSquares(int n) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i*i<=n; i++) {
            nums.addLast(i*i);
        }
        backtrace(nums ,new ArrayList<>(),0, 0, n);
        return num;
    }

    int num = Integer.MAX_VALUE;

    private void backtrace(List<Integer> nums, List<Integer> tmp, int index, int sum, int n) {
        if(sum > n) {
            return;
        } else if(sum == n) {
            num = Math.min(tmp.size(), num);
        }
        for(int i = index; i < nums.size(); i++) {
            tmp.add(nums.get(i));
            backtrace(nums, tmp, i, sum+nums.get(i), n);
            tmp.removeLast();
        }
    }


    public int numSquares2(int n) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i*i<=n; i++) {
            nums.addLast(i*i);
        }
        backtrace(nums ,new ArrayList<>(),0, 0, n);
        return num;
    }
}
