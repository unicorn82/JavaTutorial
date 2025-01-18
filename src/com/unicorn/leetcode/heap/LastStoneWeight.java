package com.unicorn.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int n:stones){
            queue.add(n);
        }
        while(queue.size()>1){
            int x = queue.poll().intValue();
            int y = queue.poll().intValue();
            int left = Math.abs(x-y);
            queue.add(left);
        }
        return queue.poll();

    }

}
