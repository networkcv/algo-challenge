package com.lwj.algo._01_sort;

import com.lwj.algo._00_utils.BaseUtils;
import org.junit.Test;

import java.util.*;

import static com.lwj.algo._00_utils.BaseUtils.*;

/**
 * create by lwj on 2019/9/3
 *
 * 冒泡排序
 * 比较当前数和下一个数，当前大于下一个则进行交换 一轮排序将一组数的最大值换至末尾
 */
public class _00_BubbleSort {

    @Test
    public void test() {
        int testTime = 300000;
        int sortedArrayMaxSize = 30;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = BaseUtils.generateRandomArray(sortedArrayMaxSize, maxValue);
            int[] arr2 = arr1.clone();
            bubbleSort0(arr1);
            List<Integer> res1 = BaseUtils.toList(arr1);
            List<Integer> res2 = bubbleSort(arr2);
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

    public List<Integer> bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return BaseUtils.toList(arr);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    BaseUtils.swap(arr, j, j + 1);
                }
            }
        }
        return BaseUtils.toList(arr);
    }

    public static void bubbleSort0(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int e = arr.length - 1; e > 0; e--) {
			for (int i = 0; i < e; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}
}
