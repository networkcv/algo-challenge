package com.lwj.algo._08_algo.greedy;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * create by lwj on 2019/10/18
 * 项目最大收益问题
 * 输入： 参数1，正数数组costs 参数2，正数数组profits 参数3，正数k 参数4，正数m
 * costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花
 * 费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多做k个项目 m表示你初始的资金
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个 项目。
 * 输出： 你最后获得的最大钱数。
 * <p>
 * 给定一个初始投资资金，给定N个项目，想要获得其中最大的收益，并且一次只能做一个项目。这是一个贪心策咯的问题
 * 按照花费的多少放到一个小根堆里面，将小于持有资金的项目取出放入大根堆，在大根堆中根据收益的大小进行排序
 * 每次做项目取大根堆的堆顶元素，如果堆顶元素为空，这说明没有项目可以进行了，返回此时持有资金
 */
public class _02_MaxProfits {
    @Test
    public void test() {
        int[] costs = new int[]{20, 10, 30, 48,};
        int[] profits = new int[]{10, 10, 18, 50,};

        int res = maxEarnings(costs, profits, 100, 3);
        System.out.println(res);

    }

    /**
     * @param costs   花费数组
     * @param profits 收益数组
     * @param money   项目启动资金
     * @param num     最多可以做几个项目
     * @return 获取的最大钱数
     */
    private int maxEarnings(int[] costs, int[] profits, int money, int num) {
//        PriorityQueue<Node> minCost = new PriorityQueue<>(((o1, o2) -> o1.c - o2.c));
        //使用Comparator提供的封装方法
        PriorityQueue<Node> minCost = new PriorityQueue<>((Comparator.comparingInt(o -> o.c)));
        PriorityQueue<Node> maxProfit = new PriorityQueue<>(((o1, o2) -> o2.p - o1.p));
        //将所有项目放入小根堆中
        for (int i = 0; i < costs.length; i++) {
            Node node = new Node(costs[i], profits[i]);
            minCost.add(node);
        }
        for (int i = 0; i < num; i++) {
            //将大于当前持有资金的项目取出并放入大根堆
            while (!minCost.isEmpty() && minCost.peek().c <= money) {
                maxProfit.add(minCost.poll());
            }
            //如果大根堆为空，这说明没有项目可以进行，原因可能是项目都做完了或者启动项目的资金不够
            if (maxProfit.isEmpty())
                return money;
            //取出大根堆中堆顶元素，也就是收益最大的项目，并将项目收益加到当前持有资金中
            money += maxProfit.poll().p;
        }
        return money;
    }

    private static class Node {
        int c;
        int p;

        public Node(int c, int p) {
            this.c = c;
            this.p = p;
        }
    }
}
