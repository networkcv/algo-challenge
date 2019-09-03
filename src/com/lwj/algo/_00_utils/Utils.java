package com.lwj.algo._00_utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * create by lwj on 2019/9/2
 */
public class Utils {

    @Test
    public void test1() {
        int[] ints = generateRandomArray(3, 10);
    }


    /**
     * 判断传入的两个集合是否相等
     */
    public static boolean isEqual(List <Integer> l1,List<Integer> l2) {
        if(l1.size()!=l2.size()){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : l1) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            map.put(i, map.get(i) + 1);
        }
        for (Integer i : l2) {
            if (!map.containsKey(i)) {
                return false;
            }
            map.put(i, map.get(i) - 1);
            if (map.get(i) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 生成一个长度在[0,maxSize]  大小在[0,maxValue] 之间 随机数组
     */
    public static int[] generateRandomArray(Integer maxSize, Integer maxValue) {
        int[] arr = new int[getOneInt(maxSize)];
        for (int i=0;i<arr.length;i++){
            arr[i]=getOneInt(maxValue);
        }
        return arr;
    }

    public static void printArr(int []arr){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i!=arr.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     *  获取[0,10]内的整数
     */
    private static int getOneInt(Integer i){
        return (int)((i + 1) * Math.random());
    }


}
