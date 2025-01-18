package com.unicorn.leetcode.linkedlist;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while(n > 0){
            fast = fast.next;
            n--;
        }

        while(fast != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if(pre == null){
            return slow.next;
        }
        pre.next = slow.next;
        return head;


    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode pre = new ListNode();
        
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = head;
        while(n > 0){
            fast = fast.next;
            n--;
        }

        while(fast != null){

            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return pre.next;


    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode target = head;
        int count = 0;
        while(target != null){
            count++;
            target = target.next;
        }
        int move = count-n;
        System.out.println(move);
        target = head;
        System.out.println(target.val);
        ListNode parent = null;
        for(int i=0;i<move;i++){
            parent = target;
            System.out.println(target.val);
            target = target.next;
            System.out.println(target.val);


        }
        if(parent == null) return parent;
        parent.next = target.next;

        return head;


    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();
        p1.val = 1;
        p1.next = p2;
        p2.val = 2;

        RemoveNthFromEnd r = new RemoveNthFromEnd();
        r.removeNthFromEnd3(p1, 1);


    }
}
