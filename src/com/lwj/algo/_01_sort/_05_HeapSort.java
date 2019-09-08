package com.lwj.algo._01_sort;

import org.junit.Test;
import sun.awt.geom.AreaOp;

import java.util.Arrays;
import java.util.List;

import static com.lwj.algo._00_utils.BaseUtils.*;

/**
 * create by lwj on 2019/9/7
 * 堆排序 时间复杂度O(NlogN) 原地排序 不稳定
 * 1.建堆 2.排序
 */
public class _05_HeapSort {
    @Test
    public void test() {
        int testTime = 3000;
        int sortedArrayMaxSize = 30;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
//            int[] src = generateRandomArray(sortedArrayMaxSize, maxValue);
            int[] src = new int[0];
            int[] arr1 = src.clone();
            int[] arr2 = src.clone();
            List<Integer> res1 = heapSort(arr1);
            List<Integer> res2 = heapSort0(arr2);
            if (!isEqual(res1, res2)) {
                printl(src);
                printl(res1);
                printl(res2);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Error!!!");
    }

    //普通堆排序
    private List<Integer> heapSort(int[] arr) {
        if (arr.length == 0) {
            return toList(arr);
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);

        }
        return toList(arr);
    }

    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //堆化
    private void heapify(int arr[], int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) break;
            swap(arr, largest, index);
            index = largest;
            left = index * 2 - 1;
        }
    }


    //在建堆的时候进行优化
    //此方法在使用数组时，arr[1]存放首元素，arr[0]不存放元素
    private List<Integer> heapSort0(int[] arr) {
        heapSort0(arr, arr.length - 1);
        return toList(arr);
    }

    private void heapSort0(int[] arr, int n) {
//        buildHeap(arr, n);
        buildHeap0(arr, n);
        while (n >= 0) {
            swap(arr, n, 0);
            heapify0(arr, --n, 0);
        }
    }

    //自下而上建堆  参考 heapInsert()
    private static void buildHeap(int[] arr, int len) {
        while (len >= 0) {
            int n = len;
            while (((n - 1) / 2) >= 0 && arr[n] > arr[(n - 1) / 2]) {
                swap(arr, n, (n - 1) / 2);
                n = (n - 1) / 2;
            }
            len--;
        }
    }

    //自上而下建堆
    private static void buildHeap0(int[] a, int n) {
        for (int i = n / 2; i >= 0; i--)
            heapify0(a, n, i);
    }

    private static void heapify0(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 + 1 <= n && a[i] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            if (i * 2 + +2 <= n && a[maxPos] < a[i * 2 + 2]) maxPos = i * 2 + 2;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }
}
