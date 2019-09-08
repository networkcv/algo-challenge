package com.lwj.algo._01_sort;

import com.lwj.algo._00_utils.BaseUtils;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static com.lwj.algo._00_utils.BaseUtils.*;

/**
 * create by lwj on 2019/9/6
 * 快速排序
 * 采用分治思想   自上而下的处理(先排序分区然后获取分区点，再进行子数组的排序分区)
 *
 * 选择分区的过程其实类似_99_SortArrayByOdevity 不过这里不是分奇偶，而是根据末尾值作为判定，分为大小两个区间
 * 首先可以在分区的过程中优化，从之前的分大小两个区，改为分大中小三个区，类似于荷兰国旗问题
 *
 * 最好时间复杂度   平均时间复杂度  最坏时间复杂度     空间复杂度     是否稳定
 *    O(nlogn)       O(nlogn)        O(n^2)           O(logn)       不稳定
 * 空间复杂度最好为 O(logN) 最差为O(N)
 *
 * point点和比point大的区域的第一个元素交换位置，因此快排不是稳定排序，例如 6 6 4 交换后 4 6 6
 */
public class _04_QuickSort {

    @Test
    public void test() {
        int testTime = 1000;
        int sortedArrayMaxSize = 30;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] src = generateRandomArray(sortedArrayMaxSize, maxValue);
            int[] arr1 = src.clone();
            int[] arr2 = src.clone();
//            List<Integer> res1 = quickSort(arr1);
            List<Integer> res1 = quickSort0(arr1);
            List<Integer> res2 = quickSort1(arr2);
//            List<Integer> res2 = quickSort2(arr2);
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

    //普通快排
    public List<Integer> quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return BaseUtils.toList(arr);
    }

    private void quickSort(int[] arr, int le, int ri) {
        if (le < ri) {
            int partition = partition(arr, le, ri);
            quickSort(arr, le, partition - 1);
            quickSort(arr, partition + 1, ri);
        }
    }

    private int partition(int[] arr, int le, int ri) {
        int p = 0, tmp;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= arr[ri]) {
                tmp = arr[p];
                arr[p++] = arr[i];
                arr[i] = tmp;
            }
        }
        return --p;
    }

    //荷兰国旗对快速排序进行优化
    //返回的不再是分区点，而是分区数组，这个数组中的值相等
    //在分区中不再是分为比分区点大小的两个区，而是分为大于，等于，小于三个区
    public List<Integer> quickSort0(int[] arr) {
        quickSort0(arr, 0, arr.length - 1);
        return toList(arr);
    }

    private void quickSort0(int[] arr, int le, int ri) {
        if (le < ri) {
            int[] ints = partition0(arr, le, ri);
            quickSort0(arr, le, ints[0]);
            quickSort0(arr, ints[1], ri);
        }
    }


    private int[] partition0(int[] arr, int le, int ri) {
        //定义变量的时候，需要注意，这是在数组中的某一区间排序
        //要排序的数组大小是从le到ri，切记不要将数组的大小设为arr.length
        int i = le - 1, j = ri + 1, tmp, partition = arr[ri];
        for (int k = le; k < j; ) {
            if (arr[k] < partition) {
                tmp = arr[k];
                arr[k++] = arr[++i];
                arr[i] = tmp;
            } else if (arr[k] > partition) {
                if (k == j - 1) {
                    j--;
                    break;
                }
                tmp = arr[k];
                arr[k] = arr[--j];
                arr[j] = tmp;
            } else {
                k++;
            }
        }
        return new int[]{i, j};
    }

    //每次大于分区点后，都要判断,可以使用哨兵的思想进行优化，减少每次的判断
    public List<Integer> quickSort1(int[] arr) {
        quickSort1(arr, 0, arr.length - 1);
        return toList(arr);
    }

    private void quickSort1(int[] arr, int le, int ri) {
        if (le < ri) {
            int[] ints = partition1(arr, le, ri);
            quickSort1(arr, le, ints[0]);
            quickSort1(arr, ints[1], ri);
        }
    }

    //使用哨兵思想减少了 partition0()方法中 if(k < j - 1) 的判断
    private int[] partition1(int[] arr, int le, int ri) {
        int i = le - 1, j = ri;
        while (le < j) {
            if (arr[le] < arr[ri]) {
                swap(arr, ++i, le++);
            } else if (arr[le] > arr[ri]) {
                swap(arr, --j, le);
            } else {
                le++;
            }
        }
        swap(arr, j, ri);
        return new int[]{i, ++j};
    }


    //随机快排
    //随机选取分区点，使时间复杂度大概率在O(N*logN)
    private void quickSort2(int[] arr, int le, int ri) {
        if (le < ri) {
            //从le到ri之间随机取一个数，跟ri位置数交换
            swap(arr, le + (int) ((ri - le + 1) * Math.random()), ri);
            int[] ints = partition1(arr, le, ri);
            quickSort1(arr, le, ints[0]);
            quickSort1(arr, ints[1], ri);
        }
    }


}
