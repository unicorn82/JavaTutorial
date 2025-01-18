package com.unicorn.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

class DistNode {
    int key;
    int value;
    DistNode next;
    DistNode pre;

    public DistNode(){

    }

    public DistNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int size = 0;
    Map<Integer, DistNode> map;
    DistNode head;
    DistNode tail;

    public LRUCache(int capacity) {
        map = new HashMap();
        size = capacity;

    }


    public int get(int key) {
        if(map.containsKey(key)){

            DistNode node = map.get(key);
            if(node != tail){
                if(node == head){
                    head = head.next;
                    head.pre = null;
                }else{
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }

                tail.next = node;
                node.pre = tail;
                tail = tail.next;
                node.next = null;
            }


            return node.value;
        }
        return -1;


    }

    public void put(int key, int value) {
        DistNode node;
        if(map.containsKey(key)){
            node = map.get(key);
            node.value = value;
            get(key);
            return;

        }
        node  = new DistNode(key, value);
        map.put(key, node);

        if(head == null) {
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.pre = tail;
            tail = node;
        }

        size --;

        if(size < 0){ //evict
            map.remove(head.key);
            head = head.next;
            head.pre = null;
            size ++;
        }
        return;

    }


    public static void main(String[] args) {
        LRUCache l  = new LRUCache(1);
        l.put(2,1);
        System.out.println(l.get(2));
        l.put(3,2);
        System.out.println(l.get(2));
        System.out.println(l.get(3));

    }
}
