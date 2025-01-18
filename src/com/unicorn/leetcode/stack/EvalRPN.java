package com.unicorn.leetcode.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        Set<String> operands = new HashSet();
        operands.add("+");
        operands.add("-");
        operands.add("*");
        operands.add("/");


        for(String s: tokens){
            if(operands.contains(s)){
                int v1 = stack.pop();
                int v2 = stack.pop();
                if(s.equals("+")){
                    //+
                    stack.push(v2+v1);
                }else if(s.equals("-")){
                    //-
                    stack.push(v2-v1);
                }else if(s.equals("*")){
                    //*
                    stack.push(v2*v1);
                }else if(s.equals("/")){
                    // divid
                    stack.push(v2/v1);
                }

            }else{
                int val = Integer.valueOf(s);
                stack.push(val);
            }





        }
        return stack.pop();

    }

    public int evalRPN1(String[] tokens) {
        Stack<Integer> stack = new Stack();
        Set<String> operands = new HashSet();
        operands.add("+");
        operands.add("-");
        operands.add("*");
        operands.add("/");

        for(String s: tokens){
            if(operands.contains(s)){
                int v1 = stack.pop();
                int v2 = stack.pop();
                switch(s){
                    case "+":
                        stack.push(v2+v1);
                        break;
                    case "-":
                        stack.push(v2-v1);
                        break;
                    case "*":
                        stack.push(v2*v1);
                        break;
                    case "/":
                        stack.push(v2/v1);
                        break;

                }

            }else{
                int val = Integer.valueOf(s);
                stack.push(val);
            }





        }
        return stack.pop();

    }

    public static void main(String[] args) {
        EvalRPN ev = new EvalRPN();
        String[] strs = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(ev.evalRPN(strs));
    }
}
