package com.util;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *  1.线程安全修复思路
 *  （1）Synchronized：保证方法内部或代码块内部资源（数据）的互斥访问。
 *  即同一时间、由同一个最多只能有一个线程在访问。
 *  （2）java.util.concurrent.atomic:包提供了一系列的AtomicBloolean、AtomicInteger、
 *  AtomicLong等类。使用这些类来声明变量可以保证对其操作具有原子性来保证线程安全。
 */

public class Caculator {
    public static  int result = 0;
    //当用方法1解决count的线程问题不需要该句
    public static AtomicInteger i = new AtomicInteger();

    //加法
    public  static  int add(int x,int y) throws InterruptedException{
        result = x+y;
        Thread.sleep(500);
        return result;
    }

    //累加(处理多线程问题，方法一用synchronized给方法加锁，使这个方法同一时间只能一个操作）
    /*
    public synchronized static int count(int x) throws InterruptedException{
        int i = result;
        Thread.sleep(500);
        result = i+x;
        return result;
    }*/

    //累加(处理多线程问题，方法二：java.util.concurrent.atomic:包提供了的AtomicInteger
    public static int count(int x) throws InterruptedException{
        //给i赋值
        i.set(result);
        Thread.sleep(500);
        //获取加x后的值，先加x
        result = i.addAndGet(x);
        return result;
    }

    //减法
    public static int subtract(int x,int y) throws InterruptedException{
        result = x-y;
        Thread.sleep(500);
        return result;
    }

    //乘法
    public static int multiply(int x,int y){
        result = x*y;
        return result;
    }

    //除法
    public static int divide(int x,int y){
        result = x/y;
        return result;
    }

    //清除方法
    public static void clear(){
        result = 0;
        System.out.println("当前结果以清零!");
    }




}
