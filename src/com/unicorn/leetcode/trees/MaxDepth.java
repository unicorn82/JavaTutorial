package com.unicorn.leetcode.trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));

    }

    public int maxDepth_DFS(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> treeStacks = new Stack();
        Stack<Integer> levelStacks = new Stack();

        int maxDepth = 1;
        treeStacks.push(root);
        levelStacks.push(maxDepth);
        while(!treeStacks.isEmpty()){
            TreeNode node = treeStacks.pop();
            int depth = levelStacks.pop();
            maxDepth = Math.max(depth, maxDepth);
            if(node.left != null){
                treeStacks.push(node.left);
                levelStacks.push(depth+1);
            }
            if(node.right != null){
                treeStacks.push(node.right);
                levelStacks.push(depth+1);
            }
        }

        return maxDepth;




    }

    public int maxDepth_BFS(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>() ;
        int level = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            //loop all in current queue
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            level ++;

        }
        return level;

    }
}
