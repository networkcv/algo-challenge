package com.lwj.algo._05_stack;

import java.util.Stack;

/**
 * create by lwj on 2019/9/8
 * push栈要出栈就必须全部出完
 * pop栈不为空，则不能入栈
 */
public class _01_Stack2Queue {
    public class MyQueue {
        Stack<Integer> stackPush;
        Stack<Integer> stackPop;
        public MyQueue(){
            stackPush=new Stack<>();
            stackPop=new Stack<>();
        }
        public void push(int num){
            stackPush.push(num);
        }

        public int poll(){
            if(stackPush.isEmpty()&&stackPop.isEmpty()){
                throw new RuntimeException("queue is empty");
            }else if (stackPop.empty()){
                while(!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek(){
            if(stackPush.isEmpty()&&stackPop.isEmpty()){
                throw new RuntimeException("queue is empty");
            }else if (stackPop.empty()){
                while(!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }
}
