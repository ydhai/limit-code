package com.ragku.limit.dfs;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        return largestRectangleArea(heights, 0, heights.length - 1);
    }

    private int largestRectangleArea(int[] heights, int f, int t) {
        if (f == t) {
            return heights[f];
        } else if (f > t) {
            return 0;
        }
        int min = f, max = f;
        for (int i = f + 1; i <= t; i++) {
            if (heights[i] <= heights[min]) {
                min = i;
            }
            if (heights[i] > heights[max]) {
                max = i;
            }
        }
        int area = (t - f + 1) * heights[min], left = (min-f)*heights[max], right = (t-min)*heights[max];
        left = left > area ? largestRectangleArea(heights, f, min - 1) : 0;
        right = right > area ? largestRectangleArea(heights, min + 1, t) : 0;
        return Math.max(area, Math.max(left, right));
    }
}
