package com.unicorn.leetcode.math;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DetectSquares {

    Map<List<Integer>, Integer> map;

    public DetectSquares() {
        this.map = new HashMap<>();
    }

    public void add(int[] point) {
        List<Integer> key = new ArrayList<Integer>();
        key.add(point[0]);
        key.add(point[1]);
//        map.put(List.of(point), map.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int res = 0;
        for(List<Integer> cur:map.keySet()) {
            int x = cur.get(0);
            int y = cur.get(1);
            if(Math.abs(px - x) == Math.abs(py - y) && px != x && py != y) {
                List<Integer> a = List.of(px, y);
                List<Integer> b = List.of(x, py);
                res += map.getOrDefault(a, 0) * map.getOrDefault(b, 0) * map.get(cur);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Integer[] p1 = new Integer[]{1,1};
        Map<List<Integer>, Integer> map = new HashMap<>();

        map.put(Arrays.asList(p1),1);
        System.out.println(p1);
        System.out.println(new Integer[]{1,1});
        System.out.println(map.get(Arrays.asList(new Integer[]{1,1})));
    }
}
