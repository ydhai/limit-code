package com.ragku.limit.dp;

import java.util.Arrays;

public class CanPartition {

    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int n : nums) {
            total+=n;
        }
        if(total%2==1) {
            return false;
        }
        Arrays.sort(nums);


        return true;
    }



}
