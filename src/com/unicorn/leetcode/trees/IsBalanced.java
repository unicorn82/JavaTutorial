package com.unicorn.leetcode.trees;

import java.util.HashMap;
import java.util.Map;

public class IsBalanced {
    boolean isBalance = true;
    Map<TreeNode, Integer> heights = new HashMap();
    public boolean isBalanced1(TreeNode root) {
        if(root == null) return true;
        height(root);
        return isBalance;





    }

    private int height(TreeNode node){
        if(node == null) return -1;
        int left = height(node.left) + 1;
        int right = height(node.right) + 1;
        if(Math.abs(left - right) > 1){
            isBalance = false;
        }
        return Math.max(left, right);

    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        boolean isLeft = isBalanced(root.left);
        boolean isRight = isBalanced(root.right);
        if(!isLeft || !isRight) return false;
        int left = heights.getOrDefault(root.left, -1)+1;
        int right = heights.getOrDefault(root.right, -1)+1;
        heights.put(root, Math.max(left, right));
        return Math.abs(left - right) < 2;

    }
}
