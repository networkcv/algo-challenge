package com.lwj.algo._01_sort;

import com.lwj.algo._00_utils.BaseUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.lwj.algo._00_utils.BaseUtils.isEqual;
import static com.lwj.algo._00_utils.BaseUtils.print;

/**
 * create by lwj on 2019/9/3
 * 插入排序
 */
public class _01_InsertionSort {

    @Test
    public void test() {
        int testTime = 300000;
        int sortedArrayMaxSize = 30;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = BaseUtils.generateRandomArray(sortedArrayMaxSize, maxValue);
            int[] arr2 = arr1.clone();
            insertionSort0(arr1);
            List<Integer> res1 = BaseUtils.toList(arr1);
            List<Integer> res2 = insertionSort(arr2);
            if (!isEqual(res1, res2)) {
                print(arr1);
                print(arr2);
                print(res1);
                print(res2);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Error!!!");
    }

    public List<Integer> insertionSort(int arr[]) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int tmp = i;
            while (tmp > 0 && arr[tmp - 1] > arr[tmp]) {
                BaseUtils.swap(arr, tmp - 1, tmp);
                tmp--;
            }
        }
        return BaseUtils.toList(arr);
    }

    public static void insertionSort0(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                BaseUtils.swap(arr, j, j + 1);
            }
        }
    }
}
