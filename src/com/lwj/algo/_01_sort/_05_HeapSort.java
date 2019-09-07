package com.lwj.algo._01_sort;

import org.junit.Test;

import java.util.List;

import static com.lwj.algo._00_utils.BaseUtils.*;

/**
 * create by lwj on 2019/9/7
 * 堆排序
 */
public class _05_HeapSort {

    @Test
    public void test() {
        int[] ints = generateRandomArray(10, 10);
        printl(ints);
        List<Integer> integers = heapSort(ints);
        printl(integers);
    }

    private List<Integer> heapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size );
        }
//        swap(arr, 0, --size);
//        while (size > 0) {
//            heapify(arr, 0, size);
//            swap(arr, 0, --size);
//
//        }
        return toList(arr);
    }

    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

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
}
