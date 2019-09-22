package com.lwj.algo._06_tree;

import com.lwj.algo._00_utils.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * create by lwj on 2019/9/22
 * 遍历二叉树
 * 递归版及非递归版
 */
public class _01_PreInPosTraversal {
    @Test
    public void test() {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
        // unrecursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);
    }


    void preOrderRecur(TreeNode head) {
        if (head == null) return;
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    void inOrderRecur(TreeNode head) {
        if (head == null) return;
        preOrderRecur(head.left);
        System.out.print(head.value + " ");
        preOrderRecur(head.right);
    }

    void posOrderRecur(TreeNode head) {
        if (head == null) return;
        preOrderRecur(head.left);
        preOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    private void preOrderUnRecur(TreeNode head) {
        System.out.print("pre-order: ");
        if (head == null) return;
        Stack<TreeNode> stack = new Stack();
        stack.add(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println();
    }


    private void inOrderUnRecur(TreeNode head) {
        System.out.println("in-order");
        if (head==null)return;
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty()||head!=null){
            if (head!=null){
                stack.push(head);
                head=head.left;
            }else {
            }
        }

    }

    private void posOrderUnRecur1(TreeNode head) {
    }

    private void posOrderUnRecur2(TreeNode head) {
    }
}
