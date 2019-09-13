package com.lwj.algo._02_array;

import org.junit.Test;

/**
 * create by lwj on 2019/9/11
 * 还是用宏观代替微观的思想
 * 给定一个 n × n 的二维矩阵表示一个图像。  需将图像顺时针旋转 90 度。
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 给定 matrix =
 * [
 * [3,6,9],
 * [2,5,8],
 * [1,4,7]
 * ]
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ]
 */
public class _03_RotateMatrix {
    @Test
    public void test() {
        int[][] arr = new int[][]{{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        int[][] arr1 = new int[][]{{4, 8, 12,16}, {3, 7, 11,15}, {2,6,10,14},{1,5,9,13}};

        printMatrix(rotateMatrix(arr));
        printMatrix(rotateMatrix(arr1));
    }

    public int[][] rotateMatrix(int[][] matrix) {
        if (matrix.length != 0 && matrix[0].length != 0) {
            int ax = 0;
            int ay = 0;
            int bx = matrix[0].length - 1;
            int by = matrix.length - 1;
            while (ax < bx) {
                rotateMatrix(matrix, ax++, ay++, bx--, by--);
            }
        }
        return matrix;
    }

    private void rotateMatrix(int[][] matrix, int ax, int ay, int bx, int by) {
        int tmp;
        for (int i = 0; i < bx - ax; i++) {
            tmp = matrix[ay][ax + i];
            matrix[ay][ax + i] = matrix[by - i][ax];
            matrix[by - i][ax] = matrix[by][bx - i];
            matrix[by][bx - i] = matrix[ay + i][bx];
            matrix[ay + i][bx] = tmp;
        }
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
