package com.ragku.limit;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> res = generateParenthesis2(3);
        for (String str : res) {
            System.out.println(str);
        }

    }

    public static List<String> generateParenthesis2(int n) {
        Set<String> src = new HashSet<>();
        src.add("()");
        for (int i = 0; i < n; i++) {
            src = generate(src);
        }
        return src.stream().toList();

    }

    private static Set<String> generate(Set<String> src) {
        Set<String> res = new HashSet<>();
        for (String str : src) {
            res.add("(" + str + ")");
            res.add("()" + str);
            res.add(str + "()");
        }
        return res;

    }



}