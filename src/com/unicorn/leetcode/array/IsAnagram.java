package com.unicorn.leetcode.array;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        int[] alpha = new int[26];
        int[] unicode = new int[128];
        if(s.length() != t.length()) return false;
        for(int i=0;i<s.length();i++){
            System.out.println(s.charAt(i)+"  "+(s.charAt(i)-'A'));
            char c = s.charAt(i);
            if(c < 'a'){
                int b = c - 'A';
//                alpha[b]++;
                unicode[c]++;

            }else {
                int b = c - 'a';
//                alpha[b]++;
                unicode[c]++;

            }


        }
        for(int i=0;i<t.length(); i++){

            char c = t.charAt(i);
            if(c < 'a'){
                int b = c - 'A';
//                alpha[b]--;
                unicode[c]--;

            }else {
                int b = c - 'a';
//                alpha[b]--;
                unicode[c]--;
            }
        }
//        for(int a: alpha){
//            if(a >0) return false;
//        }

        for(int b: unicode){
            if(b >0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram i = new IsAnagram();
        String s = "anagram;rat";
        String t = "r;atnagaram";
        System.out.println(i.isAnagram(s, t));

        String s1 = "rat";
        String t1 = "car";
        System.out.println(i.isAnagram(s1, t1));
    }



}
