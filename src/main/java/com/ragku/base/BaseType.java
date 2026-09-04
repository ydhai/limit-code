package com.ragku.base;

/**
 * 基本类型：int/long/char/boolean/float/dubble/byte/short
 */
public class BaseType {

    public void typeShow() {
        int i = 1; // 4字节
        long l = 1L; // 8字节
        char c = 'a'; // 2字节，用于表示单个字符。Java 使用 Unicode 字符集，因此 char 可以存储包括中文在内的各种字符。
        boolean bool = true; // 单独的boolean4字节。只有在数组这种连续存储大量相同数据的场景下，JVM才会将其压缩为1字节。
        float f = 1.0f; // 4字节，f/F结尾
        double d = 0.0d; // 8字节，d结尾或不写
        byte b = 127; // 1字节8bit, +-2^7，设128会报错
        short s = 134; // 2字节16bit +-2^15
    }

    /**
     * 一、运算
     * 位运算：针对单个位
     * &: 与, 都是1时才为1，其他为0
     * |: 或，两个0是为0，其他为1
     * ^: 异或，两个相应的位不相同时结果为 1，相同时结果为 0)
     * ~: 取反
     * 逻辑运算：有短路，比如fun1||fun2,如果fun1为true则不再执行fun2，也可用fun1|fun2，但这种不会短路，fun2也会被执行
     * &&: 与
     * ||: 或
     *  !: 非
     * 移位运算
     * >>: 将二进制位向左移动指定的位数，右侧空出的位补 0。相当于乘以 2 的 n 次方。
     * <<: 将二进制位向右移动指定的位数。如果是正数，左侧补 0；如果是负数，左侧补 1（保持符号位不变）。相当于除以 2 的 n 次方。
     * >>>:无符号右移，将二进制位向右移动指定的位数，无论正负，左侧一律补0
     * 二、加减乘除的实现
     * 加法：通过全加器电路结合超前进位技术，并行计算并处理“逢二进一”的进位信号。
     * 减法：将减数按位取反加1求补码，然后复用加法器电路将其与被减数相加。
     * 乘法：利用移位操作和加法器，并行生成并累加多个部分积（如采用华莱士树算法）。
     * 除法：通过不断将除数移位并与被除数做减法，逐位估算并确定商的数值。
     */
    public void bitCal() {

    }

    public static void main(String[] args) {
        //int i = -100;
        System.out.println(Integer.toBinaryString(-100));
        int i = -100 >>> 5;
        System.out.println(Integer.toBinaryString(i));
        //System.out.println(-100>>>1);
        //System.out.println(5>>>1);
    }
}
