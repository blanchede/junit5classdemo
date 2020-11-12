package com.seleniumstudy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartSeleniumTest {
    public static WebDriver driver;
    //实例化WebDriverWait
    public static WebDriverWait wait;
    @BeforeAll
    public static void initData(){
        System.setProperty("webdriver.chrome.driver", "E:\\driver\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver, 5);
        //添加隐式等待
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
    /*@Test
    public void login(){
        driver.get("https://home.testing-studio.com/");
        driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        driver.findElement(By.id("login-account-name")).clear();
        driver.findElement(By.id("login-account-name")).sendKeys("123456@qq.com");
        driver.findElement(By.id("login-account-password")).clear();
        driver.findElement(By.id("login-account-password")).sendKeys("123456");
        driver.findElement(By.id("login-button")).click();
    }*/


    //直接等待，不推荐使用
    /*
    @Test
    public void timeSleepTest(){
        driver.get("https://home.testing-studio.com/");
        try {
            Thread.sleep(5000);
            driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    //显式等待
    @Test
    public void waitTest(){
        driver.get("https://home.testing-studio.com/");
        //driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        //写法一
        /*
        WebElement loginEle = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//span[contains(text(),'登录')]"));
            }
        });
        loginEle.click();
         */

        //写法二
        WebElement element= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'登录')]")));
        element.click();

    }

    @AfterAll
    public static void tearDown(){
        //driver.quit();
    }
}
