package com.lwj.algo._08_algo.dynamicProgramming;

import org.junit.Test;

/**
 * create by lwj on 2019/10/26
 * 一个二维数组，二维数组中的每个数都是正数，要求从左上角走到右下角，
 * 每一步只能向右或者下，沿途经过的数字要累加，，返回最小路径和
 */
public class _04_MinPath {
    @Test
    public void test() {
        int[][] matrix = new int[][]{{3, 2, 1, 0}, {7, 5, 0, 1}, {3, 7, 6, 2}};
        System.out.println(minPathByRecursion(matrix, matrix.length - 1, matrix[0].length-1));
    }

    private int minPathByRecursion(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
        if (i == 0 && j == 0) {
            return res;
        }
        if (i == 0 && j != 0)
            return res + minPathByRecursion(matrix, i, j - 1);
        if (i != 0 && j == 0)
            return res + minPathByRecursion(matrix, i - 1, j);
        return res + Math.min(minPathByRecursion(matrix, i, j - 1), minPathByRecursion(matrix, i - 1, j));
    }
}
