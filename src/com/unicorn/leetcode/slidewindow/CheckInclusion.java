package com.unicorn.leetcode.slidewindow;

import java.util.Arrays;

public class CheckInclusion {

    public boolean checkInclusion_sorted(String s1, String s2) {
        String s1_sorted = sortString(s1);
        System.out.println(s1_sorted);
        int s1_length = s1.length();

        for(int start=0;start<s2.length()-s1_length+1;start++){
            int end = start + s1_length;
            System.out.println(s2.substring(start, end));
            String str = sortString(s2.substring(start, end));
            if(s1_sorted.equals(str)){
                return true;
            }



        }
        return false;


    }


    public boolean checkInclusion1(String s1, String s2) {
        if(s2.length() < s1.length()){return false;}

        int[] target = new int[26];
        int[] dest = new int[26];

        int matchs = 0;
        for(int i=0;i<s1.length();i++){
            target[s1.charAt(i)-'a']++;
            dest[s2.charAt(i) - 'a']++;
        }
        for(int i=0;i<target.length;i++){
            if(target[i] == dest[i]){
                matchs ++;
            }
        }
        if(matchs == 26){ return true;}

        int start = 0;
        for(int end = s1.length(); end<s2.length(); end++){
            dest[s2.charAt(end) - 'a']++;
            if((end - start) == s1.length()){
                dest[s2.charAt(start) - 'a'] --;
                start ++;
            }
            matchs = 0;
            for(int i=0;i<target.length;i++){
                if(target[i] == dest[i]){
                    matchs ++;
                }
            }
            if(matchs == 26){ return true;}
        }

        return false;


    }

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){return false;}

        int[] letters = new int[26];
        for(int i=0;i<s1.length();i++){
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i) - 'a']--;
        }

        if(isPermutation(letters)){return true;}
        for(int end = s1.length(); end<s2.length(); end++){

            letters[s2.charAt(end) - 'a']--;
            letters[s2.charAt(end - s1.length()) - 'a'] ++;
            if(isPermutation(letters)){return true;}

        }

        return false;


    }

    private boolean isPermutation(int[] target){
        for(int i=0;i<target.length;i++){
            if(target[i] != 0){
                return false;
            }
        }
        return true;

    }


    public boolean checkInclusion2(String s1, String s2) {
        int[] chs1 = new int[26];
        for(int i=0;i<s1.length();i++){
            chs1[s1.charAt(i)-'a']++;
        }
        int[] chs2 = new int[26];
        int left = 0;
        int right = 0;
        while(left < s2.length()){

            while( (right - left) < s1.length() && right < s2.length() ){
                chs2[s2.charAt(right)-'a']++;
                right ++;
            }
            if(Arrays.equals(chs1, chs2)) return true;

            chs2[s2.charAt(left)-'a']--;
            left++;
        }
        return false;

    }

    public boolean checkInclusion_best(String s1, String s2) {
        if(s2.length() < s1.length()){return false;}

        int[] letters = new int[26];
        int zeroCount = 0;
        for(int i=0;i<s1.length();i++){
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for(int i=0;i<letters.length;i++){
            if(letters[i] == 0) zeroCount++;
        }
        if(zeroCount == 26){return true;}


        for(int end = s1.length(); end<s2.length(); end++){
            // letters[s2.charAt(end) - 'a']--;

            if(--letters[s2.charAt(end) - 'a'] == 0){
                zeroCount ++;
            }else if (letters[s2.charAt(end) - 'a'] +1 ==0){
                zeroCount --;
            }
            // letters[s2.charAt(end - s1.length()) - 'a'] ++;
            if(++letters[s2.charAt(end - s1.length()) - 'a'] == 0){
                zeroCount ++;
            }else if (letters[s2.charAt(end - s1.length()) - 'a'] -1 ==0){
                zeroCount --;
            }
            if(zeroCount == 26){return true;}


        }

        return false;


    }
    private String sortString(String s){
        char[] tmpArry = s.toCharArray();
        Arrays.sort(tmpArry);
        return new String(tmpArry);

    }

    public static void main(String[] args) {
//        String s1 = "ab", s2 = "eidbaooo";;
        String s1 = "adc", s2 = "dcda";
        CheckInclusion c = new CheckInclusion();
        System.out.println(c.checkInclusion(s1, s2));
    }
}
