package com.lwj.algo._03_linkedList;

import com.lwj.algo._00_utils.Node;
import org.junit.Test;

/**
 * create by lwj on 2019/9/20
 * 5,6,7 三道题的整合版
 * 查找两个链表的交点
 */
public class _08_FindFirstIntersectNode {
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
        System.out.println(findFirstIntersectNode(head1, head2));

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
        System.out.println(findFirstIntersectNode(head1, head2));

        // 0->9->8->2->3->4->5->6->7->4..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(findFirstIntersectNode(head1, head2).value);

        // 0->9->8->6->7->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(findFirstIntersectNode(head1, head2).value);
    }

    Node findFirstIntersectNode(Node head1, Node head2) {
        //检测是否有环
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            //无环链表找交点
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            //有环链表找交点
            return bothLoop(head1, head2, loop1, loop2);
        }
        return null;
    }


    private Node getLoopNode(Node head) {
        if (head == null || head.next == null)
            return null;
        Node q = head.next.next;
        Node s = head.next;
        while (q != s) {
            if (q == null || q.next == null) {
                return null;
            }
            q = q.next.next;
            s = s.next;
        }
        q = head;
        while (q != s) {
            q = q.next;
            s = s.next;
        }
        return q;
    }

    private Node noLoop(Node head1, Node head2) {
        int n = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1 != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            n--;
            cur2 = cur2.next;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n > 0) {
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    private Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        if (loop1 == loop2) {
            //入环前相交
            int n = 0;
            Node cur1 = head1;
            Node cur2 = head2;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
             n= Math.abs(n);
            while (n > 0) {
                cur1 = cur1.next;
                n--;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            //遍历环，判断相交情况
            //入环后相交或无交点
            Node cur = loop1.next;
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
