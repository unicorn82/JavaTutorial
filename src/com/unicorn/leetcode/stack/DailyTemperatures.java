package com.unicorn.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> temp = new Stack();
        for(int i=0;i<temperatures.length;i++){
            while(!temp.isEmpty() && temperatures[temp.peek()]< temperatures[i]){

                answer[temp.peek()] = i - temp.peek();
                temp.pop();
            }

            temp.push(i);


        }
        return answer;

    }

    public int[] dailyTemperatures1(int[] temperatures) {
        int[] answers = new int[temperatures.length];
        Stack<Integer> stacks = new Stack();
        for(int i=0; i<temperatures.length;i++){

            while(!stacks.isEmpty() && temperatures[i]> temperatures[stacks.peek()]){
                int p = stacks.pop();
                answers[p] = i - p;
            }

            stacks.push(i);
        }
        // while(!stacks.isEmpty()){
        //     answers[stacks.pop()] = 0;
        // }

        return answers;



    }
}
