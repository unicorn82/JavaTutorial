package com.unicorn.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {

    private List sortedList;
    private PriorityQueue priorityQueue;
    private int k;

    //N*K*logK
    public KthLargest(int k, int[] nums){
        this.sortedList = new ArrayList();

        this.priorityQueue = new PriorityQueue(k-1);
        this.k = k;
        for (int num: nums) {
            orderListwithK(num);
            addInPriority(num);
        }

    }

    private void orderListwithK(int num){
        int insertIndex = this.sortedList.size();

        for(int i=0;i<sortedList.size();i++){
            int v = (int)sortedList.get(i);
            if(v < num){
                insertIndex = i;
                break;
            }

        }
        this.sortedList.add(insertIndex, num);

        if(this.sortedList.size() > k){
            this.sortedList.remove(k);
        }



    }

    public int addInPriority(int val){
        if(this.priorityQueue.size()<this.k){
            this.priorityQueue.offer(val);
        }else if((int)this.priorityQueue.peek()<val){
            this.priorityQueue.poll();
            this.priorityQueue.offer(val);
        }
        return (int)this.priorityQueue.peek();
    }

    public int add (int val){
        orderListwithK(val);

        return (int) this.sortedList.get(k-1);

    }

    public static void main(String[] args) {


        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.addInPriority(3));
        System.out.println(kthLargest.addInPriority(5));
        System.out.println(kthLargest.addInPriority(10));
        System.out.println(kthLargest.addInPriority(9));
        System.out.println(kthLargest.addInPriority(4));

    }



}
