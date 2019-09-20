package com.lwj.algo._03_linkedList;

import com.lwj.algo._00_utils.Node;
import org.junit.Test;

import java.util.HashSet;

/**
 * create by lwj on 2019/9/19
 * 检测链表是否有环，如果有，则返回入环节点
 */
public class _05_GetLoopNode {
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
        System.out.println(detectCycle(head1));


        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
//        System.out.println(getIntersectNode(head1, head2).value);
        System.out.println(detectCycle(head2));

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
        System.out.println(detectCycle(head1));

        // 0->9->8->2->3->4->5->6->7->4..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
//        System.out.println(getIntersectNode(head1, head2).value);
        System.out.println(detectCycle(head2));

        // 0->9->8->6->7->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
//        System.out.println(getIntersectNode(head1, head2).value);
        System.out.println(detectCycle(head2));


    }

    //哈希法
    private Node detectCycle0(Node node) {
        HashSet<Node> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }

    //快慢指针数学归纳法
    private Node detectCycle(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node q = head.next.next;
        Node s = head.next;
        while (q != s) {
            if (q.next == null || q.next.next == null) {
                return null;
            }
            q = q.next.next;
            s = s.next;
        }
        //此时q和s指向同一节点
        q = head;
        while (q != s) {
            q = q.next;
            s = s.next;
        }
        return q;


    }
}
