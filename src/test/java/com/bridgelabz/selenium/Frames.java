package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class Frames
{
    public WebDriver driver;
    @BeforeClass
    public void launchChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void frames_Functions_using_index() throws InterruptedException {
        driver.get("file:\\C:\\Users\\user\\Desktop\\CQA_119\\Selenium_Automation\\Frame2.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        driver.findElement(By.id("fm")).sendKeys("'Index'");
        Thread.sleep(2000);
        driver.findElement(By.id("first")).sendKeys("'Nagraj'");
        Thread.sleep(2000);
        driver.findElement(By.id("last")).sendKeys("'Panchal'");
        JavascriptExecutor jsexe = (JavascriptExecutor) driver;
        jsexe.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//button[@id='button']"));
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("reg")).sendKeys("User Register");
        Thread.sleep(5000);
    }

    @Test
    public void frames_Functions_using_id_attribute() throws InterruptedException {
        driver.get("file:\\C:\\Users\\user\\Desktop\\CQA_119\\Selenium_Automation\\Frame2.html");
        driver.manage().window().maximize();
        driver.switchTo().frame("f1");
        driver.findElement(By.id("fm")).sendKeys("'ID_Attribute'");
        Thread.sleep(2000);
        driver.findElement(By.id("first")).sendKeys("'Nagraj'");
        Thread.sleep(2000);
        driver.findElement(By.id("last")).sendKeys("'Panchal'");
        JavascriptExecutor jsexe = (JavascriptExecutor) driver;
        jsexe.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//button[@id='button']"));
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("reg")).sendKeys("User Register");
        Thread.sleep(5000);
    }

    @Test
    public void frames_Functions_using_name_attribute() throws InterruptedException {
        driver.get("file:\\C:\\Users\\user\\Desktop\\CQA_119\\Selenium_Automation\\Frame2.html");
        driver.manage().window().maximize();
        driver.switchTo().frame("n1");
        driver.findElement(By.id("fm")).sendKeys("'Name_Attribute'");
        Thread.sleep(2000);
        driver.findElement(By.id("first")).sendKeys("'Nagraj'");
        Thread.sleep(2000);
        driver.findElement(By.id("last")).sendKeys("'Panchal'");
        JavascriptExecutor jsexe = (JavascriptExecutor) driver;
        jsexe.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//button[@id='button']"));
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("reg")).sendKeys("User Register");
        Thread.sleep(5000);
    }

    @Test
    public void frames_Functions_using_address_webElement() throws InterruptedException {
        driver.get("file:\\C:\\Users\\user\\Desktop\\CQA_119\\Selenium_Automation\\Frame2.html");
        driver.manage().window().maximize();
        WebElement frm = driver.findElement(By.className("c1"));
        driver.switchTo().frame(frm);
        driver.findElement(By.id("fm")).sendKeys("'Address_WebElement'");
        Thread.sleep(2000);
        driver.findElement(By.id("first")).sendKeys("'Nagraj'");
        Thread.sleep(2000);
        driver.findElement(By.id("last")).sendKeys("'Panchal'");
        JavascriptExecutor jsexe = (JavascriptExecutor) driver;
        jsexe.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//button[@id='button']"));
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("reg")).sendKeys("User Register");
        Thread.sleep(5000);
    }

    @AfterClass
    public void close()
    {
        driver.close();
    }
}
