package com.junit5.demo;

import com.junit5.example.Junit5Fixtures;
import org.junit.jupiter.api.*;

//添加继承Junit5Fixtures
public class Junit5Demo04FixturesExtendTest extends Junit5Fixtures {
    @BeforeAll
    public static void beforeChildAll(){
        System.out.println("Child beforeAll");
    }

    @AfterAll
    public static void afterChildAll(){
        System.out.println("Child afterAll");
    }

    @BeforeEach
    public void beforeChildEach(){
        System.out.println("Child beforeEach");
    }

    @AfterEach
    public void afterChildEach(){
        System.out.println("Child afterEach");
    }

    @Test
    public void testChild01(){
        System.out.println("Child test01");
    }
    @Test
    public void testChild02(){
        System.out.println("Child test02");
    }
    @Test
    public void testChild03(){
        System.out.println("Child test01");
    }

}
