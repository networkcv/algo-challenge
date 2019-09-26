package com.lwj.algo._06_tree;

import com.lwj.algo._00_utils.TreeNode;
import org.junit.Test;

/**
 * create by lwj on 2019/9/26
 * 判断是否为平衡二叉树
 * 平衡二叉树中，任意节点的左子树和右子树高度相差不超过1
 */
public class _04_IsBalancedTree {
    @Test
    public void test() {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        System.out.println(IsBalancedTree(head).isB);


    }

    //封装返回值-递归方法
    Res IsBalancedTree(TreeNode head) {
        if (head == null)
            return new Res(true, 0);
        Res res1 = IsBalancedTree(head.left);
        if (!res1.isB)
            return new Res(false, -1);
        Res res2 = IsBalancedTree(head.right);
        if (!res2.isB)
            return new Res(false, -1);
        if (Math.abs(res1.h - res2.h) > 1) {
            return new Res(false, -1);
        }
//        return res1.h-res2.h>0?new Res(true,res1.h+1):new Res(true,res2.h+1);
        return new Res(true, Math.max(res1.h, res2.h) + 1);
    }

    public class Res {
        private boolean isB;
        private int h;

        public Res(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    //
}
