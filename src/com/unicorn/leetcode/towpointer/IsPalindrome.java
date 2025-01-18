package com.unicorn.leetcode.towpointer;

import java.util.Arrays;

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
         s= s.toLowerCase();
        while(start < end) {
            char start_c = s.charAt(start);
            char end_c = s.charAt(end);
            if (start_c >= 'A' && start_c <= 'Z') {
                start_c = (char) (start_c - 'A' + 'a');
            }
            if (end_c >= 'A' && end_c <= 'Z') {
                end_c = (char) (end_c - 'A' + 'a');
            }
            if (Character.isLetterOrDigit(start_c)){
//            if((start_c <'a' || start_c >'z') && (start_c <'0' || start_c > '9')){
                start++;
//            }else if((end_c <'a' || end_c >'z') && (end_c <'0' || end_c > '9')){
            }else if(Character.isLetterOrDigit(end_c)){
                end--;
            }else if(start_c == end_c){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;



    }

//    private  boolean isLetterOrDigit(int codePoint) {
//        return (((
//                (1 << Character.LOWERCASE_LETTER) |
//                (1 << Character.TITLECASE_LETTER) |
//                (1 << Character.MODIFIER_LETTER) |
//                (1 << Character.OTHER_LETTER) |
//                (1 << Character.DECIMAL_DIGIT_NUMBER)) >> getType(codePoint)) & 1)
//                != 0;
//    }
//
//    private int getType(int codePoint) {
//        return CharacterData.of(codePoint).getType(codePoint);
//    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        IsPalindrome is = new IsPalindrome();
        System.out.println(is.isPalindrome(s1));



    }
}
