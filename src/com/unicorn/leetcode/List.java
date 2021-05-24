package com.unicorn.leetcode;


/**
 * Definition for singly-linked list.
 *
 */
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class List {



        public ListNode reverseList(ListNode head) {
            ListNode nextNode = head.next;
            if(nextNode.next == null){
                nextNode.next = head;
                return nextNode;
            }
            ListNode newHead = reverseList(nextNode);
            nextNode.next = head;
            head.next = null;

            return newHead;


        }

    public ListNode reverseList2(ListNode head) {
        ListNode previous = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = previous;
            previous = head;
            head = temp;
            System.out.println(previous.val+" "+previous.next);
        }

        return previous;
    }


    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode previousNode = new ListNode(0, head);
        ListNode beginNode = head.next;
        ListNode nextNode = head.next;
        while(nextNode != null){
            head.next = nextNode.next;
            nextNode.next = head;
            previousNode.next = nextNode;
            previousNode = head;
            head = head.next;
            nextNode = head  == null ? null: head.next;
        }
        return beginNode;
    }

    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    public ListNode reverseKGroup(ListNode head, int k){
            if(head == null || k<=0){
                return head;
            }
            ListNode endNode = head;
            ListNode startNode = new ListNode(0, head);
            head = startNode;
            printAllNodes(startNode);
            int count = 0;
            while(endNode != null){
                count ++;
                if(count == k){
                    System.out.println("start node "+startNode.next.val+" end node "+endNode.val);
                    ListNode preEndNode = startNode.next;
                    startNode.next = reverseInGroup(startNode.next, endNode);

//                    printAllNodes(head);
                    count = 0;

                    startNode = preEndNode;
                    endNode = startNode;
                }
                endNode = endNode.next;



            }
            return head.next;
    }

    public ListNode reverseinGroupRecusive(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseinGroupRecusive(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }




    public ListNode reverseInGroup(ListNode headNode, ListNode endNode){
            ListNode curNode = headNode;
            ListNode nextNode = headNode.next;
            ListNode termNode = endNode.next;

            while (nextNode != termNode) {
                ListNode leapNode = nextNode.next;
                nextNode.next = curNode;
                headNode.next = leapNode;
                curNode = nextNode;
                nextNode = leapNode;

            }

            return curNode;
    }

    public void printAllNodes(ListNode headNode){
            ListNode nextNode = headNode;
            while (nextNode != null){
                System.out.print(nextNode.val+"; ");
                nextNode = nextNode.next;
            }

    }







    public static void main(String[] args) {
        System.out.println("start");
        List list = new List();
        ListNode l8 = new ListNode(8);
        ListNode l7 = new ListNode(7, l8);
        ListNode l6 = new ListNode(6, l7);
        ListNode l5 = new ListNode(5, l6);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

//        ListNode headNode = list.reverseInGroup(l1, l5);

//        ListNode l = list.swapPairs(l1);

//        ListNode dump = list.reverseKGroup(l1, 4);
        ListNode head = list.reverseinGroupRecusive(l1, 3);

        list.printAllNodes(head);


//        System.out.println(l.val);



        //Solution s = new Solution();

    }



}
