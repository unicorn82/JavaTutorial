package com.unicorn.leetcode.stack;

import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for(int i=0;i<asteroids.length;i++){
            int num1 = asteroids[i];
            if(stack.isEmpty() || stack.peek() < 0 || num1 > 0){
                stack.push(num1);
            }else { //collision
                boolean isCollide = false;
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() <= Math.abs(num1)){
                    if(stack.pop() == Math.abs(num1)) {
                        isCollide = true;
                        break;
                    }

                }
                if( (stack.isEmpty() || stack.peek() < 0) && !isCollide ){
                    stack.push(num1);
                }
            }
        }
        int[] results = new int[stack.size()];
        int index = stack.size()-1;
        while(!stack.isEmpty()){
            results[index] = stack.pop();
            index--;
        }
        return results;

    }

    public static void main(String[] args) {
        int t = 6;
        for(int i=1;i<t;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
