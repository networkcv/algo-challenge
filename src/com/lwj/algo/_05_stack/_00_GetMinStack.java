package com.lwj.algo._05_stack;

import java.util.Stack;

/**
 * create by lwj on 2019/9/8
 *
 * 获取栈中最小的值，要求时间复杂度为O(1)
 *
 * 通过使用辅助栈来实现
 */
public class _00_GetMinStack {
    public static void main(String[] args){
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getmin());
        stack1.push(4);
        System.out.println(stack1.getmin());
        stack1.push(1);
        System.out.println(stack1.getmin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getmin());
    }

    public static class MyStack1 {
        private Stack<Integer> dataStack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public void push(int num) {
            if (minStack.isEmpty())
                minStack.push(num);
            else
                minStack.push(minStack.peek() < num ? minStack.peek() : num);
            dataStack.push(num);
        }

        public int pop(){
            if (dataStack.isEmpty())
                throw new RuntimeException("your stack is empty");
            minStack.pop();
            return dataStack.pop();
        }

        public int getmin(){
            if(minStack.isEmpty())
                throw new RuntimeException("your stack is empty");
            return minStack.peek();
        }

    }
}
