package com.unicorn.leetcode.trees;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return validBST(root.left, null, root.val) && validBST(root.right, root.val, null);

    }

    private boolean validBST(TreeNode node, Integer min, Integer max){
        if(node == null) return true;
        if(min != null && node.val <= min || max != null && node.val >=max){
            return false;
        }


        return validBST(node.left, min, node.val) && validBST(node.right, node.val, max);

    }

}
