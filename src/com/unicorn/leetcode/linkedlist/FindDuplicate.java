package com.unicorn.leetcode.linkedlist;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){

                break;
            }

        }

        fast = nums[0];

        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;

    }
}
