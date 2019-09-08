package com.lwj.algo._01_sort;

import com.lwj.algo._00_utils.BaseUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.lwj.algo._00_utils.BaseUtils.isEqual;
import static com.lwj.algo._00_utils.BaseUtils.printl;

/**
 * create by lwj on 2019/9/3
 * 插入排序
 * 思路类似于整理扑克牌或向输入有序数组中插入数字
 * 最好时间复杂度     平均时间复杂度  最坏时间复杂度      空间复杂度    是否稳定
 *     O(n)              O(n^2)         O(n^2)             O(1)       稳定
 * 是否稳定 比如我们有一组数据 2，9，3，4，8，3，按照大小排序之后2，3，3，4，8，9  其中两个3没有发生交换
 * 原地排序算法，就是特指空间复杂度是 O(1) 的排序算法
 * 有序数组的插入操作的平均时间复杂度为O(n)，对于插入排序来说每次插入操作都相当于在数组中插入一个数据，
 * 执行n次插入操作，所以平均时间复杂度为O(n^2)
 *
 * 插入排序优于冒泡排序的原因是  在交换元素时，冒泡排序需要执行三次赋值语句，而插入排序只需要执行一次
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
