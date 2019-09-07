package com.lwj.algo._01_sort;

import com.lwj.algo._00_utils.BaseUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.lwj.algo._00_utils.BaseUtils.isEqual;
import static com.lwj.algo._00_utils.BaseUtils.printl;

/**
 * create by lwj on 2019/9/4
 * 归并排序
 * 将待排序数组拆分为两个子数组，对两个子数组排序后进行外部从小到大的合并，子数组的排序也使用这种方式，
 * 直到子数组剩一个元素无法进行拆分，然后对两个无法拆分的子数组进行合并，最终以递归的方式完成排序
 *
 * 采用分治思想   分治算法一般使用递归来实现
 * 通过将一个无序数组分成两个子数组，然后将排序后的子数组再进行合并成一个数组，
 * 子数组的排序用同样的方式，分成更小的两个子数组，排序后合并。
 * 分为子数组的过程叫做 归   两个子数组的合并叫做 并  这样就实现了归并排序。
 *
 * 最好时间复杂度  平均时间复杂度  最坏时间复杂度   空间复杂度    是否稳定
 *    O(nlogn)     O(nlogn)       O(nlogn)        O(n)        稳定
 */
public class _03_MergeSort {
    @Test
    public void test() {
        int testTime =3;
        int sortedArrayMaxSize = 4;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = BaseUtils.generateRandomArray(sortedArrayMaxSize, maxValue);
            int[] arr2 = arr1.clone();
            Arrays.sort(arr1);
            List<Integer> res1 = BaseUtils.toList(arr1);
            List<Integer> res2 = mergeSort(arr2);
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

    public List<Integer> mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return BaseUtils.toList(arr);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if(l==r){
            return;
        }
        //此处注意！！ 加法运算优先级大于位运算优先级
        int mid = l +((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] tmpArr = new int[r - l + 1];
        int i = l, j = mid + 1;
        int s = 0;
        while (i <= mid && j <= r) {
            tmpArr[s++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid)
            tmpArr[s++] = arr[i++];
        while (j <= r)
            tmpArr[s++] = arr[j++];
        for (int k = 0; k < tmpArr.length; k++) {
            arr[l++] = tmpArr[k];
        }
    }
}
