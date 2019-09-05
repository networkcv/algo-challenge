package com.lwj.algo._01_sort;

import com.lwj.algo._00_utils.BaseUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.lwj.algo._00_utils.BaseUtils.isEqual;
import static com.lwj.algo._00_utils.BaseUtils.printl;

/**
 * create by lwj on 2019/9/5
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */
public class _99_SortArrayByOdevity {

    @Test
    public void test() {
        int testTime = 300000;
        int sortedArrayMaxSize = 30;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = BaseUtils.generateRandomArray(sortedArrayMaxSize, maxValue);
            int[] arr2 = arr1.clone();
            List<Integer> res1 = sortArrayByOdevity0(arr1);
            List<Integer> res2 = sortArrayByOdevity(arr2);
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

    //双指针原地排序
    public List<Integer> sortArrayByOdevity(int[] arr) {
        int i = 0, j = arr.length - 1;
        int tmp;
        while (i<j){
            if(arr[i]%2==1&&arr[j]%2==0){
                tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
                i++;j--;
            }
            if(arr[i]%2==0){
                i++;
            }
            if(arr[j]%2==1){
                j--;
            }
        }
        return BaseUtils.toList(arr);
    }

    //辅助数组外部排序
    public List<Integer> sortArrayByOdevity0(int[] arr) {
        int[] tmpArr = new int[arr.length];
        int i = 0, j = tmpArr.length - 1;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] % 2 == 0) {
                tmpArr[i++] = arr[k];
            } else {
                tmpArr[j--] = arr[k];
            }
        }
        return BaseUtils.toList(tmpArr);
    }
}
