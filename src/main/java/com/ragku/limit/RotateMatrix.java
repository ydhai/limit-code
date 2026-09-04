package com.ragku.limit;

import java.util.*;

public class RotateMatrix {

    public void rotate(int[][] matrix) {
        Queue<Integer> list = new LinkedList<>();
        for(int j = 0; j < matrix[0].length; j++){
            for(int i = matrix.length-1; i >= 0; i--) {
                list.add(matrix[i][j]);
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                Integer v = list.poll();
                matrix[i][j] = null == v ? 0 : v;
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer key : map.keySet()) {

        }
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        RotateMatrix rm = new RotateMatrix();
        rm.rotate(arr);
        for(int[] a : arr) {
            for(int i : a) {
                System.out.printf(i+",");
            }
            System.out.println("--");
        }
    }
}
