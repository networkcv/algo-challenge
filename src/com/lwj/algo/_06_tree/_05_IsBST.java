package com.lwj.algo._06_tree;

import com.lwj.algo._00_utils.TreeNode;
import org.junit.Test;

import java.util.Stack;

import static com.lwj.algo._00_utils.BaseUtils.printl;

/**
 * create by lwj on 2019/9/27
 * 判断是否是搜索二叉树
 * 搜索二叉树：当前节点比左子树大比右子树小
 * 递归版：将子树的值和子树是否满足封装到一个实体里返回
 * 非递归版：在非递归中序遍历上做了一些修改，判断前一个数是否比后一个数小
 */
public class _05_IsBST {
    @Test
    public void test() {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(5);

        printl(head);
        System.out.println(isBSTRecur(head).isB);
        System.out.println(isBSTNoRecur(head));
    }


    //递归版
    private Res isBSTRecur(TreeNode head) {
        if (head == null) return new Res(true, -1);
        Res bstL = isBSTRecur(head.left);
        Res bstR = isBSTRecur(head.right);
        if (bstL.isB && bstR.isB) {
            if (bstR.v == -1) {
                if (bstL.v < head.value) {
                    return new Res(true, head.value);
                }
            } else {
                if (bstL.v < head.value && bstR.v > head.value) {
                    return new Res(true, head.value);
                }
            }
        }
        return new Res(false, -1);
    }

    private class Res {
        boolean isB;
        int v;

        public Res(boolean isB, int v) {
            this.isB = isB;
            this.v = v;
        }
    }

    //非递归版
    public boolean isBSTNoRecur(TreeNode head) {
        if (head == null) return true;
        int pre = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre >= head.value) {
                    return false;
                }
                pre = head.value;
                head = head.right;
            }
        }
        return true;
    }

}
