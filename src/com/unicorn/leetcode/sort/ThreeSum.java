package com.unicorn.leetcode.sort;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left > right){
                if(left > i+1 && nums[left] == nums[left-1]){
                    left++;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> r = new ArrayList();
                    r.add(nums[i]);
                    r.add(nums[left]);
                    r.add(nums[right]);
                    result.add(r);
                    left++;
                    right--;

                }else if (sum < 0){
                    left++;
                }else {
                    right--;
                }


            }

        }


        return result;

    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        // Set<String> set = new HashSet();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = 0-nums[i];
            int header = i+1;
            int tail = nums.length -1;
            while(header < tail){
                int sum = nums[header]+nums[tail];
                if(sum == target){
                    results.add(Arrays.asList(nums[i], nums[header], nums[tail]));
                    header ++;
                    tail --;
                    while(header < tail && nums[header] == nums[header - 1]){ header ++; }
                    while(header < tail && nums[tail] == nums[tail + 1]) { tail --;}
                }else if (sum < target){
                    header ++;
                    while(header < tail && nums[header] == nums[header - 1]){ header ++; }
                } else { //sum > target
                    tail --;
                    while(header < tail && nums[tail] == nums[tail + 1]) { tail --;}

                }

            }

        }
        return results;


    }

    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue();


        ThreeSum t = new ThreeSum();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> list = t.threeSum(nums);
        System.out.println(list.size());

    }
}
