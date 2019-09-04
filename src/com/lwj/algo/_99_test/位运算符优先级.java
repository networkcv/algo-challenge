package com.lwj.algo._99_test;

import org.junit.Test;

/**
 * create by lwj on 2019/9/4
 * 加法运算 优先于  位运算
 */
public class 位运算符优先级 {
    @Test
    public void test1(){
        int l=5,r=10;
        int i1 = l +(r - l) >> 1;   // 5
        int i2 = l +((r - l) >> 1); // 7
        System.out.println(i1);
        System.out.println(i2);
    }
}
