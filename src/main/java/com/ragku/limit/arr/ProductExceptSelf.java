package com.ragku.limit.arr;

public class ProductExceptSelf {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        int[] v = productExceptSelf(arr);
//        System.out.println(v);
    }

    public static int[] productExceptSelf(int[] nums) {
        if(nums.length<=1) {
            return nums;
        }
        int[] a = new int[nums.length];
        int[] b = new int[nums.length];
        int v1 = 1;
        for(int i = 0; i < nums.length; i++) {
            v1 *= nums[i];
            a[i] = v1;
        }
        v1 = 1;
        for(int i = nums.length - 1; i >=0; i-- ) {
            v1 *= nums[i];
            b[i] = v1;
        }
        int[] v = new int[nums.length];
        v[0] = b[1];
        v[nums.length-1] = a[nums.length-2];
        for(int i = 1; i < nums.length - 1; i++) {
            v[i] = a[i-1] * b[i+1];
        }
        return v;
    }
}
