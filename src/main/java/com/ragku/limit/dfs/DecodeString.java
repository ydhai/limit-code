package com.ragku.limit.dfs;

public class DecodeString {

    public static void main(String[] args) {
        // abc2[abc]3[cd]ef
        String s = "2[abc]3[cd]ef";
//        String s = "abc";
        System.out.printf(decodeString(s));
    }

    // s = "abc2[abc]3[cd]ef"
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int f = 0, t = 0, times = 0, pair = 0;
        for(int i = 0; i < s.length(); i++) {
            if(t == 0) {
                if ('a' > s.charAt(i) || s.charAt(i) > 'z') {
                    sb.append(s, f, i);
                    t = 1;
                    f = i;
                } else if(i == s.length()-1) {
                    sb.append(s,f,i+1);
                }
            } else if(t == 1) {
                if ('0' > s.charAt(i) || s.charAt(i) > '9') {
                    String strTmp = s.substring(f, i);
                    times = Integer.parseInt(strTmp);
                    t = 2;
                    f = i;
                    pair = 1;
                }
            } else {
                if(s.charAt(i) == '[') {
                    pair++;
                } else if(s.charAt(i) == ']') {
                    pair--;
                }
                if(pair == 0) {
                    String strTmp = decodeString(s.substring(f+1, i));
                    while (times>0) {
                        sb.append(strTmp);
                        times--;
                    }
                    f = i+1;
                    t = 0;
                }
            }
        }

        return sb.toString();
    }
}
