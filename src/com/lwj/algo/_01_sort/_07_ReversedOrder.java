package com.lwj.algo._01_sort;

import com.lwj.algo._00_utils.BaseUtils;
import org.junit.Test;

import static com.lwj.algo._00_utils.BaseUtils.printl;

/**
 * create by lwj on 2019/9/5
 * 逆序对问题
 * 参考小和问题
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数
 */
public class _07_ReversedOrder {
    @Test
    public void test() {
        int testTime = 50;
        int sortedArrayMaxSize = 50;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = BaseUtils.generateRandomArray(sortedArrayMaxSize, maxValue);
            int[] arr2 = arr1.clone();
            Integer i1 = inversePairs(arr1);
            Integer i2 = reversedOrder(arr2);
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

    public Integer reversedOrder(int[] arr) {
        return reversedOrder(arr, 0, arr.length - 1);
    }

    public Integer reversedOrder(int[] arr, int le, int ri) {
        if (le == ri) return 0;
        int mid = le + ((ri - le) >> 1);
        return reversedOrder(arr, le, mid) + reversedOrder(arr, mid + 1, ri) + meger(arr, le, mid, ri);
    }

    public Integer meger(int[] arr, int le, int mid, int ri) {
        int[] tmpArr = new int[ri - le + 1];
        //此处为逆序对问题和小和问题的差别
//        int l1 = le, l2 = mid + 1, count = 0, t = 0;
        int r1=mid,r2=ri,count=0,t=tmpArr.length-1;

//        while (l1 <= mid && l2 <= ri) {
//            count += arr[l1] > arr[l2] ? 1 : 0;
//            tmpArr[t++] = arr[l1] < arr[l2] ? arr[l1++] : arr[l2++];
//        }
        while(r1>=le&&r2>=mid+1){
            count+=arr[r1]>arr[r2]?(r2-(mid+1)+1):0;
            tmpArr[t--]=arr[r1]>arr[r2]?arr[r1--]:arr[r2--];
        }
//        while (l1 <= mid) {
//            tmpArr[t++] = arr[l1++];
//        }
//        while (l2 <= ri) {
//            tmpArr[t++] = arr[l2++];
//        }
        while(r1>=le){
            tmpArr[t--]=arr[r1--];
        }
        while (r2>=mid+1){
            tmpArr[t--]=arr[r2--];
        }

        for (int i = 0; i < tmpArr.length; i++) {
            arr[le++] = tmpArr[i];
        }
        return count;
    }


    public static int inversePairs(int[] data) {
        if (data == null || data.length < 1) {
            return 0;
        }

        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);

        return inversePairsCore(data, copy, 0, data.length - 1);
    }

    private static int inversePairsCore(int[] data, int[] copy, int start, int end) {

        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;
        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);

        // 前半段的最后一个数字的下标
        int i = start + length;
        // 后半段最后一个数字的下标
        int j = end;
        // 开始拷贝的位置
        int indexCopy = end;
        // 逆序数
        int count = 0;

        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy] = data[i];
                indexCopy--;
                i--;
                count += j - (start + length); // 对应的逆序数
            } else {
                copy[indexCopy] = data[j];
                indexCopy--;
                j--;
            }
        }

        for (; i >= start; ) {
            copy[indexCopy] = data[i];
            indexCopy--;
            i--;
        }

        for (; j >= start + length + 1; ) {
            copy[indexCopy] = data[j];
            indexCopy--;
            j--;
        }
        return count + left + right;
    }
}
