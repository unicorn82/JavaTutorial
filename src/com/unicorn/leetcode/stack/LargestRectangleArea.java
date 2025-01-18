package com.unicorn.leetcode.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class LargestRectangleArea {

    public int largestRectangleArea_best(int[] ht) {
        int max = 0;

        int n = ht.length;
        int[] mns = new int[n + 1];
        mns[0] = -1;
        int p = 0;

        for (int i = 0; i < n; ++i) {

            while (p > 0 && ht[i] < ht[mns[p]]) {
                max = Math.max(max, ht[mns[p]]*(i-mns[p-1]-1));
                p--;
            }

            if (p == 0 || ht[i] >= ht[mns[p]])
                mns[++p] = i;

        }

        while (p > 0) {
            max = Math.max(max, ht[mns[p]]*(n-mns[p-1]-1));
            p--;
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {

        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int leftBorder = i;
            if(!stack.isEmpty()){

                while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                    int[] pop = stack.pop();
                    int area = (i-pop[0])*pop[1];
                    maxArea = Math.max(maxArea, area);
                    leftBorder = pop[0];

                }

            }

            stack.push(new int[]{leftBorder, heights[i]});


        }
        while(!stack.isEmpty()){
            int[] pop = stack.pop();
            int area = (heights.length-pop[0])*pop[1];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        LargestRectangleArea l = new LargestRectangleArea();
        System.out.println(l.largestRectangleArea(heights));
    }
}
