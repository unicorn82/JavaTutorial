package com.unicorn.leetcode.intervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;




public class MeetingRoom2 {

    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        for(int i=0;i<intervals.size();i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int s = 0;
        int e = 0;
        int count = 0;
        int result = 0;
        while(s < starts.length && e < ends.length){
            if(starts[s] < ends[e] ){
                s++;
                count++;
                result = Math.max(count, result);
            }else{
                e++;
                count--;

            }
        }
        return result;

    }

}
