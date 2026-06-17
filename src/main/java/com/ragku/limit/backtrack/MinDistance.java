package com.ragku.limit.backtrack;

public class MinDistance {

    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *
     *
     * 示例 1：
     *
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例 2：
     *
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     *
     *
     * 提示：
     *
     * 0 <= word1.length, word2.length <= 500
     * word1 和 word2 由小写英文字母组成
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        return minDistance(new StringBuilder(word1), word2, 0, 0, Math.max(word1.length(), word2.length()));
    }

    private int minDistance(StringBuilder w1, String w2, int i, int cur, int min) {
        if(cur >= min) {
            return min;
        }
        if(i < w1.length() && i < w2.length()) {
            if(w1.charAt(i) == w2.charAt(i)) {
                return minDistance(w1,w2, i+1, cur, min);
            } else {
                w1.insert(i, w2.charAt(i));
                min = Math.min(min,minDistance(w1, w2, i+1, cur+1, min));
                w1.deleteCharAt(i);
                char charTMp = w1.charAt(i);
                w1.setCharAt(i, w2.charAt(i));
                min = Math.min(min,minDistance(w1, w2, i+1,cur+1, min));
                w1.deleteCharAt(i);
                min = Math.min(min,minDistance(w1, w2, i,cur+1, min));
                w1.insert(i, charTMp);
                return min;
            }
        } else if(w1.length() == w2.length()) {
            return cur;
        } else if(w2.length() > w1.length()) {
            return cur+w2.length()-i;
        } else {
            return cur+w1.length()-i;
        }
    }
}
