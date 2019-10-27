package com.lwj.algo._08_algo.dynamicProgramming;

import org.junit.Test;

/**
 * create by lwj on 2019/10/27
 * 奶牛出生问题
 * 母牛每年生出一只母牛，新出生的母牛成长三年后也能每年产生一只母牛，假设不会死，求N年后，母牛数量
 */
public class _03_Cow {
    @Test
    public void test() {
        System.out.println(cow(5));
        System.out.println(cow(6));
    }

    private int cow(int n) {
        if (n <= 4) {
            return n;
        }
        return cow(n - 1) + cow(n - 3);
    }

}
