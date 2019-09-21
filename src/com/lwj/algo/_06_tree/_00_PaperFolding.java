package com.lwj.algo._06_tree;

import org.junit.Test;

/**
 * create by lwj on 2019/9/21
 * 折纸问题
 * 1             down
 * 2        down       up
 * 3    down   up  down    up
 */
public class _00_PaperFolding {
    @Test
    public void test() {
//        paperFolding(1);
//        paperFolding(2);
        paperFolding(3, true);
    }

    private void paperFolding(int n, boolean flag) {
        if (n == 0) return;
        paperFolding(n - 1, true);
        if (flag) {
            System.out.print("down ");
        } else {
            System.out.print("up ");
        }
        paperFolding(n - 1, false);
    }
}
