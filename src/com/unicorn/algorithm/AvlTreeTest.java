package com.unicorn.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvlTreeTest {

    @Test
    public void testAvlTree(){

        AvlTree avlTree = new AvlTree();
        int[] nums = new int[]{56, 57, 60, 37, 36, 46, 44, 49, 50 };
        AvlTree.TreeNode header = avlTree.insertAvlTree(nums);
        avlTree.printAvlTree(header);
        validateValTreeNode(header);

    }

    private void validateValTreeNode(AvlTree.TreeNode treeNode){
        if(treeNode == null) return;
        int left_val = treeNode.getLeft() == null? Integer.MIN_VALUE: treeNode.getLeft().getVal();
        int left_height = treeNode.getLeft() == null? -1: treeNode.getLeft().getHeight();
        int right_val = treeNode.getRight() == null? Integer.MAX_VALUE: treeNode.getRight().getVal();
        int right_height = treeNode.getRight() == null? -1: treeNode.getRight().getHeight();
        Assertions.assertTrue(treeNode.getVal() > left_val && treeNode.getVal() < right_val);
        Assertions.assertTrue(Math.abs(left_height - right_height)<2);

        validateValTreeNode(treeNode.getLeft());
        validateValTreeNode(treeNode.getRight());
    }

}