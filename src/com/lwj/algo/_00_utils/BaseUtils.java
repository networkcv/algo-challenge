package com.lwj.algo._00_utils;

import org.junit.Test;

import java.util.*;

/**
 * create by lwj on 2019/9/2
 */
public class BaseUtils {

    @Test
    public void test1() {
        int[] ints = generateRandomArray(3, 10);
    }


    /**
     * array to list
     */
    public static List<Integer> toList(int [] arr){
        List<Integer> list = new ArrayList<Integer>(arr.length);
        for (int i = 0; i <arr.length ; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * 交换数组中的两个数
     */
    public static void swap(int[]arr ,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 判断传入的两个集合是否相等
     */
    public static boolean isEqual(Collection <Integer> l1,Collection<Integer> l2) {
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

    public static void print(int []arr){
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

    public static void print(Collection c){
        System.out.println(c);
    }

    /**
     *  获取[0,10]内的整数
     */
    private static int getOneInt(Integer i){
        return (int)((i + 1) * Math.random());
    }


}
