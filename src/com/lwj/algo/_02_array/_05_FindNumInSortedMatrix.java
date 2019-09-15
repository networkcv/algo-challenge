package com.lwj.algo._02_array;

import org.junit.Test;

/**
 * create by lwj on 2019/9/15
 * 在排好序的矩阵中寻找某数
 * 1  3  4  5
 * 4  5  5  7
 * 5  7  7  8
 * 6  7  8  9
 * 从右上角开始找,右上角值大于target，则排除该位置下方的所有元素，小于target则排除左侧元素
 */
public class _05_FindNumInSortedMatrix {
    @Test
    public void test() {
        int[][] arr = new int[][]{{1, 3, 4, 5}, {4, 5, 5, 7}, {5, 6, 7, 8}, {7, 7, 8, 9}};
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        boolean numInSortedMatrix = findNumInSortedMatrix(arr, 6);
        boolean numInSortedMatrix1 = findNumInSortedMatrix(matrix, 233);
        System.out.println(numInSortedMatrix);
        System.out.println(numInSortedMatrix1);

    }

    private boolean findNumInSortedMatrix(int[][] arr, int tar) {
        int x = arr[0].length - 1;
        int y = 0;
        while (x >= 0 && y <= arr.length - 1) {
            if (arr[y][x] == tar) {
                return true;
            } else if (arr[y][x] > tar) {
                x--;
            } else {
                y++;
            }
        }
        return false;

    }
}
