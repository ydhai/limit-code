package com.ragku.limit.backtrack;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        int[][] arr = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        dfs(res, arr, 0);
        return res;
    }

    private void dfs(List<List<String>> res, int[][] arr, int i) {
        if (i >= arr.length) {
            List<String> list = new ArrayList<>();
            for (int[] ints : arr) {
                StringBuilder sb = new StringBuilder();
                for (int n : ints) {
                    sb.append(n == -1 ? "Q" : ".");
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[i][j] == 0) {
                fill(arr, i, j, 1);
                arr[i][j] = -1;
                dfs(res, arr, i + 1);
                fill(arr, i, j, -1);
                arr[i][j] = 0;
            }
        }
    }

    private void fill(int[][] arr, int i, int j, int v) {
        // 横
        fill(arr, i, j, 1, 0, v);
        fill(arr, i, j, -1, 0, v);
        // 竖
        fill(arr, i, j, 0, 1, v);
        fill(arr, i, j, 0, -1, v);
        // 左上右下
        fill(arr, i, j, -1, -1, v);
        fill(arr, i, j, 1, 1, v);
        // 左下右上
        fill(arr, i, j, 1, -1, v);
        fill(arr, i, j, -1, 1, v);
    }

    private void fill(int[][] arr, int i, int j, int x, int y, int v) {
        int n = arr.length;
        while (i >= 0 && j >= 0 && i < n && j < n) {
            arr[i][j] += v;
            i += x;
            j += y;
        }
    }

}
