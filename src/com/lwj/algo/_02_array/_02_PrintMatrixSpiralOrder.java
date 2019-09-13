package com.lwj.algo._02_array;

import org.junit.Test;

/**
 * create by lwj on 2019/9/11
 * 顺时针打印二维数组
 * 宏观代替微观
 * 1  2  3  4
 * 10 11 12  5
 * 9  8  7  6
 */
public class _02_PrintMatrixSpiralOrder {
    @Test
    public void test() {
        int[][] arr0 = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        int[][] arr1 = new int[][]{{1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}};
        int[][] arr2 = new int[][]{{1}, {2}, {3}};
        int[][] arr3 = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        int[][] arr4 = new int[][]{{1}};
        int[][] arr5 = new int[][]{};
        int[][] arr6 = new int[][]{{}, {}, {}};
        printMatrixSpiralOrder(arr0);
        printMatrixSpiralOrder(arr1);
        printMatrixSpiralOrder(arr2);
        printMatrixSpiralOrder(arr3);
        printMatrixSpiralOrder(arr4);
        printMatrixSpiralOrder(arr5);
        printMatrixSpiralOrder(arr5);

    }

    //a点为左上角的点，b点为右下角的点
    private void printMatrixSpiralOrder(int[][] arr) {
        if (arr.length != 0 && arr[0].length != 0) {
            int ax = 0;
            int ay = 0;
            int bx = arr[0].length - 1;
            int by = arr.length - 1;
            while (ax <= bx && ay <= by) {
                circlePrint(arr, ax++, ay++, bx--, by--);
            }
        }
            System.out.println();
    }

    private void circlePrint(int[][] matrix, int ax, int ay, int bx, int by) {
        if (ax == bx) {
            //竖着打印
            for (int i = ay; i <= by; i++) {
                System.out.print(matrix[i][ax] + " ");
            }
        } else if (ay == by) {
            //横着打印
            for (int i = ax; i <= bx; i++) {
                System.out.print(matrix[ay][i] + " ");
            }
        } else {
            int curX = ax;
            int curY = ay;
            while (curX != bx) {
                System.out.print(matrix[ay][curX++] + " ");
            }
            while (curY != by) {
                System.out.print(matrix[curY++][bx] + " ");
            }
            while (curX != ax) {
                System.out.print(matrix[by][curX--] + " ");
            }
            while (curY != ay) {
                System.out.print(matrix[curY--][ax] + " ");
            }
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
