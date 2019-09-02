package com.lwj.algo._02_array;

import org.junit.Test;

/**
 * create by lwj on 2019/9/2
 */
public class 打印ab数组中相同的值 {
    @Test
    public void test1() {
        //2,3,4,5相同
        int[] arr1 = new int[]{1, 5, 3, 4, 2, 0};
        int[] arr2 = new int[]{3, 2, 4, 6, 7, 5,};
        printDiff(arr1, arr2);
        System.out.println();
        printDiff2(arr1, arr2);
        printDiff3(arr1, arr2);
    }

    //循环嵌套 O(N^2)
    public void printDiff(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length - 1; i++) {
            for (int j = 0; j < arr2.length - 1; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                }
            }
        }
    }

    //嵌套二分查找
    public void printDiff2(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length - 1; i++) {
            int l = 0;
            int r = arr2.length - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if(arr2[mid]==arr1[i]){
                    System.out.print(arr1[i]+" ");
                    break;
                }else if(arr1[i]<arr2[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }
        }

    }

    //嵌套二分查找
    public void printDiff3(int[] arr1, int[] arr2) {

    }
}
