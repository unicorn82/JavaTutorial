package com.unicorn.leetcode.trees;

public class IsSubtree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;


        if(root.val == subRoot.val){
            if(isSameTree(root, subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    private boolean isSameTree(TreeNode node, TreeNode subRoot){
        if(node == null && subRoot == null) return true;
        if(node == null || subRoot == null) return false;
        if(node.val == subRoot.val){
            return isSameTree(node.left, subRoot.left) && isSameTree(node.right, subRoot.right);
        }
        return false;


    }

    public boolean isSubtree_best(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return root == subRoot;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || (root.val == subRoot.val && isIdentical_best(root.left, subRoot.left) && isIdentical_best(root.right, subRoot.right));
    }

    public boolean isIdentical_best(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) return r1 == r2;
        return r1.val == r2.val && isIdentical_best(r1.left, r2.left) && isIdentical_best(r1.right, r2.right);
    }
}
