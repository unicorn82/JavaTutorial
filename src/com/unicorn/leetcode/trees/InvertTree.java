package com.unicorn.leetcode.trees;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;;
        invertTree(root.right);
        invertTree(root.left);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;

    }
}
