package com.unicorn.leetcode.trees;

import java.util.Stack;

public class KthSmallest {
    int count;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;

        loopNode(root);
        return result;

    }

    private void loopNode(TreeNode node){
        if(node.left != null){//push left node recuisively
            loopNode(node.left);
        }
        //visit node

        if(this.count > 0){
            this.count --;
            if(this.count == 0){
                result = node.val;
            }
        }
        if(node.right != null){
            loopNode(node.right);
        }

    }

    public int kthSmallest_BFS(TreeNode root, int k) {
        Stack<TreeNode> stacks = new Stack();
        TreeNode node = root;
        stacks.add(node);
        while(node.left != null){
            node = node.left;
            stacks.add(node);
        }
        while(k>0){
            node = stacks.pop();
            k--;
            if(k==0){
                return node.val;
            }
            if(node.right != null){
                stacks.add(node.right);
                node = node.right;
                while(node.left != null){
                    stacks.add(node.left);
                    node = node.left;
                }
            }

        }
        return -1;



    }
}
