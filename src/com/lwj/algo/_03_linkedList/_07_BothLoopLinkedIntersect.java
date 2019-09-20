package com.lwj.algo._03_linkedList;

import com.lwj.algo._00_utils.Node;
import org.junit.Test;

import java.util.HashSet;

/**
 * create by lwj on 2019/9/20
 * 判断有环链表是否相交，相交的话返回交点
 */
public class _07_BothLoopLinkedIntersect {
    @Test
    public void test() {
        Node head1, head2;
        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2->3->4->5->6->7->4..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(bothLoopLinkedIntersect(head1, head2).value);

        // 0->9->8->6->7->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(bothLoopLinkedIntersect(head1, head2).value);

    }


    Node bothLoopLinkedIntersect(Node head1, Node head2) {
        HashSet set = new HashSet();
        Node loop1;
        Node loop2;
        Node cur = head1;
        //获取链表的尾节点
        while (cur != null && !set.contains(cur)) {
            set.add(cur);
            cur = cur.next;
        }
        loop1 = cur;
        set.clear();
        cur = head2;
        while (cur != null && !set.contains(cur)) {
            set.add(cur);
            cur = cur.next;
        }
        loop2 = cur;
        //在入环前相交，可以转化为两个无环链表相交问题
        if (loop1 == loop2) {
            int n = 0;
            Node cur1 = head1;
            Node cur2 = head2;
            while (cur1 != loop1.next) {
                cur1 = cur1.next;
                n++;
            }
            while (cur2 != loop2.next) {
                cur2 = cur2.next;
                n--;
            }
            //为正的话说明head1长，为负的话说明head2长，长的先走，
            //cur1 指向长链表 cur2 指向短链表
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                cur1 = cur1.next;
                n--;
            }
            while (cur1 != cur2) {

                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            //带环链表不相交或者带环链表有不同的入环口
            cur = loop1.next;
            while (cur != loop1) {
                if (cur == loop2) {
                    return cur;
                }
                cur = cur.next;
            }
            return null;
        }
    }
}
