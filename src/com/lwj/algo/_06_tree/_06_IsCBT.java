package com.lwj.algo._06_tree;

import com.lwj.algo._00_utils.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static com.lwj.algo._00_utils.BaseUtils.printl;

/**
 * create by lwj on 2019/9/28
 * 判断是否是完全二叉树
 * 完全二叉树：叶子节点从左往右分布，叶子节点那一层往上是满二叉树
 * 判断逻辑：
 * 通过按层遍历的方式
 * 当前节点有右子树，没有左子树，直接返回false
 * 如果当前节点有左子树无右子树或者当前节点是叶子节点，则之后遇到非叶子节点，直接返回false
 * 满足以上条件 返回true
 */
public class _06_IsCBT {
    @Test
    public void test() {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
//        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(5);

        printl(head);
        System.out.println(isCBT(head));
    }

    private boolean isCBT(TreeNode head) {
        if (head == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        TreeNode cur;
        boolean flag = false;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left == null && cur.right != null) {
                return false;
            }
            if (flag) {
                if (cur.left != null || cur.right != null)
                    return false;
            }
            if (cur.right == null) {
                flag = true;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return true;
    }

    //左神
    public static boolean isCBT1(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }
}
