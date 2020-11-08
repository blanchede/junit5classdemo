package com.junit5.demo;

import com.junit5.example.Junit5Fixtures;
import com.util.Caculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 多线程测试
 */
public class Junit5Demo05Parallel01Test {

    @RepeatedTest(10)
    public void countTest() throws InterruptedException{
        int result =Caculator.count(1);
        System.out.println(result);
        //assertEquals(4,result);
    }
}
