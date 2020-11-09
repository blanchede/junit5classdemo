package com.junit5.demo;

import com.util.Caculator;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 基础脚本，分别执行了加减乘除、计数器操作，并打印了结果。
 *1.进行了优化：添加自动断言，解决了需要人工检查结果得的问题。
 *2.进行了优化：使用Junit5提供的assertALL进行断言，增加了脚本的容错性。
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic("epic 计算器项目")
@Feature("Feature 冒烟测试用例")
public class Junit5Demo06Allure {
    @Test
    @Order(1)
    @Description("Description 描述")
    @Story("story 加法测试")
    @DisplayName("DisplayName 加法测试")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("www.baidu.com")
    @Link(name = "link 社区贴", type = "mylink", url = "www.baidu.com")
    public void addTest() throws InterruptedException{
        final int result01 =Caculator.add(4,2);
        int result02 =Caculator.add(5,2);
        int result03 =Caculator.add(6,2);
        //Caculator.add(4,2);
        System.out.println(result01);
        assertAll(
                ()-> assertEquals(6,result01),
                ()-> assertEquals(7,result02),
                ()-> assertEquals(8,result03)
        );

        //assertEquals(6,result01);
        //assertEquals(6,result02);
        //assertEquals(8,result03);
    }
    @Test
    @Order(2)
    public void subTractTest() throws InterruptedException{
        int result =Caculator.subtract(4,2);
        System.out.println(result);
        Allure.addAttachment("脚本名称", "减法测试用例！");
        Allure.addAttachment("pic","image/png",this.getClass().getResourceAsStream("/pic01.png"),".png");

        assertEquals(2,result);
    }

    @Test
    @Order(3)
    public void multiplyTest(){
        int result =Caculator.multiply(4,2);
        System.out.println(result);
        assertEquals(8,result);
    }

    @Test
    @Order(4)
    public void divideTest(){
        int result =Caculator.divide(4,2);
        System.out.println(result);
        assertEquals(2,result);
    }

    @BeforeEach //每个Test前面执行
    public void clear(){
        Caculator.clear();
    }

    @Test
    @Order(5)
    public void countTest() throws InterruptedException{
        int result =Caculator.count(1);
        result =Caculator.count(1);
        result =Caculator.count(1);
        result =Caculator.count(1);
        System.out.println(result);
        assertEquals(4,result);
    }
}
