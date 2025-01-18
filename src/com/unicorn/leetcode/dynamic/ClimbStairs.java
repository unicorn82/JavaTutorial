package com.unicorn.leetcode.dynamic;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    Map<Integer,Integer> map = new HashMap();

    public int climbStairs(int n) {
        map.put(1,1);
        map.put(2,2);

        return recursiveClimb(n);

    }

    private int recursiveClimb(int n){
        if(map.containsKey(n)){
            return map.get(n);
        }
        int way = recursiveClimb(n-1) + recursiveClimb(n-2);
        map.put(n, way);
        return way;



    }
}
