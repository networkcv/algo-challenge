package com.lwj.algo._08_algo.greedy;

import com.lwj.algo._00_utils.BaseUtils;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * create by lwj on 2019/10/18
 * <p>
 * 切金条
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金条，不管切成长度多大的两半，都要花费20个铜板。一群人想整分
 * 整块金条，怎么分最省铜板？例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60. 金条要分成10,20,30三个部分。
 * 如果，先把长度60的金条分成10和50，花费60 再把长度50的金条分成20和30，花费50一共花费110铜板。但是如果先把长度60的金条分成30
 * 和30，花费60 再把长度30金条分成10和20，花费30 一共花费90铜板。输入一个数组，返回分割的最小代价。
 * <p>
 * 贪心贪最小，利用哈夫曼原理可知，如果是要分成10， 20， 30，那么我先把10， 20加起来需要30代价(也就是30切成10，20)，
 * 接着把加起来的30代价和原有的30加起来就是60代价，30+60代价就是90代价。也就是从树的顶端往下看，先是60的金条，现在先分成最大的
 * 两部分，30和30，需要60代价，接着需要其中一个30分割成10， 20，这个也需要10+20=30代价，那么一共就是90代价
 */
public class _00_LessMoney {
    @Test
    public void test() {
        int i = lessMoney(new int[]{10, 20, 30});
        System.out.println(i);

        //测试大顶堆打印结果
        int[] arr = BaseUtils.generateRandomArray(10, 10);

        PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int a : arr) {
            maxPq.add(a);
        }
        while (!maxPq.isEmpty()) {
            System.out.print(maxPq.poll() + " ");
        }
        System.out.println();


    }

    private int lessMoney(int[] arr) {
        //默认是小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //小顶堆
//        PriorityQueue<Integer> pq=new PriorityQueue<>(((o1, o2) -> o1-o2));
        for (int a : arr) {
            pq.add(a);
        }
        int sum = 0;
        int cur;
        while (pq.size() > 1) {
            cur = pq.poll() + pq.poll();
            sum += cur;
            pq.add(cur);
        }
        return sum;
    }


}
