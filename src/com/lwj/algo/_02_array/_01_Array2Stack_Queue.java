package com.lwj.algo._02_array;

/**
 * create by lwj on 2019/9/8
 */
public class _01_Array2Stack_Queue {
    public static class Array2Stack {
        int[] arr;
        int size;

        public Array2Stack(int initSize) {
            if (initSize < 0)
                throw new RuntimeException("this init size less than 0");
            arr = new int[initSize];
            size = 0;
        }

        public void push(int num) {
            if (size == arr.length)
                throw new RuntimeException("the stack is full");
            arr[size++] = num;
        }

        public int pop() {
            if (size == 0)
                throw new RuntimeException("the stack is empty");
            return arr[--size];
        }

        public Integer peek() {
            if (size == 0)
                return null;
            return arr[size - 1];
        }
    }

    public class Array2Queue {
        int[] arr;
        int start;
        int end;
        int size;

        public Array2Queue(int initSzie) {
            arr = new int[initSzie];
            size = 0;
            start = 0;
            end = 0;
        }

        public void push(int num) {
            if (size == arr.length) {
                throw new RuntimeException("this queue is full");
            }
            size++;
            arr[end] = num;
            end = end == arr.length - 1 ? 0 : end + 1;
        }

        public Integer pull() {
            if (size == 0) {
                throw new RuntimeException("this queue is empty");
            }
            size--;
            Integer tmp = arr[start];
            start = start == arr.length - 1 ? 0 : start + 1;
            return tmp;
        }

        public Integer peek() {
            if (start == 0)
                return null;
            return arr[start];
        }
    }
}
