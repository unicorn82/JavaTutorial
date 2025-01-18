package com.unicorn.leetcode.binarysearch;

public class MinEatingSpeed {

    public int minEatingSpeed1(int[] piles, int h) {
        int max = 0;
        int min = 0;
        int sum = 0;
        for(int p:piles){
            max = Math.max(max, p);
            sum += p;

        }
        // min = (int)Math.ceil((double) sum/h);
        min = 1;
        int ans = 0;
        while(min <= max){
            int k = (min+max)/2;

            if(!canFinish(piles, k, h)){
                min = k+1;
            }else{
                ans = k;
                max = k-1;

            }

        }
        return ans;

    }

    private boolean canFinish(int[] piles, int k, int h){
        int hours = 0;
        for(int p:piles){
            h -= getCeilingNum(p, k);
            // (int)Math.ceil((double)p/k);
        }
        return h>=0;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int bananas : piles){
            max = Math.max(max, bananas);
        }

        int min = 1;
        int k = max;
        while(min <= max){
            int mid = min + (max - min)/2;
            int h1 = 0;
            for(int p:piles){
                h1 += getCeilingNum(p, mid);
                if(h1 > h){
                    break;
                }

            }

            if(h1 <= h){
                max = mid-1;
                k = Math.min(mid, k);

            }else{
                min = mid +1;
            }




        }

        return k;



    }

    private int getCeilingNum(int num, int divid){
        return  num/divid + (num%divid > 0 ? 1:0);

    }

    public static void main(String[] args) {

        Integer h1 = (int)Math.ceil((double)805306368/1)+(int)Math.ceil((double)805306368/1)+(int)Math.ceil((double)805306368/1);

        System.out.println(h1);
        int[] nums = new int[] {1000000000,1000000000};
        int h = 3;
        MinEatingSpeed m = new MinEatingSpeed();
        System.out.println(m.minEatingSpeed(nums, h));

    }
}


//    function minEatingSpeed(piles: number[], h: number): number {
//
//        //helper function to calculat, for a given bananaCount consumed per hour, can koko finish all the banana from the piles
//        const canFinish = (bananaCount: number) => {
//        const hoursTakenToEat = piles.reduce((acc, curr) => acc += Math.ceil(curr / bananaCount), 0);
//        return hoursTakenToEat <= h;
//
//        }
//
//        //in an hour minimum banana koko can eat
//        let min: number = 1;
//
//        //in an hour maximum banana koko can eat
//        let max: number = piles.reduce((acc, curr) => Math.max(curr, acc), 0);
//
//        while (min < max) {
//        const k: number = Math.floor((max - min) / 2) + min;
//
//        if (canFinish(k))
//        max = k;
//        else
//        min = k + 1;
//        }
//
//
//        //min & max would be equal this time, return either
//        return min;
//
//        };
