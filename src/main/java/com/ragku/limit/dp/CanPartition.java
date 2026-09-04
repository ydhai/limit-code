package com.ragku.limit.dp;

import java.util.*;

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
        return canPartition(nums, 0, total/2, 0);
    }

    private boolean canPartition(int[] arr, int index, int k, int sum) {
        if(sum>=k) {
            return sum == k;
        }
        for(int i = index; i < arr.length; i++) {
            if(canPartition(arr, i+1, k, sum+arr[i])){
                return true;
            }
        }
        return false;
    }

    private boolean canPartition1(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int sum1 = 0, sum2 = 0;
        for(int n : nums) {
            if(sum1 <= sum2) {
                list1.add(n);
                sum1+=n;
            } else {
                list2.add(n);
                sum2+=n;
            }

        }
        if((sum1+sum2)%2==1) {
            return false;
        }
        int dis = (sum1 - sum2)/2;
        if(dis == 0 || list1.contains(dis)) {
            return true;
        }
        for(int n : list1) {
            if(list2.contains(n-dis)||list1.contains(n+dis)) {
                return true;
            }
        }
        return false;
    }

}
