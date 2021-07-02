package com.unicorn.leetcode.tree;

import com.unicorn.utils.CollectionsUtils;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    private List<Integer> list = new ArrayList<>();

    TreeNode previous = null;

    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        loopTrees(root);
        if(list.size()>1) {
            for (int i = 1; i < list.size(); i++) {
               if (list.get(i)<list.get(i-1)){
                   return false;
               }

            }
        }


        return true;
    }

    private boolean loopTrees(TreeNode root) {
        if(root == null) return true;

        loopTrees(root.left);

        list.add(root.val);

        loopTrees(root.right);

        return true;

    }

    public boolean isValidBST3(TreeNode root) {
        if(root == null) return true;
        loopTrees3(root);



        return true;
    }

    private boolean loopTrees3(TreeNode root) {
        if(root == null) return true;

        if(!loopTrees3(root.left)){
            return false;
        }

        if(previous != null && previous.val>=root.val){
            return false;
        }
        previous = root;

        if(!loopTrees3(root.right)){
            return false;
        }

        return true;

    }



    public boolean isValidBST(TreeNode root) {
        return checkValidNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkValidNode(TreeNode node, int min, int max){
        if (node == null) return true;
        if(node.val <= min || node.val >= max) return false;

        if(!checkValidNode(node.left, min, node.val)) return false;
        if(!checkValidNode(node.right, node.val, max)) return false;
        return true;
    }

    public static void main(String[] args) {

        System.out.println("start");
        IsValidBST i = new IsValidBST();
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(i.isValidBST3(n1));
    }
}
