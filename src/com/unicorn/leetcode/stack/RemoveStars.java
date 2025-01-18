package com.unicorn.leetcode.stack;

public class RemoveStars {

    public String removeStars(String s) {

        StringBuilder result =  new StringBuilder();
        char[] arrs = s.toCharArray();
        for(int i=0;i<arrs.length;i++){
            if(arrs[i] == '*'){
//                result.deleteCharAt(result.length()-1);
                result.setLength(result.length() - 1);
            }else{
                result.append(arrs[i]);
            }
        }
        return result.toString();

    }


}
