package com.unicorn.leetcode.linkedlist;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumpNode = new ListNode();
        ListNode p = dumpNode;
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0){
            int v1 = l1 != null? l1.val: 0;
            int v2 = l2 != null? l2.val: 0;
            int sum = v1 + v2 + carry;
            ListNode n = new ListNode(sum % 10 );
            carry = sum /10;
            l1 = l1 != null? l1.next: null;
            l2 = l2 != null? l2.next : null;
            p.next = n;
            p = n;
        }

        return dumpNode.next;

    }
}
