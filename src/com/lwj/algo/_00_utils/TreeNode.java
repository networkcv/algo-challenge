package com.lwj.algo._00_utils;

/**
 * create by lwj on 2019/9/22
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
