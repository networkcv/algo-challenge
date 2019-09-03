package com.lwj.algo._01_sort;

import com.lwj.algo._00_utils.BaseUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.lwj.algo._00_utils.BaseUtils.*;


/**
 * create by lwj on 2019/9/3
 * <p>
 * 选择排序
 * 选择排序的实现思路类似于插入排序，也分已排序区间和未排序区间，
 * 选择排序每次会从未排序区间中找到最小元素，放到已排序区间末尾
 * 比如5,8,5,2,9这样一组数据,使用选择排序算法来排序的话,第一次找到最小元素 2,与第一个5交换位置
 * 那第一个5和中间的5顺序就变了,所以就不稳定了。正是因此,相对于冒泡排序和插入排序,选择排序就稍微逊色了
 */
public class _02_SelectionSort {
    @Test
    public void ttest1() {
        int[] ints = generateRandomArray(10, 10);
        print(ints);
        List<Integer> list = selectionSort(ints);
        print(list);
        Arrays.sort(ints);
        print(ints);
    }

    @Test
    public void test() {
        int testTime = 300000;
        int sortedArrayMaxSize = 30;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(sortedArrayMaxSize, maxValue);
            int[] arr2 = arr1.clone();
            selectionSort(arr1);
            List<Integer> res1 = toList(arr1);
            List<Integer> res2 = selectionSort(arr2);
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

    public List<Integer> selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            boolean flag = false;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                    flag = true;
                }
            }
            if (flag) {
                BaseUtils.swap(arr, i, min);
            }
        }
        return toList(arr);
    }

    public static void selectionSort0(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }

    }
}