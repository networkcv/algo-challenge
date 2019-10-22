package com.lwj.algo._08_algo.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * create by lwj on 2019/10/22
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。给你每一个项目开始的时间和结束的时间(给你一个数组，
 * 里面是一个个具体的项目)，你来安排宣讲的日程，要求会议室进行 的宣讲的场次最多。输出这个最多的宣讲场次。
 */
public class _03_BestArrange {
    public class Meeting {
        //会议的开始时间
        public int begin;
        //会议的结束时间
        public int end;

        public Meeting(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    public int bestArrange(Meeting[] meetings, int cur) {
        //按照会议结束的早晚进行排序
        Arrays.sort(meetings, Comparator.comparingInt((Meeting o) -> o.end));
        int res = 0;
        for (int i = 0; i < meetings.length; i++) {
            //cur代表上一场会议的结束时间，如果cur比下场会议要早，那么该场会议可以安排，res++
            //并且下场会议的结束时间作为cur的新值
            if (cur <= meetings[i].begin) {
                cur = meetings[i].end;
                res++;
            }
        }
        return res;
    }
}
