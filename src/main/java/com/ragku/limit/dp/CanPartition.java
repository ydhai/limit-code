package com.ragku.limit.dp;

import java.util.*;

public class CanPartition {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int s = sum / 2;

        boolean[] dp = new boolean[s + 1];
        dp[0] = true;

        for (int num : nums) {
//            for (int i = s; i >= num; i--) {
//                dp[i] = dp[i] || dp[i - num];
//            }
            for(int i = num; i <= s; i++) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[s];
    }

}
