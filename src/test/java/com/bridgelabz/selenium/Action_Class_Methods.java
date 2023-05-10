package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Action_Class_Methods
{
    public WebDriver driver;
    @BeforeSuite
    public void launchChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @BeforeMethod
    public void facebook() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test (dependsOnMethods = "facebook")
    public void contact_Click_Method() throws InterruptedException {
        WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
        Actions actions = new Actions(driver);
        actions.contextClick(pass).perform();
        Thread.sleep(2000);
    }

    @Test
    public void dragAndDrop_Method() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.switchTo().frame(0);
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement des = driver.findElement(By.xpath("//p[text()='Drop here']"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(src,des).perform();
//        actions.moveToElement(src).clickAndHold().perform();
        actions.release(des).perform();
        Thread.sleep(5000);
    }

    @Test
    public void double_Click_Method() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
        actions.doubleClick(pass).perform();
        Thread.sleep(5000);
        actions.doubleClick(email).perform();
        Thread.sleep(5000);
    }
    @Test
    public void keyboard_Method() throws InterruptedException, AWTException {
        WebElement element = driver.findElement(By.partialLinkText("Forgotten password"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.DOWN).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_UP);
//        robot.keyRelease(KeyEvent.VK_UP);
//        Thread.sleep(2000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        Thread.sleep(5000);
    }

    @Test
    public void google_ShortCut_Method() throws InterruptedException {
        driver.get("https://www.google.com/");
//        WebElement search = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        actions.sendKeys("selenium").perform();
        Thread.sleep(2000);
        actions.keyDown(Keys.CONTROL).sendKeys("A").perform();
        actions.keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        actions.keyDown(Keys.CONTROL).sendKeys("C").perform();
        actions.keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);
        actions.keyDown(Keys.CONTROL).sendKeys("T").perform();
        actions.keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);
        actions.keyDown(Keys.CONTROL).sendKeys("V").perform();
        actions.keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);
    }


    @AfterSuite //(enabled = false)
    public void close()
    {
        driver.close();
    }
}
