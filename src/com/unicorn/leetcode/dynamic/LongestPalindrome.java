package com.unicorn.leetcode.dynamic;

public class LongestPalindrome {

    public String longestPalindrome(String s) {

        String result = s.substring(0,1);
        for(int i=0;i<s.length()-1;i++){
            int l = i;
            int r = i;
            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                l --;
                r ++;
            }
            if( (r-l-1) > result.length()){
                result = s.substring(l+1, r);
            }

            l = i ;
            r = i + 1;
            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                l --;
                r ++;
            }
            if(  (r-l-1) > result.length()){
                result = s.substring(l+1, r);
            }
        }
        return result;


    }
}
