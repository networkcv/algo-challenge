package com.lwj.algo._02_array;

import org.junit.Test;

import java.util.Arrays;

/**
 * create by lwj on 2019/9/2
 * arr1数组无序,arr2数组有序，
 */
public class 打印ab数组中相同的值 {

    @Test
    public void test1() {
        //2,3,4,5相同
        int[] arr1 = new int[]{1, 5, 3, 4, 2, 0};
        int[] arr2 = new int[]{2, 3, 4, 5, 6, 7,};
        printDiff(arr1, arr2);
        System.out.println();
        printDiff2(arr1, arr2);
        System.out.println();
        printDiff3(arr1, arr2);

    }

    //循环嵌套 O(N^2)
    public void printDiff(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length - 1; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                }
            }
        }
    }

    //嵌套二分查找 O(N*log(N))  其中必须有一个数组是有序的才可以使用二分查找
    public void printDiff2(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            int l = 0;
            int r = arr2.length - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (arr2[mid] == arr1[i]) {
                    System.out.print(arr1[i] + " ");
                    break;
                }
                if (arr1[i] > arr2[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

    }

    //两个指针进行外部排序
    public void printDiff3(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        int a1 = 0, a2 = 0;
        while (a1 < arr1.length && a2 < arr2.length) {
            if (arr1[a1] == arr2[a2]) {
                System.out.print(arr1[a1] + " ");
                a1++;
                a2++;
            }else if (arr1[a1] > arr2[a2]) {
                a2++;
            } else {
                a1++;
            }
        }

    }
}
