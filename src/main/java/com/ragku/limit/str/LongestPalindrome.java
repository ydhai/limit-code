package com.ragku.limit.str;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int[] max= new int[2];
        for(int i = 0; i < s.length() - 1; i++) {
            int[] v = plusLen(s, i, i);
            if(max[1]-max[0]<v[1]-v[0]) {
                max = v;
            }
            if(s.charAt(i)==s.charAt(i+1)) {
                v = plusLen(s, i, i+1);
                if(max[1]-max[0]<v[1]-v[0]) {
                    max = v;
                }
            }
        }
        return s.substring(max[0], max[1]+1);
    }

    private int[] plusLen(String s, int l, int r) {
        int[] res = {l, r};
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            res[0] = l;
            res[1] = r;
            l--;
            r++;
        }
        return res;
    }

}
