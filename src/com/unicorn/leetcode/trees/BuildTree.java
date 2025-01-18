package com.unicorn.leetcode.trees;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    int[] preorder;
    int[] inorder;
    int pre_index = 0;
    Map<Integer,Integer> map = new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i=0;i<inorder.length; i++){
            map.put(inorder[i], i);
        }


        return buildTree( 0, inorder.length-1);


    }

    private TreeNode buildTree( int in_left, int in_right){
        if(in_left > in_right || pre_index >= preorder.length){
            return null;
        }
        int val = this.preorder[pre_index++];
        TreeNode root = new TreeNode(val);
        int mid = map.get(val);
        root.left = buildTree(in_left, mid-1);
        root.right = buildTree(mid+1, in_right);

        return root;


    }
}
