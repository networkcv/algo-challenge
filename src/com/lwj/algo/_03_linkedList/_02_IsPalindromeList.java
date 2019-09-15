package com.lwj.algo._03_linkedList;

import com.lwj.algo._00_utils.BaseUtils;
import com.lwj.algo._00_utils.Node;
import org.junit.Test;

import java.util.Stack;

/**
 * create by lwj on 2019/9/15
 * 判断一个链表是否为回文结构
 */
public class _02_IsPalindromeList {
    @Test
    public void test() {
        Node head1 = BaseUtils.toLinkedList(1, 2, 3, 3, 2, 1);
        Node head2 = BaseUtils.toLinkedList(1, 2, 3, 2, 1);
        Node head3 = BaseUtils.toLinkedList(1, 2, 3, 4, 2, 1);
        boolean res1 = isPalindromeList(head1);
        boolean res2 = isPalindromeList(head2);
        boolean res3 = isPalindromeList(head3);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    //使用辅助栈
    private boolean isPalindromeList1(Node head) {
        Node tmpHead = head;
        Stack stack = new Stack();
        while (tmpHead != null) {
            stack.add(tmpHead);
            tmpHead = tmpHead.next;
        }
        while (stack.size() != 0) {
            Node pop = (Node) stack.pop();
            if (pop.value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //先用双指针找到中点，再使用反转链表的方式，进行原地判断
    private boolean isPalindromeList(Node head) {
        Node q = head;
        Node s = head;
        //如果5个元素，则s会指到第3个，如果6个元素，则s也会指到第3个
        while (q.next != null && q.next.next != null) {
            q = q.next.next;
            s = s.next;
        }
        Node next;
        Node pre = null;
        while (s != null) {
            next = s.next;
            s.next = pre;
            pre = s;
            s = next;
        }
        // 1->2->3<-2<-1
        // 1->2->3<-3<-2<-1
        // 只有有一边的链表节点为空就退出循环
        while (head != null && pre != null) {
            if (head.value != pre.value) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }
}
