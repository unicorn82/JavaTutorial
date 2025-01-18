package com.unicorn.leetcode.array;

import com.unicorn.algorithm.HeapSort;
import com.unicorn.utils.AppUtils;
import com.unicorn.utils.CollectionsUtils;

import java.util.*;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Comparator<int[]> comparator = (int[]a, int[]b)-> a[0] - b[0];
        PriorityQueue<int[]> pg = new PriorityQueue<int[]>(comparator.reversed());
        Arrays.sort(nums);
        int start = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != nums[start]){
                int[] f = new int[]{i-start, nums[start]};
                pg.add(f);
                start = i;
            }
        }
        int[] f = new int[]{nums.length-start, nums[start]};
        pg.add(f);
        int[] result = new int[k];
        for(int i=0;i<result.length;i++){
            result[i] = pg.poll()[1];
        }
        return result;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap();
        List<Integer>[] sort_freq = new ArrayList[nums.length];
        for(int i =0; i<nums.length;i++){
            List<Integer> l = new ArrayList<>();
            int num = nums[i];
            sort_freq[i] = l;
            freq.put(num,freq.getOrDefault(num, 0)+1);


        }
        int[] results = new int[k];
        int result_index = 0;

        Set<Integer> keys = freq.keySet();
        for(Integer key: keys){
            int n = freq.get(key).intValue();
            sort_freq[n-1].add(key);
        }

        for(int i= sort_freq.length-1;i>=0;i--){
            List<Integer> l = sort_freq[i];
            for(Integer n: l){
                results[result_index] = n.intValue();
                if(++ result_index == k){
                    return results;
                }
            }

        }





        return results;

    }

    public static void main(String[] args) {
        TopKFrequent t = new TopKFrequent();
        int[] num1 = new int[]{1,1,1,2,2,3,5,5,5,5,5};
        int[] num2 = new int[]{1,2};
        int k = 2;
        CollectionsUtils.printArray(t.topKFrequent(num1, k));

    }
}
