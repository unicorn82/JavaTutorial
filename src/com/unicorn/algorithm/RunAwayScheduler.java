package com.unicorn.algorithm;

import java.util.TreeMap;

public class RunAwayScheduler {

    class ScheduleNode {

        private int val;
        private ScheduleNode left;
        private ScheduleNode right;

        public ScheduleNode(int val){
            this.val = val;

        }

        public void setLeft(ScheduleNode left) {
            this.left = left;
        }

        public void setRight(ScheduleNode right) {
            this.right = right;
        }
    }

    private ScheduleNode header;



    public boolean isScheduled(int timer, int k){
        ScheduleNode node = new ScheduleNode(timer);
        if(header == null){
            header = node;
            return true;
        }
        return schedule(header, node, k);


    }

    private boolean schedule(ScheduleNode header, ScheduleNode node, int k){
        int diff = node.val - header.val;
        if(Math.abs(diff) <= k){
            return false;
        }
        if(diff < 0){
            if(header.left == null){
                header.left = node;
            }else {
                if(!schedule(header.left, node, k)){
                    return false;
                }
            }
        }else{
            if(header.right == null){
                header.right = node;
            }else{
                if(!schedule(header.right, node, k)){
                    return false;
                }
            }
        }
        return true;


    }



    public static void main(String[] args) {
        int k = 3;

        RunAwayScheduler scheduler = new RunAwayScheduler();
        int[] nums = new int[]{56, 57, 60, 37, 36, 46, 44, 49, 50 };
        for (int n: nums) {
            System.out.println(n+": " + scheduler.isScheduled(n, k));

        }

    }
}
