package com.unicorn.leetcode.trees;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor_recusive(TreeNode root, TreeNode p, TreeNode q) {
        if(q.val < p.val){
            return lowestCommonAncestor_recusive(root, q, p);
        }
        if(root.val > q.val){ // root.> q > p
            return lowestCommonAncestor_recusive(root.left, p, q);
        }else if (root.val < p.val){
            return lowestCommonAncestor_recusive(root.right, p, q);
        }
        return root;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(q.val < p.val){
            return lowestCommonAncestor(root, q, p);
        }
        TreeNode node = root;
        while(true){
            if(node.val > q.val){ // root.> q > p
                node = node.left;
            }else if (node.val < p.val){
                node = node.right;
            }else{
                break;
            }
        }
        return node;



    }
}
