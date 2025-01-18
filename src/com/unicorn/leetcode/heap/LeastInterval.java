package com.unicorn.leetcode.heap;

import java.util.*;

public class LeastInterval {
    class TaskPair{
        TaskPair(int left, int delay){
            this.delay = delay;
            this.left = left;
        }
        int left;
        int delay;

    }
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        for(char t: tasks){
            freqs[t-'A']++;
        }
        PriorityQueue<Integer> pg = new PriorityQueue<>(Collections.reverseOrder());
        for(int f:freqs){
            if(f > 0) {
                pg.add(f);
            }
        }
        int time = 0;
        Queue<TaskPair> queue = new LinkedList<>();
        while(!queue.isEmpty() || !pg.isEmpty()){
            if(!queue.isEmpty() && queue.peek().delay == time){
                pg.add(queue.poll().left);
            }
            if(pg.isEmpty()){
                time ++;
            }else{
                int task = pg.poll();
                time ++;
                task --;
                if(task >0) {
                    queue.add(new TaskPair(task, time + n ));
                }
            }
        }

        return time;


    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        int n = 2;
        LeastInterval l = new LeastInterval();
        System.out.println(l.leastInterval(tasks,n));
    }
}
