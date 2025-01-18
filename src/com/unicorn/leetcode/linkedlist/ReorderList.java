package com.unicorn.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public void reorderList_list(ListNode head) {
        List<ListNode> list = new ArrayList();
        ListNode tail = head;
        while(tail != null){
            ListNode temp = tail;
            list.add(temp);
            tail = tail.next;
            temp.next = null;

        }

        int n = list.size()-1;
        int s = 0;
        ListNode next = list.get(s);
        tail = list.get(n);
        while(s < n){

            next.next = tail;
            s++;
            next = list.get(s);

            if(s<n){
                tail.next = next;
                n--;
                tail = list.get(n);
            }





        }



    }

    public void reorderList(ListNode head) {

        ListNode p1 = head;
        ListNode p2 = head.next;
        //split the list
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        //set p1 is first head, p2 is second head.
        p2 = p1.next;
        p1.next = null;
        p1 = head;


        ListNode pre = null;
        while(p2 != null){
            ListNode temp = p2.next;
            p2.next = pre;
            pre = p2;
            p2 = temp;

        }

        //p2 is  second head
        p2 = pre;
        while(p2 != null){
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }







    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode head = l1;
        ReorderList r = new ReorderList();
        r.reorderList(head);
    }
}
