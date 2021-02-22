package com.ragku.limit;

import java.util.Arrays;
import java.util.List;

/**
 * @author tony
 * @date 2018/7/21 14:19
 */
public class SquareAndSumTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list.stream().mapToInt(i -> i * i).sum());
    }
}
