package com.lwj.algo._00_utils;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;

/**
 * create by lwj on 2019/9/5
 */
public class MemoryTest {
    public static void main(String[] args) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage usage = memoryMXBean.getHeapMemoryUsage();
        System.out.println("INT HEAP:" + usage.getInit() / 1024 / 1024 + "Mb");
        System.out.println("MAX HEAP:" + usage.getMax() / 1024 / 1024 + "Mb");
        System.out.println("USED HEAP:" + usage.getUsed() / 1024 / 1024 + "Mb");

        System.out.println("\nFull Information:");
        System.out.println("Heap Memory Usage:" + memoryMXBean.getHeapMemoryUsage());
        System.out.println("Non-Heap Memory Usage:" + memoryMXBean.getNonHeapMemoryUsage());

        List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        System.out.println("=====================java options==================");
        System.out.println(inputArguments);

        System.out.println("=====================通过java来获取相关系统状态====================");
        long i = Runtime.getRuntime().totalMemory() / 1024 / 1024;//Java 虚拟机中的内存总量，以字节为单位
        System.out.println("总的内存量为:" + i + "Mb");
        long j = Runtime.getRuntime().freeMemory() / 1024 / 1024;//Java 虚拟机中的空闲内存量
        System.out.println("空闲内存量:" + j + "Mb");
        long k = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println("最大可用内存量:" + k + "Mb");

    }
}
