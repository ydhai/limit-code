package com.ragku.limit.arr;

import java.util.Arrays;

public class RotateArr {

    public void rotate(int[] arr, int k) {
        k = k%arr.length;
        if(k==0) {
            return;
        }
        int[] tmp = Arrays.copyOf(arr, arr.length);
        System.arraycopy(tmp, 0, arr, k, arr.length-k);
        System.arraycopy(tmp, arr.length-k, arr,0, k);
    }
}
