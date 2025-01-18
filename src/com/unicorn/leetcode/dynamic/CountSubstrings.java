package com.unicorn.leetcode.dynamic;

public class CountSubstrings {

    public int countSubstrings(String s) {
        int count =0;
        for(int i=0;i<s.length();i++){
            int l = i-1;
            int r = i;
            while(r<s.length() && s.charAt(i) == s.charAt(r)){
                count++;
                r++;
            }
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                count ++;
                l--;
                r++;
            }



        }
        return count;

    }

    public int countSubstrings1(String s) {
        int count =0;
        for(int i=0;i<s.length();i++){
            int l = i;
            int r = i;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                count ++;
                l--;
                r++;
            }
            if(i<s.length()-1){
                l = i;
                r = i+1;
                while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                    count ++;
                    l--;
                    r++;
                }

            }


        }
        return count;

    }
}
