package com.unicorn.leetcode.sort;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        if(nums == null || nums.length < 3){
            return list;
        }
        Set<String> resultCache = new HashSet<>();

        Map<Integer, Integer> map1 = new HashMap();
        for(int i=0;i<nums.length;i++){
            int temp = 0-nums[i];
            map1.put(temp,i);

        }
        for(int i=0;i<nums.length-1;i++){
            for(int j=i;j<nums.length;j++){
                if(i != j){
                    int sum = nums[i]+nums[j];

                    if(map1.get(sum) != null){

                        int f = map1.get(sum);
                        if( f != i && f!=j) {
                            List<Integer> r = new ArrayList<>();
                            r.add(nums[f]);
                            r.add(nums[i]);
                            r.add(nums[j]);
                            Collections.sort(r);
                            String key = "";
                            for (int p : r) {
                                key += p + "|";

                            }
                            if (!resultCache.contains(key)) {
                                resultCache.add(key);
                                list.add(r);
                            }
                        }

                    }

                }
            }
        }
     return list;


    }

    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue();


        ThreeSum t = new ThreeSum();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> list = t.threeSum(nums);
        System.out.println(list.size());

    }
}
