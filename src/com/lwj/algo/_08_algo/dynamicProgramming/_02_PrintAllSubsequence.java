package com.lwj.algo._08_algo.dynamicProgramming;

import org.junit.Test;

/**
 * create by lwj on 2019/10/26
 * 打印字符串的所有子序列，包括空字符串
 */
public class _02_PrintAllSubsequence {
    @Test
    public void test() {
        System.out.println("-----");
        printAllSubsequence("abc".toCharArray(), 0, "");
    }

    private void printAllSubsequence(char[] str, int n, String res) {
        if (n == str.length) {
            System.out.println(res);
            return;
        }
        printAllSubsequence(str, n + 1, res);
        printAllSubsequence(str, n + 1, res + str[n]);
    }


}
