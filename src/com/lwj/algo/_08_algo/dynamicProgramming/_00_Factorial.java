package com.lwj.algo._08_algo.dynamicProgramming;

import org.junit.Test;

/**
 * create by lwj on 2019/10/26
 * 求n!
 */
public class _00_Factorial {
    @Test
    public void test() {
        System.out.println(factorialByCycle(4));
        System.out.println(factorialByRecursion(4));

    }

    //循环
    private int factorialByCycle(int n) {
        int res = 1;
        while (n > 0) {
            res *= n--;
        }
        return res;
    }

    //递归
    private int factorialByRecursion(int n) {
        if (n == 1)
            return 1;
        return n * factorialByRecursion(n - 1);
    }
}
