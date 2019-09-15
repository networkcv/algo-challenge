package com.lwj.algo._03_linkedList;

import com.lwj.algo._00_utils.BaseUtils;
import com.lwj.algo._00_utils.Node;
import org.junit.Test;

/**
 * create by lwj on 2019/9/15
 * 打印两个有序链表的公共部分
 */
public class _01_PrintCommonPart {
    @Test
    public void test() {
        Node head1 = BaseUtils.toLinkedList(1, 2, 3, 4, 5, 6);
        Node head2 = BaseUtils.toLinkedList(4, 5, 6, 7, 8, 9);
        printCommonPart(head1, head2);
    }

    private void printCommonPart(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.value == head2.value) {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                head1 = head1.next;
            }
        }
        System.out.println();
    }
}
