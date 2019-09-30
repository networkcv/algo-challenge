package com.lwj.algo._06_tree;

import com.lwj.algo._00_utils.TreeNode;

/**
 * create by lwj on 2019/9/29
 * 求一颗完全二叉树的节点个数，要求时间复杂度小于O(N)
 * 思路：
 * 1.一个满二叉树的节点个数为(2^h)-1，满二叉树是特殊的完全二叉树
 * 2.在完全二叉树中寻找满二叉树，通过公式得出其节点数，使时间复杂度小于O(N)
 */
public class _07_CompleteTreeNodeNumber {

    public static int nodeNum(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    public static int bs(TreeNode node, int l, int h) {
        if (l == h) {
            return 1;
        }
        if (mostLeftLevel(node.right, l + 1) == h) {
            //此处说明head的左子树为满二叉树
            //          1
            //      2       3
            //   4    5   6
            //左子树的所有节点：1 << (h - l))-1 ，当前节点：1 ，右子树所有节点：bs(node.right, l + 1, h)
            //  1 << h   <=>   2^h
            return (1 << (h - l)) - 1 + 1 + bs(node.right, l + 1, h);
        } else {
            //此处说明head的右子树为满二叉树
            //          1
            //      2       3
            //   4    5
            //左子树的所有节点： bs(node.left, l + 1, h)，当前节点：1 ，右子树所有节点：(1 << (h - l - 1)) - 1
            return (1 << (h - l - 1)) - 1 + 1 + bs(node.left, l + 1, h);
        }
    }

    public static int mostLeftLevel(TreeNode node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        System.out.println(nodeNum(head));
    }

}
