package com.lwj.algo._03_linkedList;

import com.lwj.algo._00_utils.BaseUtils;
import com.lwj.algo._00_utils.Node;
import org.junit.Test;

import static com.lwj.algo._00_utils.BaseUtils.printl;
import static com.lwj.algo._00_utils.BaseUtils.swap;

/**
 * create by lwj on 2019/9/16
 * 链表版荷兰国旗问题
 */
public class _03_SmallerEqualBigger {
    @Test
    public void test() {
        Node head = BaseUtils.toLinkedList(1, 3, 4, 2, 5, 7, 6);
        for (int i = 0; i < 9; i++) {
            System.out.print(i + ":");
            printl(smallerEqualBigger(head, i));
            System.out.print(i + ":");
            printl(smallerEqualBigger1(head, i));
        }
    }

    //使用辅助数组，转化为数组版荷兰国旗问题
    private Node smallerEqualBigger(Node head, int target) {
        int count = 0;
        Node tmpHead = head;
        while (tmpHead != null) {
            count++;
            tmpHead = tmpHead.next;
        }
        tmpHead = head;
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = tmpHead.value;
            tmpHead = tmpHead.next;
        }

        int i = -1;
        int j = arr.length;
        int k = 0;
        while (k < j) {
            if (arr[k] < target) {
                swap(arr, k++, ++i);
            } else if (arr[k] > target) {
                swap(arr, k, --j);
            } else {
                k++;
            }
        }

        Node curNode = new Node(arr[0]);
        head = curNode;
        Node pre = curNode;
        for (int kk = 1; kk < arr.length; kk++) {
            curNode = new Node(arr[kk]);
            pre.next = curNode;
            pre = curNode;
        }
        return head;
    }

    //使用三对指针分别指向小于区域的头尾，等于区域的头尾，大于区域的头尾
    //然后进行将这三对指针进行整合
    private Node smallerEqualBigger1(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node bH = null; // big head
        Node bT = null; // big tail
        Node next = null; // save next node
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        // small and equal reconnect
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        // all reconnect
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }
}
