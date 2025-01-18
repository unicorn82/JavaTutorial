package com.unicorn.algorithm;

import javax.swing.tree.TreeNode;

public class AvlTree {

    class TreeNode {

        private int val;
        private int height;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
            height = 0;

        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public int getHeight() {
            return height;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }
    }



    public TreeNode insertAvlTree(int[] nums){
        if(nums == null || nums.length ==0)
            return null;

        TreeNode header = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {

            TreeNode treeNode = new TreeNode(nums[i]);
            header = insertTree(header, treeNode);

        }


        return header;

    }

    public void printAvlTree(TreeNode header){
        if(header != null){
            printAvlTree(header.left);
            System.out.print(";"+header.val+";");
            printAvlTree(header.right);
        }
        return;
    }

    private void calculateHeight(TreeNode headerNode){
        int left = headerNode.left == null? -1: headerNode.left.height;
        int right = headerNode.right == null? -1: headerNode.right.height;
        headerNode.height = Math.max(left, right)+1;
    }

    private TreeNode insertTree(TreeNode headerNode, TreeNode treeNode){

        if(treeNode.val < headerNode.val){
            if(headerNode.left == null){
                headerNode.left = treeNode;

            }else{
                headerNode.left = insertTree(headerNode.left, treeNode);
            }
            headerNode.height = Math.max(headerNode.left.height+1 , headerNode.height);

        }else{
            if(headerNode.right == null){
                headerNode.right = treeNode;
            }else{
                headerNode.right = insertTree(headerNode.right, treeNode);
            }
            headerNode.height = Math.max(headerNode.right.height+1, headerNode.height);

        }
        if(validatebalance(headerNode) > 1){
            return balanceRightTree(headerNode);
        }else if(validatebalance(headerNode) < -1){
            return balanceleftTree(headerNode);
        }else{
            return headerNode;
        }
    }

    private int validatebalance(TreeNode headerNode){ // 0: balance, 1: right heavy, -1: left heavy
        int left = headerNode.left == null? -1: headerNode.left.height;
        int right = headerNode.right == null? -1: headerNode.right.height;

        return right-left;
//        if(Math.abs(left-right) < 2) return 0;
//        else if(right> left) return 1;
//        else return -1;
    }

    private TreeNode balanceRightTree(TreeNode headerNode){
        TreeNode rightNode = headerNode.right;
        if(validatebalance(rightNode) > -1){
            //left rotate
            headerNode.right = rightNode.left;
            rightNode.left = headerNode;
            calculateHeight(headerNode);
            calculateHeight(rightNode);
            return rightNode;


        }else{
            TreeNode newHeader = rightNode.left;
            headerNode.right = newHeader.left;
            rightNode.left = newHeader.right;
            newHeader.left = headerNode;
            newHeader.right = rightNode;
            calculateHeight(headerNode);
            calculateHeight(rightNode);
            calculateHeight(newHeader);
            return newHeader;


        }

    }

    private TreeNode balanceleftTree(TreeNode headerNode){
        TreeNode leftNode = headerNode.left;
        if(validatebalance(leftNode) < 1){
            headerNode.left = leftNode.right;
            leftNode.right = headerNode;
            calculateHeight(headerNode);
            calculateHeight(leftNode);
            return leftNode;
        }else{
            TreeNode newHeader = leftNode.right;
            headerNode.left = newHeader.right;
            leftNode.right = newHeader.left;
            newHeader.right = headerNode;
            newHeader.left = leftNode;
            calculateHeight(headerNode);
            calculateHeight(leftNode);
            calculateHeight(newHeader);
            return newHeader;
        }


    }




    public static void main(String[] args) {
        int k = 3;

        AvlTree scheduler = new AvlTree();
        int[] nums = new int[]{56, 57, 60, 37, 36, 46, 44, 49, 50 };
        TreeNode header = scheduler.insertAvlTree(nums);
        scheduler.printAvlTree(header);


    }
}
