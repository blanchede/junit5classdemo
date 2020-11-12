package com.seleniumstudy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.concurrent.TimeUnit;

//动作链接actions
public class InteractiveTest {
    public static WebDriver driver;
    public static Actions actions;
    @BeforeAll
    public static void initData(){
        System.setProperty("webdriver.chrome.driver", "E:\\driver\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        actions=new Actions(driver);
        //添加隐式等待
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void clickTest() throws InterruptedException {
        driver.get("http://sahitest.com/demo/clicks.htm");
        //Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("//input[@value='click me']")));
        actions.doubleClick(driver.findElement(By.xpath("//input[@value='dbl click me']")));
        actions.contextClick(driver.findElement(By.xpath("//input[@value='right click me']")));
        actions.perform();
        Thread.sleep(3000);
    }

    @Test //拖拽到最后一个框
    public void dragTest(){
        try {
            driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
            actions.dragAndDrop(driver.findElement(By.id("dragger")), driver.findElement(By.xpath("//*[@class='item'][last()]"))).perform();
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test //第一个Username手动输入，第二个Username复制输入
    public void keyBoardTest(){
        driver.get("http://sahitest.com/demo/label.htm");
        driver.findElements(By.xpath("//input[@type='textbox']")).get(0).sendKeys("ashin");
        //选中第一个Username内容
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        //复制第一个Username内容
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //driver.findElements(By.xpath("//input[@type='textbox']")).get(0).sendKeys("ashin");
        actions.keyDown(driver.findElements(By.xpath("//input[@type='textbox']")).get(1),Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();


    }

    @Test //百度搜索百度，然后滚动到底端，点击最后一页
    public  void scrollTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("万达广场");
        TouchActions actions = new TouchActions(driver);
        actions.click(driver.findElement(By.id("su")));
        //用js强转driver
        JavascriptExecutor js =(JavascriptExecutor)driver;
        //用js执行从顶部滑动到最底部
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@class='n']")).click();
        Thread.sleep(4000);


    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
