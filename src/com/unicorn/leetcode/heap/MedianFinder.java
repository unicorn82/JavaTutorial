package com.unicorn.leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()) ;
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num < maxHeap.peek() ){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        int balance = minHeap.size() - maxHeap.size();
        if(balance > 1){
            maxHeap.add(minHeap.poll());

        }else if(balance < -1){
            minHeap.add(maxHeap.poll());
        }

    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }else if(minHeap.size() < maxHeap.size()){
            return Double.valueOf(maxHeap.peek());
        }else{
            return Double.valueOf(minHeap.peek());
        }
    }
}
