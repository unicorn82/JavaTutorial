package com.unicorn.leetcode.tree;

public class LowestCommonAncestor {
    int found = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode leftNode = lowestCommonAncestor(root.left, p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p,q);

        if(leftNode != null && rightNode != null){
            return root;
        }else if(leftNode != null){
            return leftNode;

        }else if (rightNode != null){
            return rightNode;
        }

        return null;

    }



    public static void main(String[] args) {

//        Integer[] list = new Integer[]{6,2,8,0,4,7,9,null,null,3,5};

        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(9);
        TreeNode n8 = new TreeNode(3);
        TreeNode n9 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;

        LowestCommonAncestor l1 = new LowestCommonAncestor();
        TreeNode t = l1.lowestCommonAncestor(n1, n2,n3);
        System.out.println(t.val);



    }
}
