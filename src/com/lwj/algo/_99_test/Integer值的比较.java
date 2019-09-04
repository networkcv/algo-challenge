package com.lwj.algo._99_test;

/**
 * create by lwj on 2019/9/4
 * 和字符串类似，'==' 比较的是地址， equals 比较的是值
 * 如果自己定义的话也存在类似于字符串常量池的内存空间，
 */
public class Integer值的比较 {
    public static void main(String[] args){
        Integer i1=1;
        Integer i2=1;
        System.out.println(i1==i2); //true
        i1=getInteger();
        i2=getInteger();
        System.out.println(i1==i2); //false
        System.out.println(i1.equals(i2)); //true

    }

    public static Integer getInteger(){
        return new Integer(1);
    }
}
