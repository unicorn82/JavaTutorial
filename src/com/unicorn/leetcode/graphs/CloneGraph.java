package com.unicorn.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap();

        return cloneNode(map, node);

    }

    private Node cloneNode(Map<Integer, Node> map, Node node){
        if(node == null) return null;
        Node targetNode = map.get(node.val);
        if(targetNode == null){
            targetNode = new Node(node.val);
            map.put(node.val, targetNode);

            for(Node neighbor: node.neighbors){
                targetNode.neighbors.add(cloneNode(map, neighbor));
            }
        }


        return targetNode;


    }

}
