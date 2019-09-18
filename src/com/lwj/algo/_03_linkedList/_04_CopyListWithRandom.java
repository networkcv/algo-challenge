package com.lwj.algo._03_linkedList;

import org.junit.Test;

import java.util.HashMap;

/**
 * create by lwj on 2019/9/17
 * 拷贝随机链表
 */
public class _04_CopyListWithRandom {
    @Test
    public void test() {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        System.out.println("=========================");

    }

    //哈希表法
    private Node copyListWithRand1(Node head) {
        HashMap<Node, Node> map = new HashMap();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 链表扩充快慢指针法
     */
    private Node copyListWithRand2(Node head) {
        if(head==null) return null;
        Node cur = head;
        Node next;
        //在原链表上进行复制
        //1->2->3  复制为  1->11->2->22->3->33
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        //添加新复制节点的随机节点
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            cur.next.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        //将链表分离
        //1->11->2->22->3->33  分离为 1->2->3   11->22->33
        Node res=head.next;
        cur=head;
        Node cp;
        while(cur!=null){
            next=cur.next.next;     //复制后的链表肯定是偶数个，所以cur.next肯定不为空
            cp=cur.next;
            cur.next=next;
            cp.next=next==null?null:next.next;      //cur=3时  next=cur.next.next   此时next为null，next.next 会报空指针
            cur=next;
        }
        return res;

    }

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
