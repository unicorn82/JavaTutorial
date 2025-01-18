package com.unicorn.leetcode.towpointer;

public class Trap {

    public int trap(int[] height){
        int total = 0;
        int lmax = height[0];
        int l = 0;

        int r = height.length - 1;
        int rmax = height[r];
        while(l < r) {
            if(height[l] < height[r]){
                l++;
                lmax = Math.max(height[l], lmax);
                total += lmax -height[l];
            }else {
                r--;
                rmax = Math.max(height[r], rmax);
                total += rmax - height[r];
            }


        }







        return total;
    }

    public int trap1(int[] height) {
        int total = 0;
        int[][] boundries = new int[height.length][2];
        for(int left=1;left<height.length;left++){
            int right = height.length-1-left;
            boundries[left][0] = Math.max(boundries[left-1][0], height[left-1]);
            boundries[right][1] = Math.max(boundries[right+1][1], height[right+1]);

        }
        for(int i=1;i<height.length-1;i++){
            int trap = Math.min(boundries[i][0], boundries[i][1]) - height[i];
            if(trap > 0) {
                total += trap;
            }
        }




        return total;
    }

    public int trap_bruce(int[] height) {
        int total = 0;
        int right = 1;
        int left = 0;
        int second_high = 1;
        int water = 0;
        while(right < height.length && left < height.length){
            System.out.println(height[left]+"  "+height[right] + " "+total);
            if(height[right] < height[left]){
                if(height[second_high] < height[right]){
                    second_high = right;
                }
                water += height[left] - height[right];

                right ++;
                if(right == height.length && second_high < height.length){ // no higher border on right
                    water = 0;
                    for(int i = second_high; i>left;i--){
                        water += height[second_high] - height[i];
                    }
                    total += water;
                    water = 0;
                    left = second_high;
                    right = second_high + 1;
                    second_high = right;


                }
            }else {
                total += water;
                water = 0;
                left = right;
                right ++;
                second_high = right;

            }

        }

        return total;
    }

    public static void main(String[] args) {
        int [] height1 = new int[]{0,1,2,0,3,0,1,2,0,0,4,2,1,2,5,0,1,2,0,2};
        Trap t = new Trap();
        System.out.println(t.trap(height1));

    }
}
