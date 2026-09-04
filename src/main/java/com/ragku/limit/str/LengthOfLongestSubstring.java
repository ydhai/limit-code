package com.ragku.limit.str;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = start; j < i; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    start = j+1;
                    break;
                }
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> cache = new HashMap<>();
        int maxLen = 0, start = 0;
        for(int i = 0; i < s.length(); i++) {
            start = Math.max(cache.getOrDefault(s.charAt(i), -1)+1, start);
            maxLen = Math.max(maxLen, i - start + 1);
            cache.put(s.charAt(i), i);
        }
        return maxLen;
    }
}
