package com.lwj.algo._08_algo.dynamicProgramming;


import org.junit.Test;

/**
 * create by lwj on 2019/10/24
 * 汉诺塔问题
 * 使用递归进行问题转化
 * 从n如何处理，到n-1如何处理，最后n=1如何处理
 */
public class _01_Hanoi {
    @Test
    public void test() {
        hanoi(3, "左", "右", "中");
    }

    //假设在处理n的时候我们已经知道n-1该如何处理
    //所以可以将n-1看成一个组合的圆盘，问题就转为如何将n-1这个组合圆盘与n这个大圆盘移动的问题
    //两个圆盘如何移动，n-1先从左到中，n从左到右，n-1从中到右，代码如下
    //base case 就是当n=1的时候，只剩一个圆盘，可以直接从左到右就ok了
    private void hanoi(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("MOVE " + n + " from " + from + " to " + to);
            return;
        }
        //n-1先从左到中
        hanoi(n - 1, from, help, to);
        //n从左到右
        System.out.println("MOVE " + n + " from " + from + " to " + to);
        //n-1从中到右
        hanoi(n - 1, help, to, from);
    }
}
