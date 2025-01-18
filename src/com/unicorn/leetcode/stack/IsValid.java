package com.unicorn.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {

    public boolean isValid1(String s) {

        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            switch(chars[i]){

                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if(stack.isEmpty() || stack.pop() != chars[i]){
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();



    }

    public boolean isValid_best(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }


    public boolean isValid(String s) {
        Map<String, String> map = new HashMap();
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");
        Stack<String> stack = new Stack();

        for(int i=0;i<s.length();i++){
            String bracket = String.valueOf(s.charAt(i));
            if(map.containsKey(bracket)&& !stack.isEmpty()){
                //pop and valid
                String left = stack.pop();
                if(!map.get(bracket).equals(left)){
                    return false;
                }
            }else{
                //push
                stack.push(bracket);
            }
        }
        if(stack.size() > 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        IsValid is = new IsValid();
        System.out.println(is.isValid1(s));
    }
}
