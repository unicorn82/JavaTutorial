package com.unicorn.leetcode.linkedlist;

import java.util.HashSet;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet();
        ListNode p = head;
        while(p != null){
            if(set.contains(p)){
                return true;
            }
            set.add(p);
            p = p.next;

        }

        return false;


    }

    public boolean hasCycle1(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            if(fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;


    }
}
