package com.unicorn.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public List<Integer> partitionLabels1(String s) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int j = 0;
        int i = 0;
        while (i < s.length()) {
            int count = 0;
            j = Math.max(j, map.get(s.charAt(i)));
            while (i <= j) {
                j = Math.max(j, map.get(s.charAt(i)));
                i++;
                count++;
            }
            list.add(count);
        }
        return list;
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList();

        Map<Character, Integer> endMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            endMap.put(c, i);
        }

        int start = 0;
        while(start < s.length()){
            int end = endMap.get(s.charAt(start));
            int count = 1;
            while(start + count <= end){

                int temp = endMap.get(s.charAt(start+count));
                if(temp > end){
                    end = temp;
                }
                count ++;

            }

            result.add(count);
            start = start + count;
        }

        return result;

    }

    public static void main(String[] args) {
        PartitionLabels p = new PartitionLabels();
//        String s = "ababcbacadefegdehijhklij";
//        String s = "caedbdedda";
        String s = "gtywtbcnow";

        p.partitionLabels(s);
    }
}
