package com.unicorn.leetcode.slidewindow;

import java.util.HashSet;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring_brute(String s) {
        HashSet<String> hs = new HashSet();
        String temp = "";
        int result = 0;
        int left = 0;
        int right = 0;
        while(left < s.length() && right < s.length()){
            String c = s.charAt(right)+"";
            if(temp.indexOf(c) > -1){

                left ++;
                right = left;
                temp = "";
            }else{
                temp += c;
                right ++;
            }
            result = Math.max(temp.length(), result);




        }
        return result;

    }

    public int lengthOfLongestSubstring(String s) {
        String sb = "";
        int result = 0;
        for(int i=0;i<s.length();i++){
            String c = String.valueOf(s.charAt(i));
            int index = sb.indexOf(c);
            if(index > -1){
                sb = sb.substring(index+1);
            }

            sb += c;
            result = Math.max(sb.length(), result);




        }
        return result;

    }

    public int lengthOfLongestSubstring_fast(String s) {
        int start = 0;
        int[] nums = new int[256];
        int result = 0;
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i);
            if(nums[c] > start){
                start = nums[c];
            }

            nums[c] = i+1;


            result = Math.max(i-start+1, result);




        }
        return result;

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        s = "pwwkew";
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring(s));

    }
}
