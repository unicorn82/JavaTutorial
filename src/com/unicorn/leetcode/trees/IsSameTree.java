package com.unicorn.leetcode.trees;



import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        boolean isLeft = isSameTree(p.left, q.left);
        boolean isRight = isSameTree(p.right, q.right);
        return isLeft && isRight;

    }

    public boolean isSameTree_DFS(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        Stack<TreeNode> p_stack = new Stack();
        Stack<TreeNode> q_stack = new Stack();
        p_stack.push(p);
        q_stack.push(q);
        while(!p_stack.isEmpty()){
            TreeNode node_p = p_stack.pop();
            TreeNode node_q = q_stack.pop();
            if(node_p.val != node_q.val){
                return false;
            }
            if(node_p.left != null && node_q.left != null){ //push
                p_stack.push(node_p.left);
                q_stack.push(node_q.left);
            }else if(node_p.left == null && node_q.left == null){

            }else{
                return false;
            }
            if(node_p.right != null && node_q.right != null){ //push
                p_stack.push(node_p.right);
                q_stack.push(node_q.right);
            }else if(node_p.right == null && node_q.right == null){

            }else{
                return false;
            }
        }

        return q_stack.isEmpty();

    }
    public boolean isSameTree_BFS(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        Queue<TreeNode> q1 = new ArrayDeque();
        Queue<TreeNode> q2 = new ArrayDeque();
        q1.add(p);
        q2.add(q);
        while(!q1.isEmpty()){
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            if(n1.val != n2.val) return false;
            if(n1.left != null && n2.left != null){
                q1.add(n1.left);
                q2.add(n2.left);
            }else if(n1.left == null && n2.left == null){

            }else{
                return false;
            }
            if(n1.right != null && n2.right != null){
                q1.add(n1.right);
                q2.add(n2.right);
            }else if(n1.right == null && n2.right == null){

            }else{
                return false;
            }

        }
        return q2.isEmpty();

    }
}
