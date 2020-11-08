package com.junit5.demo;

import com.util.Caculator;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 混合并发类型测试
 * 解决方法：将result这个类变量改变成方法变量
 */
public class Junit5Demo0502mixParallel02Test {

    @RepeatedTest(10)
    public void addTest() throws InterruptedException{
        final int result01 =Caculator.add(4,2);
        System.out.println(result01);
        assertEquals(6,result01);

    }
    @RepeatedTest(10)
    public void subTractTest() throws InterruptedException{
        int result =Caculator.subtract(4,2);
        System.out.println(result);
        assertEquals(2,result);
    }
}
