package com.unicorn.leetcode.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsNStraightHand {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int size = hand.length/groupSize;
        if(hand.length % groupSize >0) return false;
        Map<Integer, Integer> target = new HashMap<>();
        Arrays.sort(hand);
        for(int h:hand){
            int temp = target.getOrDefault(h, 0);
            target.put(h, temp+1);
        }
        for(int h:hand){
            int base = h;
            if(target.get(h) >0) {
                for (int i = 0; i < groupSize; i++) {
                    Integer num = target.get(i+base);
                    if (num == null || num == 0) return false;
                    target.put(i+base, num - 1);

                }
            }
        }
        return true;
    }

    public boolean isNStraightHand1(int[] hand, int groupSize) {
        int size = hand.length/groupSize;
        if(hand.length % groupSize >0) return false;
        int[] groups = new int[size];
        Integer[] target = new Integer[size];
        Arrays.sort(hand);
        for(int i:hand){
            int g = check(target, groups, i);
            if(g < 0) return false;
            groups[g]++;
            target[g] = groups[g] >= groupSize? null: i+1;

        }
        return true;
    }

    private int check(Integer[] target, int[] groups, int t){
        int next = -1;
        for(int i=0;i<target.length;i++){
            if(target[i] != null && target[i] == t){
                return i;
            }
            if(groups[i] == 0 && next == -1){
                next = i;
            }

        }
        return next;


    }
}
