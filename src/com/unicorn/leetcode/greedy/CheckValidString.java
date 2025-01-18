package com.unicorn.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

public class CheckValidString {

    public boolean checkValidString_best(String s) {
        int min = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                min += 1;
                max += 1;

            }else if (c == ')'){
                min = Math.max(0, min -1);
                max -= 1;

            }else { //*
                min = Math.max(0, min -1);
                max += 1;

            }
            if(max < 0) return false;
        }
        return min == 0;
    }

    public boolean checkValidString(String s) {
        List<Character> list = new ArrayList<>();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '*') list.add(c);
            else{ // ')'
                int position = findLastBracket(list);
                if(position >=0) {
                    list.remove(position);
                }else{
                    if(list.isEmpty()) return false;
                    list.remove(list.size()-1);
                }
            }
        }
        int count = 0;
        int cursor = list.size() -1;
        while(cursor >=0 )
        {
            if(list.get(cursor) == '*'){
                count ++;
            }else if(list.get(cursor) == '('){
                count --;
                if(count < 0) return false;
            }
            cursor --;
        }
        return true;

    }

    private int findLastBracket(List<Character> list){
        for(int i=list.size()-1; i>=0;i--){
            if(list.get(i) == '('){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CheckValidString c = new CheckValidString();
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        System.out.println(c.checkValidString(s));
    }
}
