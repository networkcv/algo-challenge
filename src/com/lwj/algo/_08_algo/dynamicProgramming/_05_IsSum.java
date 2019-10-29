package com.lwj.algo._08_algo.dynamicProgramming;

import org.junit.Test;

/**
 * create by lwj on 2019/10/29
 * 给定int数组arr和一个int值 target
 * 从arr中取任意数字进行累加，判断能否加出target
 */
public class _05_IsSum {
    @Test
    public void test() {
        boolean b= isSum(new int[]{1, 3, 5,  6}, 0, 0, 8);
        System.out.println(b);
    }

    private boolean isSum(int[] arr, int i, int sum, int target) {
        if (i == arr.length) {
            return sum == target;
        }
        return isSum(arr, i + 1, sum, target) || isSum(arr, i + 1, sum + arr[i], target);
    }
}
