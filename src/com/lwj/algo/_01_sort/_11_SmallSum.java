package com.lwj.algo._01_sort;

import com.lwj.algo._00_utils.BaseUtils;
import org.junit.Test;

import static com.lwj.algo._00_utils.BaseUtils.printl;

/**
 * create by lwj on 2019/9/4
 * 小和问题
 * 在一个数组中， 每一个数左边比当前数小的数累加起来， 叫做这个数组的小和。 求一个数组
 * 的小和。
 * 例子：
 * [1,3,4,2,5]
 * 1左边比1小的数， 没有；
 * 3左边比3小的数， 1；
 * 4左边比4小的数， 1、 3；
 * 2左边比2小的数， 1；
 * 5左边比5小的数， 1、 3、 4、 2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 */
public class _11_SmallSum {
    @Test
    public void test() {
        int testTime = 10;
        int sortedArrayMaxSize = 30;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = BaseUtils.generateRandomArray(sortedArrayMaxSize, maxValue);
            int[] arr2 = arr1.clone();
            Integer i1 = smallSum0(arr1);
            Integer i2 = smallSum(arr2);
            if (!i1.equals(i2)) {
                printl(arr1);
                printl(arr2);
                System.out.println(i1);
                System.out.println(i2);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Error!!!");
    }

    /**
     * 归并解法
     * 先对子区间排序，在合并之前计算小和
     * 若左子区间的A元素小于右子区间的B元素，则A小于B之后的所有元素，小和计算的方式为A* B及B以后元素个数
     */
    public Integer smallSum(int[] arr) {
        return samllSum(arr, 0, arr.length - 1);
    }

    private Integer samllSum(int[] arr, int le, int ri) {
        if (le == ri) return 0;
        int mid = le + ((ri - le) >> 1);
        int i1 = samllSum(arr, le, mid);
        int i2 = samllSum(arr, mid + 1, ri);
        int merge = merge(arr, le, mid, ri);
        return i1 + i2 + merge;
    }

    private Integer merge(int[] arr, int le, int mid, int ri) {
        int sum = 0;
        int[] tmpArr = new int[ri - le + 1];
        int t = 0, l1 = le, l2 = mid + 1;

        while (l1 <= mid && l2 <= ri) {
            sum += arr[l1] < arr[l2] ? (ri - l2 + 1) * arr[l1] : 0;
            tmpArr[t++] = arr[l1] < arr[l2] ? arr[l1++] : arr[l2++];
        }

        while (l1 <= mid) {
            tmpArr[t++] = arr[l1++];
        }
        while (l2 <= ri) {
            tmpArr[t++] = arr[l2++];
        }

        for (int i = 0; i < tmpArr.length; i++) {
            arr[le++] = tmpArr[i];
        }
        return sum;
    }

    //常规解法
    public Integer smallSum0(int[] arr) {
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    sum += arr[j];
                }
            }
        }
        return sum;
    }
}
