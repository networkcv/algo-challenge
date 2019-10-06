package com.lwj.algo._03_linkedList;

import com.lwj.algo._00_utils.Node;
import org.junit.Test;

import static com.lwj.algo._00_utils.BaseUtils.printl;
import static com.lwj.algo._00_utils.BaseUtils.toLinkedList;

/**
 * create by lwj on 2019/10/6
 * 合并两个有序链表
 */
public class _10_MergeOrderList {
    @Test
    public void test() {
        Node head1 = toLinkedList(1, 2, 3, 5, 7, 9);
        Node head2 = toLinkedList(0, 4, 6, 8, 10);
        Node node1 = mergeOrderedListUnCur(head1, head2);
        Node node2 = mergeOrderedListReCur(head1, head2);
        printl(node1);
        printl(node2);
    }

    //非递归版
    public Node mergeOrderedListUnCur(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node res = new Node(-1);
        Node result = res;
        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                res.next = new Node(head1.value);
                head1 = head1.next;
            } else {
                res.next = new Node(head2.value);
                head2 = head2.next;
            }
            res = res.next;
        }
        if (head1 == null) {
            res.next = head2;
        } else {
            res.next = head1;
        }
        return result.next;

    }

    //递归版
    public Node mergeOrderedListReCur(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.value <= head2.value) {
            head1.next = mergeOrderedListReCur(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeOrderedListReCur(head1, head2.next);
            return head2;
        }
    }
}
