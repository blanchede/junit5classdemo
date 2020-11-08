package com.junit5.demo;

import com.util.Caculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 基础脚本，分别执行了加减乘除、计数器操作，并打印了结果
 *1.进行了优化：添加自动断言，解决了需要人工检查结果得的问题
 *
 */

public class Junit5Demo02AssertTest {
    @Test
    public void addTest() throws InterruptedException{
        int result =Caculator.add(4,2);
        //Caculator.add(4,2);
        System.out.println(result);
        assertEquals(6,result);
    }
    @Test
    public void subTractTest() throws InterruptedException{
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
