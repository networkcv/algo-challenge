package com.lwj.algo._02_array;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.lwj.algo._00_utils.BaseUtils.*;


/**
 * create by lwj on 2019/9/2
 *
 * A 数组无序,B 数组有序，
 * 打印两数组中相同的值
 * 相同的值不重复打印
 */
public class _00_GetSameFromDiffArray {
    @Test
    public void test() {
        int testTime = 30000;
        int sortedArrayMaxSize = 30;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] A = generateRandomArray(sortedArrayMaxSize, maxValue);
            int[] B = generateRandomArray(sortedArrayMaxSize, maxValue);
            Arrays.sort(B);
            Set<Integer> res1 = printDiff(A, B);
            Set<Integer> res2 = printDiff2(A, B);
//            Set<Integer> res2 = printDiff3(A, B);
            if (!isEqual(res1, res2)) {
                printl(A);
                printl(B);
                printl(res1);
                printl(res2);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Error!!!");
    }


    //循环嵌套 O(N^2)
    public Set<Integer> printDiff(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    set.add(arr1[i]);
                    break;
                }
            }
        }
        return set;

    }

    //嵌套二分查找 O(N*log(N))  其中必须有一个数组是有序的才可以使用二分查找
    public Set<Integer> printDiff2(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            int l = 0;
            int r = arr2.length - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (arr2[mid] == arr1[i]) {
                    set.add(arr2[mid]);
                    break;
                }
                if (arr1[i] > arr2[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return set;
    }

    //两个指针进行外部排序 T(N)=O(Arr1)+O(Arr2)
    public Set<Integer> printDiff3(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(arr1);
        int a1 = 0, a2 = 0;
        while (a1 < arr1.length && a2 < arr2.length) {
            if (arr1[a1] == arr2[a2]) {
                set.add(arr1[a1]);
                a1++;
                a2++;
            } else if (arr1[a1] > arr2[a2]) {
                a2++;
            } else {
                a1++;
            }
        }
        return set;
    }
}
