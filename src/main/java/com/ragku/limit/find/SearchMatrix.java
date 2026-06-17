package com.ragku.limit.find;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }

    private boolean searchMatrix(int[][] matrix, int y, int x, int a, int b, int target) {
        if(a<y||b<x) {
            return false;
        }
        if(matrix[y][x] > target || matrix[a][b]<target) {
            return false;
        } else if(matrix[y][x] == target || matrix[a][b]==target) {
            return true;
        }
        if(y<a) {
            int mid = (y+a)/2;
            return searchMatrix(matrix, y,x, mid, b, target) || searchMatrix(matrix, mid+1, x, a, b, target);
        } else if(x<b) {
            int mid = (x+b)/2;
            return searchMatrix(matrix, y, x, a, mid, target) || searchMatrix(matrix, y, mid+1, a,b, target);
        }
        return false;
    }
}
