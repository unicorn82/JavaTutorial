package com.unicorn.leetcode.greedy;

public class MergeTriplets {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] result = new boolean[target.length];
        for(int[] triplet:triplets){
            boolean isValid = true;
            boolean[] isMatch = new boolean[target.length];
            boolean match = false;
            for(int i=0;i<target.length;i++){
                if(triplet[i] > target[i]) isValid = false;
                if(triplet[i] == target[i]) {isMatch[i] = true; match = true;}

            }
            if(isValid && match){
                result[0] = result[0] || isMatch[0];
                result[1] = result[1] || isMatch[1];
                result[2] = result[2] || isMatch[2];


            }

        }
        return result[0]&&result[1]&&result[2];

    }
}
