package com.unicorn.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if(root == null) return result;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> sublist = new ArrayList();
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                sublist.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                size--;
            }
            result.add(sublist);



        }
        return result;


    }
}
