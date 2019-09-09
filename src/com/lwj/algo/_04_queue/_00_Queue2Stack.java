package com.lwj.algo._04_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * create by lwj on 2019/9/8
 */
public class _00_Queue2Stack {
    public static class MyStack {
        private Queue<Integer> dataQueue;
        private Queue<Integer> helpQueue;

        public MyStack() {
            dataQueue = new LinkedList<>();
            helpQueue = new LinkedList<>();
        }

        public void push(int num) {
            dataQueue.add(num);
        }

        public int pop() {
            if (dataQueue.isEmpty() && helpQueue.isEmpty()) {
                throw new RuntimeException("stack is empty");
            } else {
                while (dataQueue.size() != 1) {
                    helpQueue.add(dataQueue.poll());
                }
            }
            Queue tmp;
            tmp = dataQueue;
            dataQueue = helpQueue;
            helpQueue = tmp;
            return helpQueue.poll();
        }

        public int peek() {
            if (dataQueue.isEmpty() && helpQueue.isEmpty()) {
                throw new RuntimeException("stack is empty");
            } else {
                while (dataQueue.size() != 1) {
                    helpQueue.add(dataQueue.poll());
                }
            }
            int res = dataQueue.poll();
            Queue tmp;
            tmp = dataQueue;
            dataQueue = helpQueue;
            helpQueue = tmp;
            dataQueue.add(res);
            return res;
        }
    }
}
