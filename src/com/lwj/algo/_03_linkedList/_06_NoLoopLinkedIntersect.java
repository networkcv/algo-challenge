package com.lwj.algo._03_linkedList;

import com.lwj.algo._00_utils.Node;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * create by lwj on 2019/9/20
 * 判断无环链表是否相交,如果相交则返回交点
 */
public class _06_NoLoopLinkedIntersect {
    @Test
    public void test() {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);


        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6

        //10->11
        Node head3 = new Node(10);
        head3.next = new Node(11);
        System.out.println(noLoopLinkedIntersect(head1, head2));
        System.out.println(noLoopLinkedIntersect(head1, head3));
    }

    //哈希法
    Node noLoopLinkedIntersect0(Node head1, Node head2) {
        Set<Node> set = new HashSet();
        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (set.contains(head2)) return head2;
            head2 = head2.next;
        }
        return null;
    }

    //快慢指针法
    Node noLoopLinkedIntersect(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int n = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1 != null) {
            cur1 = cur1.next;
            n++;
        }
        while (cur2 != null) {
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
    }
}
