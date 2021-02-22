package com.ragku.limit;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.reducing;

/**
 * @author tony
 * @date 2018/7/21 14:28
 * @Description:
 */
public class LimitCodeTest {

    /**
     * 对集合数值平方，然后求和
     */
    @Test
    public void squareAndSumTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int real = 0;
        for (int i : list) {
            real += i * i;
        }
        Assert.assertEquals(real, list.stream().mapToInt(i -> i * i).sum());
    }

    /**
     * 对一个集合按条件进行分组处理
     */
    @Test
    public void groupByListTest() {
        IntStream.range(0, 5).mapToObj(i -> {
            User u = new User();
            u.setId((long) i);
            u.setName(i + "");
            return u;
        }).collect(Collectors.groupingBy((u) -> u.getId() % 2, Collectors.toList()));
    }

    /**
     * 对一个集合按条件进行分组处理，转成一个新的Map
     */
    @Test
    public void groupByListToMapListTest() {
        // collect 接口一个function参数和一个collector参数
        IntStream.range(0, 5).mapToObj(i -> {
            User u = new User();
            u.setId((long) i);
            u.setName(i + "");
            return u;
        }).collect(Collectors.groupingBy((u) -> u.getId() % 2, counting()));
    }

    /**
     * 处理groupBy后集合
     * @param <T> 输入类型
     * @return 统计个数
     */
    public static <T> Collector<T, ?, Long> counting() {
        // T 是数据类型
        // e 是实例 转成sum可统计的类型
        //
        return reducing(0L, e -> 1L, Long::sum);
    }
}
