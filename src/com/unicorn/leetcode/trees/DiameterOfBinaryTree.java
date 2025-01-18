package com.unicorn.leetcode.trees;

public class DiameterOfBinaryTree {
    int max_diameter;
    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null) return 0;
        diameterOfNode(root);
        return max_diameter;

    }

    private int diameterOfNode(TreeNode node){
        if(node == null) return -1;

        int left = 1 + diameterOfNode(node.left);
        int right = 1 + diameterOfNode(node.right);
        int diameter = left + right;
        max_diameter = Math.max(max_diameter,diameter);

        return Math.max(left, right);

    }
}
