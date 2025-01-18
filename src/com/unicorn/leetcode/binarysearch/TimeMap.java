package com.unicorn.leetcode.binarysearch;

import java.util.*;

public class TimeMap {
    Map<String, String> keyValMaps;
    Map<String, List<Integer>> timeMap;

    public TimeMap() {
        keyValMaps = new HashMap();
        timeMap = new HashMap();
    }

    public void set(String key, String value, int timestamp) {

        List<Integer> times = timeMap.getOrDefault(key, new ArrayList<>());
        timeMap.put(key, times);
        keyValMaps.put(key+"_"+timestamp, value);
        times.add(timestamp);

    }

    public String get(String key, int timestamp) {
        String result = "";
        if(timeMap.containsKey(key)){
            List<Integer> times = timeMap.get(key);
            int left = 0;
            int right = times.size()-1;

            while(left <= right){
                int mid = (left + right)/2;
                if(times.get(mid) <= timestamp){
                    result = keyValMaps.get(key+"_"+times.get(mid));
                    left = mid + 1;

                }else{
                    right = mid - 1;
                }
            }

        }
        return result;

    }
}
