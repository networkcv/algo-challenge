package com.lwj.algo._00_utils;

/**
 * create by lwj on 2019/9/13
 */
public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
