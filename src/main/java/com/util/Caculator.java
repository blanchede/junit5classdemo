package com.util;

public class Caculator {
    public static  int result = 0;

    //加法
    public  static  int add(int x,int y){
        result = x+y;
        return result;
    }

    //累加
    public static int count(int x) throws InterruptedException{
        int i = result;
        Thread.sleep(500);
        result = i+x;
        return result;
    }

    //减法
    public static int subtract(int x,int y){
        result = x-y;
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




}
