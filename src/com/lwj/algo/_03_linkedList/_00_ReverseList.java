package com.lwj.algo._03_linkedList;

import com.lwj.algo._00_utils.DoubleNode;
import com.lwj.algo._00_utils.Node;
import org.junit.Test;

import static com.lwj.algo._00_utils.BaseUtils.*;

/**
 * create by lwj on 2019/9/13
 * 反转链表
 */
public class _00_ReverseList {
    @Test
    public void test() {
        printl(toLinkedList(4, 3, 2, 1));
        printl(reverseList(toLinkedList(4, 3, 2, 1)));

        printl(toDobuleLinkedList(5, 6, 7, 8));
        printl(reverseList(toDobuleLinkedList(5, 6, 7, 8)));
    }

    /**
     * 反转单链表
     */
    private Node reverseList(Node head) {
        Node curNode = head;
        Node pre = null;
        Node next;
        while (curNode != null) {
            next = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = next;
        }
        return pre;
    }

    /**
     * 反转双向链表
     */
    private DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }


}
