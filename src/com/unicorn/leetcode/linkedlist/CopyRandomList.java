package com.unicorn.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        Node p1 = head;
        Node copyHead = new Node(0);
        Node pre = copyHead;
        Map<Integer,Node> map = new HashMap();
        while(p1 != null){
            Node n = new Node(p1.val);
            pre.next = n;
            map.put(p1.hashCode(), n);

            pre = pre.next;
            p1 = p1.next;
        }
        p1 = head;
        Node p2 = copyHead.next;

        while(p1 != null){
            if(p1.random != null){
                Node rNode = map.get(p1.random.hashCode());
                p2.random = rNode;

            }
            p1 = p1.next;
            p2 = p2.next;

        }

        return copyHead.next;

    }
}
