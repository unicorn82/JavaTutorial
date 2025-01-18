package com.unicorn.leetcode.linkedlist;

import java.util.*;

public class MergeKLists {

    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode head = new ListNode(); //dumpy head
        ListNode step = head;
        Comparator<ListNode> comparator = (o1, o2) -> o1.val - o2.val;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, comparator);
        for(ListNode listNode : lists){
            if(listNode != null) {
                queue.add(listNode);
            }
        }
        while(!queue.isEmpty()){

            ListNode l  = queue.poll();
            step.next = l;
            step = l;
            l = l.next;
            if(l != null) {
                queue.add(l);
            }

        }


        return head.next;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(); //dumpy head
        ListNode move = head;
        while(move != null){
            ListNode min = null;
            int min_value = Integer.MAX_VALUE;
            int min_index = -1;
            for(int i=0;i<lists.length;i++){
                ListNode l = lists[i];
                if(l != null && min_value > l.val){
                    min = l;
                    min_value = l.val;
                    min_index = i;
                }

            }

            move.next = min;
            move = min;
            if(min != null){
                min = min.next;
                lists[min_index] = min;
            }



        }

        return head.next;

    }

    public ListNode mergeKLists_recurse(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        int start = 0;
        int end = lists.length - 1;
        return merge(lists, start, end);


    }

    private ListNode merge(ListNode[] lists, int start, int end){
        if(start == end ){
            return lists[start];
        }
        return merge2List(merge(lists, start, end-1), lists[end]);
    }

    private ListNode merge2List(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode();
        ListNode p = prehead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                p = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                p = l2;
                l2 = l2.next;
            }
        }
        if(l1 != null){
            p.next = l1;

        }
        if(l2 != null){
            p.next = l2;


        }
        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;

        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(6);
        n1.next = n2;

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = m1;
        lists[2] = n1;
        MergeKLists m = new MergeKLists();
        ListNode head = m.mergeKLists1(lists);
        System.out.println(head.val);

    }
}
