package com.lwj.algo._02_array;

import org.junit.Test;

/**
 * create by lwj on 2019/9/14
 * "之"字型打印矩阵
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 13 14 15 16
 * 输出结果为：1 2 5 9 6 3 4 7 10 13 14 11 8 12 15 16
 * 思路：用宏观代替微观，不要想着怎么从1到2再到5
 * 从整体上考虑，就是沿着斜线打印1，2 5，3 6 9...
 */
public class _04_ZigZagPrintMatrix {

    @Test
    public void test() {
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8,},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        zigZagPrintMatrix(arr);
    }

    private void zigZagPrintMatrix(int[][] arr) {
        int ax = 0;
        int ay = 0;
        int bx = 0;
        int by = 0;
        int endx = arr[0].length - 1;
        int endy = arr.length - 1;
        boolean flag = false;
        while (ay != endy + 1) {
            zigZagPrintMatrix(arr, ax, ay, bx, by, flag);
            flag = !flag;
            ay = ax == endx ? ay+1 : ay;
            ax = ax == endx ? ax : ax+1;
            bx = by == endy ? bx+1 : bx;
            by = by == endy ? by : by+1;
        }

    }

    private void zigZagPrintMatrix(int[][] arr, int ax, int ay, int bx, int by, boolean flag) {
        if (!flag){
            while (bx<=ax&&by>=ay){
                System.out.print(arr[by--][bx++]+" ");
            }
        }else{
            while (ax>=bx&&ay<=by){
                System.out.print(arr[ay++][ax--]+" ");
            }
        }
    }
}
