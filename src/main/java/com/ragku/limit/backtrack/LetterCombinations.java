package com.ragku.limit.backtrack;

import java.util.*;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
        List<List<Character>> param = new LinkedList<>();
        for(Character c : digits.toCharArray()) {
            if(map.containsKey(c)) {
                param.add(map.get(c));
            }
        }
        List<String> res = new LinkedList<>();
        backTrack(res, param, 0, new StringBuilder());
        return res;
    }

    private void backTrack(List<String> res, List<List<Character>> param, int index, StringBuilder sb) {
        if(index>=param.size()) {
            res.add(sb.toString());
            return;
        }
        for(char c : param.get(index)) {
            sb.append(c);
            backTrack(res, param, index+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
