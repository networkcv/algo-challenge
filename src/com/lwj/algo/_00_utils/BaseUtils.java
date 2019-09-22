package com.lwj.algo._00_utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * create by lwj on 2019/9/2
 */
public class BaseUtils {

    /**
     * 数组转双向链表
     */
    public static DoubleNode toDobuleLinkedList(int... ints) {
        return ArrayToDobuleLinkedList(ints);
    }

    private static DoubleNode ArrayToDobuleLinkedList(int[] arr) {
        if (arr.length == 0) {
            throw new RuntimeException("array size is 0");
        }
        DoubleNode pre = new DoubleNode(arr[0]);
        DoubleNode head = pre;
        if (arr.length == 1) {
            return head;
        }
        for (int i = 1; i < arr.length; i++) {
            DoubleNode curNode = new DoubleNode(arr[i]);
            pre.next = curNode;
            curNode.last = pre;
            pre = curNode;
        }
        return head;
    }

    /**
     * 数组转单链表
     */
    public static Node toLinkedList(int... ints) {
        return arrayToLinkedList(ints);
    }

    private static Node arrayToLinkedList(int[] arr) {
        if (arr.length == 0) {
            throw new RuntimeException("array size is 0");
        }
        Node preNode = new Node(arr[0]);
        Node head = preNode;
        if (arr.length == 1) {
            return head;
        }
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            preNode.next = node;
            preNode = node;
        }
        return head;
    }

    /**
     * array to list
     */
    public static List<Integer> toList(int... ints) {
        return arrayToList(ints);
    }

    private static List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<Integer>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * 交换数组中的两个数
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 判断传入的两个集合是否相等
     */
    public static boolean isEqual(Collection<Integer> l1, Collection<Integer> l2) {
        if (l1 == null || l2 == null) {
            return false;
        }
        if (l1.size() != l2.size()) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : l1) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            map.put(i, map.get(i) + 1);
        }
        for (Integer i : l2) {
            if (!map.containsKey(i)) {
                return false;
            }
            map.put(i, map.get(i) - 1);
            if (map.get(i) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 生成一个长度在[0,maxSize]  大小在[0,maxValue] 之间 随机数组
     */
    public static int[] generateRandomArray(Integer maxSize, Integer maxValue) {
        int[] arr = new int[getOneInt(maxSize)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getOneInt(maxValue);
        }
        return arr;
    }

    /**
     * 打印数组
     */
    public static void printl(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * 打印集合
     */
    public static void printl(Collection c) {
        System.out.println(c);
    }

    /**
     * 打印单链表
     */
    public static void printl(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 打印双向链表
     */
    public static void printl(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    /**
     * 图形化 打印二叉树
     */
    public static void printl(TreeNode head) {
        System.out.println("Binary Tree:");
        printl(head, 0, "H", 17);
        System.out.println();
    }

    private static void printl(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printl(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printl(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    /**
     * 获取[0,10]内的整数
     */
    public static int getOneInt(Integer i) {
        return (int) ((i + 1) * Math.random());
    }


}
