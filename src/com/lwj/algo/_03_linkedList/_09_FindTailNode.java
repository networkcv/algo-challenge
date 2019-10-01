package com.lwj.algo._03_linkedList;

import com.lwj.algo._00_utils.Node;
import org.junit.Test;

import static com.lwj.algo._00_utils.BaseUtils.toLinkedList;

/**
 * create by lwj on 2019/10/1
 * 查找链表倒数第n个节点
 */
public class _09_FindTailNode {
    @Test
    public void test() {
        Node head = toLinkedList(1, 2, 3, 4);
//        System.out.println(findTailNode(head, 0));
        System.out.println(findTailNode(head, 1));
        System.out.println(findTailNode(head, 2));
        System.out.println(findTailNode(head, 3));
        System.out.println(findTailNode(head, 4));
//        System.out.println(findTailNode(head, 5));
    }

    private Node findTailNode(Node head, int n) {
        if (n < 1 || head == null) {
            throw new RuntimeException("输入错误");
        }
        Node q = head;
        Node s = head;
        while (n > 0 && q != null) {
            q = q.next;
            n--;
        }
        if (n == 0 && q == null) {
            return s;
        } else if (q == null) {
            throw new RuntimeException("输入越界");
        }
        while (q != null) {
            q = q.next;
            s = s.next;
        }
        return s;
    }

}
