package com.lwj.algo._08_algo.greedy;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * create by lwj on 2019/10/18
 * 字符串字典排序拼接
 * 返回字典序最小的字符串
 */
public class _01_LowestString {
    @Test
    public void test() {
        String[] str = {"ba", "b", "c"};
        System.out.println(lowestString(str));
    }

    private String lowestString(String[] str) {
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> (s1 + s2).compareTo((s2 + s1)));
        Collections.addAll(pq, str);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }

}
