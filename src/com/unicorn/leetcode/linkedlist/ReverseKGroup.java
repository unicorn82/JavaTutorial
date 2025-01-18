package com.unicorn.leetcode.linkedlist;

import java.util.Stack;

public class ReverseKGroup {
    public ListNode reverseKGroup1(ListNode head, int k) {
        Stack<ListNode> stacks = new Stack();
        ListNode p = head;
        ListNode newHead = new ListNode();
        ListNode left = newHead;

        newHead.next = head;
        while (p != null) {
            while (p != null && stacks.size() < k) {
                stacks.add(p);
                p = p.next;
            }

            if (stacks.size() == k) { //reverse the list
                ListNode pre = left;
                while (!stacks.isEmpty()) {
                    ListNode p2 = stacks.pop();
                    pre.next = p2;
                    pre = p2;
                }
                pre.next = p;
                left = pre;


            }
        }

        return newHead.next;
    }




    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead;
        ListNode post = head;
        int step = 0;
        while(true){
            //split the group
            while(step < k && post != null){
                post = post.next;
                step++;
            }
            if(step < k){ //end of listnode
                break;
            }
            //reverse the listnode
            ListNode current = pre.next;
            ListNode next = current.next;
            ListNode nextPre = pre.next;
            while(next != post){
                ListNode temp = next.next;
                pre.next = next;
                next.next = current;
                current = next;
                next = temp;
            }
            nextPre.next = post;
            pre = nextPre;


            step = 0;
        }

        return preHead.next;


    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ReverseKGroup r = new ReverseKGroup();
        r.reverseKGroup(l1, 3);

    }
}
