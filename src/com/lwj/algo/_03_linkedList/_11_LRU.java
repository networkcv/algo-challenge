package com.lwj.algo._03_linkedList;

import com.lwj.algo._00_utils.Node;
import org.junit.Test;

/**
 * create by lwj on 2019/10/14
 * 最近最少使用算法
 * 学习Redis内存淘汰机制的时候练习一下，还有待优化
 */
public class _11_LRU {
    public static class LRU {
        private Node head;
        private Integer size;
        private Integer count = 0;

        public LRU(int size) {
            this.size = size;
        }

        public void insert(int n) {
            insert(new Node(n));
        }

        public void insert(Node node) {
            //先查询缓存
            Node tmp = head;
            Node pre = null;
            Node insert = node;
            Boolean isExist = false;
            while (tmp != null) {
                if (tmp.value == node.value) {
                    isExist = true;
                    break;
                }
                pre = tmp;
                tmp = tmp.next;
            }
            if (isExist) {
                //如果缓存中存在 则删除当前位置的节点，在头节点插入
                if (pre != null) {
                    pre.next = tmp.next;
                    count--;
                }
            } else {
                //如果缓存中不存在 且缓存已满，删除链表尾部元素，
                if (count == size) {
                    tmp = head;
                    int i = 1;
                    while (i < count - 1) {
                        tmp = tmp.next;
                        i++;
                    }
                    tmp.next = null;
                }
            }
            //如果缓存中不存在 且缓存未满
            //将三次的插入代码做一个复用
            insert.next = head;
            head = insert;
            count++;
        }

        public void print() {
            Node tmp = head;
            while (tmp != null) {
                System.out.print(tmp.value + " ");
                tmp = tmp.next;
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        LRU lru = new LRU(3);
        lru.insert(1);
        lru.insert(2);
        lru.insert(3);
        lru.insert(4);
        lru.print();
        lru.insert(2);
        lru.print();
    }

}
