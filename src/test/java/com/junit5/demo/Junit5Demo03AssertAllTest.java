package com.junit5.demo;

import com.util.Caculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 基础脚本，分别执行了加减乘除、计数器操作，并打印了结果。
 *1.进行了优化：添加自动断言，解决了需要人工检查结果得的问题。
 *2.进行了优化：使用Junit5提供的assertALL进行断言，增加了脚本的容错性。
 */

public class Junit5Demo03AssertAllTest {
    @Test
    public void addTest(){
        final int result01 =Caculator.add(4,2);
        int result02 =Caculator.add(5,2);
        int result03 =Caculator.add(6,2);
        //Caculator.add(4,2);
        System.out.println(result01);
        assertAll(
                ()-> assertEquals(6,result01),
                ()-> assertEquals(6,result02),
                ()-> assertEquals(7,result03)
        );

        //assertEquals(6,result01);
        //assertEquals(6,result02);
        //assertEquals(8,result03);
    }
    @Test
    public void subTractTest(){
        int result =Caculator.subtract(4,2);
        System.out.println(result);
        assertEquals(2,result);
    }

    @Test
    public void multiplyTest(){
        int result =Caculator.multiply(4,2);
        System.out.println(result);
        assertEquals(8,result);
    }

    @Test
    public void divideTest(){
        int result =Caculator.divide(4,2);
        System.out.println(result);
        assertEquals(2,result);
    }

    @Test
    public void countTest() throws InterruptedException{
        int result =Caculator.count(1);
        result =Caculator.count(1);
        result =Caculator.count(1);
        result =Caculator.count(1);
        System.out.println(result);
        assertEquals(4,result);
    }
}
