package com.unicorn.leetcode.linkedlist;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                isCycle = true;
                break;
            }

        }
        if(!isCycle) return null;

        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }


        return fast;

    }
}
