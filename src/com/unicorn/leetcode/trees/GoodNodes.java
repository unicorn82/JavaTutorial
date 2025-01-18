package com.unicorn.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class GoodNodes {

    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return loopNodes(root, Integer.MIN_VALUE);


    }

    private int loopNodes(TreeNode node, int max){
        int count = 0;
        if(node == null) return count;
        if(node.val >= max){
            count++;
            max = node.val;
        }
        count += loopNodes(node.left, max);
        count += loopNodes(node.right, max);

        return count;
    }
}
