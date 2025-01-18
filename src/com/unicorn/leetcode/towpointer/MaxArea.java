package com.unicorn.leetcode.towpointer;

public class MaxArea {


    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length-1;
        while(l < r){
            int area = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(area, maxArea);
            int move = 1;
            if(height[l] > height[r]){
                while(l < (r-move) && height[r-move] < height[r]){ move ++; }
                r = r - move;
            }else{
                while(l + move < r && height[l+move] < height[l]) { move ++; }
                l = l + move;
            }


        }
        return maxArea;


    }

    public int maxArea_brute(int[] height) {
        int maxArea = 0;
        for(int i=0;i<height.length-1;i++){
            for(int j = i+1; j<height.length; j++){
                int area = (j-i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);

            }
        }
        return maxArea;

    }

}
