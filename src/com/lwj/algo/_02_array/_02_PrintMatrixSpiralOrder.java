package com.lwj.algo._02_array;

import org.junit.Test;

/**
 * create by lwj on 2019/9/11
 * 顺时针打印二维数组
 * 宏观代替微观
 *  1  2  3  4
 * 10 11 12  5
 *  9  8  7  6
 */
public class _02_PrintMatrixSpiralOrder {
    @Test
    public void printMatrixSpiralOrder() {
        int[][] arr0 = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        int[][] arr1 = new int[][]{{1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}};
        int[][] arr2 = new int[][]{{1}, {2}, {3}};
        int[][] arr3 = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        int[][] arr4 = new int[][]{};
        int[][] arr5 = new int[][]{{1}};
        circlePrint(arr0, 0, 2, 2);
        circlePrint(arr1, 0, 3, 2);
        circlePrint(arr2, 0, 0, 2);
        circlePrint(arr3, 0, 3, 3);
        circlePrint(arr4, 0, 0, 0);
        circlePrint(arr5, 0, 0, 0);

    }

    //lu(left up)左上 ru右上  rd 右下
    private void circlePrint(int[][] arr, int lu, int ru, int rd) {
        if (arr.length != 0 && arr[lu].length != 0) {
            while (lu <= ru && lu <= rd) {
                if (lu == ru) {
                    for (int i = ru; i <= rd; i++) {
                        System.out.print(arr[i][lu] + " ");
                    }
                    break;
                } else if (lu == rd) {
                    for (int i = lu; i <= ru; i++) {
                        System.out.print(arr[lu][i] + " ");
                    }
                    break;
                } else {
                    int tmp = lu;
                    while (tmp < ru) {
                        System.out.print(arr[lu][tmp++] + " ");
                    }
                    tmp = lu;
                    while (tmp < rd) {
                        System.out.print(arr[tmp++][ru] + " ");
                    }
                    tmp = ru;
                    while (tmp > lu) {
                        System.out.print(arr[rd][tmp--] + " ");
                    }
                    tmp = rd;
                    while (tmp > lu) {
                        System.out.print(arr[tmp--][lu] + " ");
                    }
                    lu++;
                    ru--;
                    rd--;
                }
            }
            System.out.println();
        }
    }

    //左神
    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }
}
