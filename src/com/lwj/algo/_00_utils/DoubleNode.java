package com.lwj.algo._00_utils;

/**
 * create by lwj on 2019/9/13
 * 双向链表
 */
public class DoubleNode {
    public int value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(int data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "value=" + value +
                ", last=" + last +
                ", next=" + next +
                '}';
    }
}
