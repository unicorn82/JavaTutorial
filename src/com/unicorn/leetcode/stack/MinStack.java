package com.unicorn.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinStack {
    private List<Integer> list;
    private int min;



    public MinStack() {
        list = new ArrayList();
        min = Integer.MAX_VALUE;


    }

    public void push(int val) {
        list.add(val);

        min = Math.min(min, val);

    }

    public void pop() {
        if(list.size()>0){
            int t = top();
            list.remove(list.size()-1);
            if(t == min){
                min = Integer.MAX_VALUE;
                for(int num:list){
                    min = Math.min(num, min);
                }
            }

        }

    }

    public int top() {

        return list.get(list.size()-1);


    }

    public int getMin() {
        return min;

    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(3);
        ms.push(4);
        System.out.println(ms.getMin());
        ms.pop();
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());


    }
}
