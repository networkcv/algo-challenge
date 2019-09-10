package com.lwj.algo._01_sort;

import org.junit.Test;

import java.util.List;

import static com.lwj.algo._00_utils.BaseUtils.*;

/**
 * create by lwj on 2019/9/10
 *
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 */
public class _98_SortArrayByParityII {
    @Test
    public void test() {
        int[] ints = {4, 2, 5, 7};
        printl(sortArrayByParityII(ints));
        printl(sortArrayByParityII0(ints));
    }

    //使用辅助数组
    public List<Integer> sortArrayByParityII(int[] arr) {
        int[] tmpArr = new int[arr.length];
        for (int i = 0, j = 1, n = 0; n < arr.length; n++) {
            if (arr[n] % 2 == 0) {
                tmpArr[i] = arr[n];
                i += 2;
            } else {
                tmpArr[j] = arr[n];
                j += 2;
            }
        }
        return toList(tmpArr);
    }

    //奇偶指针
    public List<Integer> sortArrayByParityII0(int[] arr) {
        int i = 0, j = 1,tmp;
        while (i < arr.length && j < arr.length) {
            while (i < arr.length && arr[i] % 2 == 0) {
                i += 2;
            }
            while (j < arr.length && arr[j] % 2 == 1) {
                j += 2;
            }
            if(i<arr.length&&j<arr.length)
                swap(arr,i,j);
        }
        return toList(arr);
    }
}
