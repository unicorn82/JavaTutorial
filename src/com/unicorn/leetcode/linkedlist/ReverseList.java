package com.unicorn.leetcode.linkedlist;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode jump;
        while(next != null){
            jump = next.next;
            next.next = head;
            head = next;
            next = jump;

        }
        return head;


    }
    public ListNode reverseList_recursive(ListNode head) {
        if(head == null) return head;
        ListNode result = head;
        ListNode next = head.next;
        head.next = null;
        if(next != null){
            result = reverseList(next);
            next.next = head;

        }



        return result;



    }
}
