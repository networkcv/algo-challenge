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
        Node node = smallerEqualBigger1(head, 6);
        printl(node);
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
        //i = -1 ? j = arr.length
        int i = -1;
        int j = arr.length;
        int index = 0;
        while (index != j) {
            if (arr[index] > target) {
                swap(arr, index++, --j);
            } else if (arr[index] < target) {
                swap(arr, index++, ++i);
            } else {
                index++;
            }
        }
        Node curNode = new Node(arr[0]);
        head = curNode;
        Node pre = curNode;
        for (int k = 1; k < arr.length; k++) {
            curNode = new Node(arr[k]);
            pre.next = curNode;
            pre = curNode;
        }
        return head;
    }

    //使用三对指针进行链表组合
    private Node smallerEqualBigger1(Node head, int target) {
        Node smSta = null;
        Node smEnd = null;
        Node eqSta = null;
        Node eqEnd = null;
        Node biSta = null;
        Node biEnd = null;
        Node tmp = null;
        while (head != null) {
            if (head.value > target) {
                if (biSta == null) {
                    biSta = head;
                } else {
                    tmp = biSta;
                    while (tmp != biEnd) {
                        tmp = tmp.next;
                    }
                    tmp.next = head;
                }
                biEnd = head;
            } else if (head.value < target) {
                if (smSta == null) {
                    smSta = head;
                } else {
                    tmp = smSta;
                    while (tmp != smEnd) {
                        tmp = tmp.next;
                    }
                    tmp.next = head;
                }
                smEnd = head;
            } else {
                if (eqSta == null) {
                    eqSta = head;
                } else {
                    tmp = eqSta;
                    while (tmp != eqEnd) {
                        tmp = tmp.next;
                    }
                    tmp.next = head;
                }
                eqEnd = head;
            }
            head = head.next;
        }
        if (smSta != null) {
            tmp = smEnd;
            while (tmp != smEnd) {
                tmp = tmp.next;
            }
            tmp.next=null;
        }
        if (smSta != null) {
            tmp = smEnd;
            while (tmp != smEnd) {
                tmp = tmp.next;
            }
            tmp.next=null;
        }
        smEnd.next = eqSta;
        eqEnd.next = biSta;
        return smSta;
    }
}
