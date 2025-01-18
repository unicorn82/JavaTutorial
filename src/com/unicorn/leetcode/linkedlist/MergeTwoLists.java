package com.unicorn.leetcode.linkedlist;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode next = head;
        while(list1 != null || list2 != null){
            if(list1 != null){
                if(list2 != null){
                    //list1, list 2 != null
                    if(list1.val <= list2.val){
                        next.next = list1;
                        list1 = list1.next;
                    }else{
                        next.next = list2;
                        list2 = list2.next;
                    }
                }else{
                    //list2 == null
                    next.next = list1;
                    list1 = list1.next;
                }
            }else{
                //list1 == null, list2 != null
                next.next = list2;
                list2 = list2.next;
            }
            next = next.next;
        }
        return head.next;

    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode next = head;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                next.next = list1;
                list1 = list1.next;
            }else{
                next.next = list2;
                list2 = list2.next;
            }

            next = next.next;
        }
        if(list1 == null){
            next.next = list2;
        }else{
            next.next = list1;
        }
        return head.next;

    }
}
