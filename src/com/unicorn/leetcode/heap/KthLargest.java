package com.unicorn.leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    Queue<Integer> pg;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pg = new PriorityQueue();
        for(int n: nums){
            addElement(n);
        }

    }

    private void addElement(int num){
        this.pg.add(num);
        if(this.pg.size() > this.k){
            this.pg.poll();
        }

    }

    public int add(int val) {
        addElement(val);
        return this.pg.peek();

    }
}
