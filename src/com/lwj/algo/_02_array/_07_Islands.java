package com.lwj.algo._02_array;

/**
 * create by lwj on 2019/10/3
 * 在一个地图中，找出一共有多少个岛屿。
 * 我们用一个二维数组表示这个地图，地图中的 1 表示陆地，0 表示水域。一个岛屿是指由上下左右相连的陆地，并且被水域包围的区域。
 * 你可以假设地图的四周都是水域。
 * { 0, 0, 0, 0, 0, 0, 0, 0 },
 * { 0, 0, 1, 0, 0, 0, 0, 0 },
 * { 0, 1, 1, 1, 0, 0, 0, 0 },
 * { 0, 0, 1, 0, 0, 1, 1, 0 },
 * { 0, 0, 0, 0, 0, 1, 1, 0 },
 * { 0, 0, 1, 0, 0, 0, 0, 0 },
 * { 0, 0, 0, 0, 0, 0, 0, 1 },
 * 比如这种情况，期望输出结果为4。
 */
public class _07_Islands {
    public static int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }

    public static void main(String[] args) {
        int[][] m1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m1));

        int[][] m2 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m2));

    }

}
