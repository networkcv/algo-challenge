package com.lwj.algo._06_tree;

import com.lwj.algo._00_utils.TreeNode;
import org.junit.Test;
import org.omg.CORBA.NO_IMPLEMENT;

import java.util.LinkedList;
import java.util.Queue;

import static com.lwj.algo._00_utils.BaseUtils.printl;

/**
 * create by lwj on 2019/9/24
 */
public class _03_SerializeAndReconstructTree {
    @Test
    public void test() {
        TreeNode head = null;
        printl(head);

        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printl(head);

        String level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printl(head);

        String level1 = serialByLevel1(head);
        System.out.println("serialize tree by level-叶神: " + level1);
        head = reconByLevelString1(level1);
        System.out.print("reconstruct tree by level-叶神, ");
        printl(head);

        System.out.println("====================================");

        head = new TreeNode(1);
        printl(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printl(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printl(head);

        level1 = serialByLevel1(head);
        System.out.println("serialize tree by level-叶神: " + level1);
        head = reconByLevelString1(level1);
        System.out.print("reconstruct tree by level-叶神, ");
        printl(head);
        System.out.println("====================================");

        head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(5);
        printl(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printl(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printl(head);

        level1 = serialByLevel1(head);
        System.out.println("serialize tree by level-叶神: " + level1);
        head = reconByLevelString1(level1);
        System.out.print("reconstruct tree by level-叶神, ");
        printl(head);

        System.out.println("====================================");

        head = new TreeNode(100);
        head.left = new TreeNode(21);
        head.left.left = new TreeNode(37);
        head.right = new TreeNode(-42);
        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(666);
        printl(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printl(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printl(head);

        level1 = serialByLevel1(head);
        System.out.println("serialize tree by level-叶神: " + level1);
        head = reconByLevelString1(level1);
        System.out.print("reconstruct tree by level-叶神, ");
        printl(head);
        System.out.println("====================================");


    }


    //按层序列化
    private String serialByLevel(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(head);
        String res = "";
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                res += "#!";
            } else {
                res += poll.value + "!";
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return res;
    }

    private TreeNode reconByLevelString(String level) {
        String[] values = level.split("!");
        int index = 0;
        TreeNode head = generateNodeByString(values[index++]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (head != null) {
            queue.offer(head);
        }
        TreeNode node = null;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            cur.left = getTreeNode(values[index++]);
            cur.right = getTreeNode(values[index++]);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return head;
    }

    private TreeNode getTreeNode(String tar) {
        if (tar.equals("#")) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(tar));
        }
    }

    //叶神-按层序列化
    public static String serialByLevel1(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.value + "!";
                queue.offer(head.left);
            } else {
                res += "#!";
            }
            if (head.right != null) {
                res += head.right.value + "!";
                queue.offer(head.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }

    public static TreeNode reconByLevelString1(String levelStr) {
        String[] values = levelStr.split("!");
        int index = 0;
        TreeNode head = generateNodeByString(values[index++]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (head != null) {
            queue.offer(head);
        }
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;
    }

    public static TreeNode generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }

    //按先序遍历序列化
    String serialByPre(TreeNode node) {
        if (node == null) {
            return "#!";
        }
        String res = node.value + "!";
        res += serialByPre(node.left);
        res += serialByPre(node.right);
        return res;
    }

    TreeNode reconByPreString(String str) {
        String[] strs = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            queue.offer(strs[i]);
        }
        return reconPreOrder(queue);
    }

    private TreeNode reconPreOrder(Queue<String> queue) {
        String p = queue.poll();
        if ("#".equals(p)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(p));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);
        return node;
    }
}
