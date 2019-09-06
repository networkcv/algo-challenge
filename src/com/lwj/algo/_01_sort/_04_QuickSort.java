package com.lwj.algo._01_sort;

import com.lwj.algo._00_utils.BaseUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.lwj.algo._00_utils.BaseUtils.*;

/**
 * create by lwj on 2019/9/6
 * 快速排序
 */
public class _04_QuickSort {
    @Test
    public void test1() {
        int[] ints = generateRandomArray(10, 10);
        printl(ints);
        printl(quickSort0(ints));
    }

    @Test
    public void test() {
        int testTime = 5;
        int sortedArrayMaxSize = 30;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(sortedArrayMaxSize, maxValue);
            int[] arr2 = arr1.clone();
            Arrays.sort(arr1);
            List<Integer> res1 = BaseUtils.toList(arr1);
            List<Integer> res2 = quickSort(arr2);
            if (!isEqual(res1, res2)) {
                printl(arr1);
                printl(arr2);
                printl(res1);
                printl(res2);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Error!!!");
    }

    //普通快排
    public List<Integer> quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return BaseUtils.toList(arr);
    }

    private void quickSort(int[] arr, int le, int ri) {
        if (le < ri) {
            int partition = partition(arr, le, ri);
            quickSort(arr, le, partition - 1);
            quickSort(arr, partition + 1, ri);
        }
    }

    private int partition(int[] arr, int le, int ri) {
        int p = 0, tmp;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= arr[ri]) {
                tmp = arr[p];
                arr[p++] = arr[i];
                arr[i] = tmp;
            }
        }
        return --p;
    }

    //荷兰国旗对快速排序进行优化
    //返回的不再是分区点，而是分区数组，这个数组中的值相等
    //在分区中不再是分为比分区点大小的两个区，而是分为大于，等于，小于三个区
    public List<Integer> quickSort0(int[] arr) {
        quickSocket0(arr, 0, arr.length - 1);
        return toList(arr);
    }

    private void quickSocket0(int[] arr, int le, int ri) {
        if (le < ri) {
            int[] ints = partition0(arr, le, ri);
            quickSocket0(arr, le, ints[0]);
            quickSocket0(arr, ints[1], ri);
        }
    }


    private int[] partition0(int[] arr, int le, int ri) {
        int i = le-1, j = arr.length - 1, tmp;
        for (int k = 0; k < j; ) {
            if (arr[k] < arr[ri]) {
                tmp = arr[k];
                arr[k++] = arr[i];
                arr[i++] = tmp;
            } else if (arr[k] > arr[ri]) {
                tmp = arr[k];
                arr[k] = arr[j];
                arr[j--] = tmp;
            } else {
                k++;
            }
        }
        return new int[]{--i, ++j};
    }
}
