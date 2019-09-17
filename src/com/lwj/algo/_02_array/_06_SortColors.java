package com.lwj.algo._02_array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.lwj.algo._00_utils.BaseUtils.*;

/**
 * create by lwj on 2019/9/17
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class _06_SortColors {
    @Test
    public void test() {
        int count = 3000;
        while (count-- > 0) {
            int[] arr1 = generateRandomArray(10, 2);
            int[] arr2 = arr1.clone();
            Arrays.sort(arr1);
            List<Integer> list1 = toList(arr1);
            List<Integer> list2 = sortColors(arr2);
            if (!isEqual(list1, list2)) {
                printl(arr1);
                printl(arr2);
                printl(list1);
                printl(list2);
                break;
            }
        }
        System.out.println("Nice!");
    }

    /**
     * i指向红球的位置，j指向蓝球的位置
     * 数组遍历停止的条件为 当前需要判断颜色的索引，与指向蓝色球索引重合 也就是k==j
     */
    private List<Integer> sortColors(int[] arr) {
        int i = -1;
        int j = arr.length;
        int k = 0;
        while (k < j) {
            if (arr[k] == 0) {
                swap(arr, k++, ++i);
            } else if (arr[k] == 2) {
                swap(arr, k, --j);
            } else {
                k++;
            }
        }
        return toList(arr);
    }
}
