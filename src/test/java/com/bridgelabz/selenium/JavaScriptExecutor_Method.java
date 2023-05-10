package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JavaScriptExecutor_Method
{
    public WebDriver driver;
    @BeforeSuite
    public void launchChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void scrollUp_And_Down_Function() throws InterruptedException {
        JavascriptExecutor jsexe = (JavascriptExecutor) driver;
        jsexe.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(5000);
        jsexe.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(5000);
    }

    @Test
    public void enter_Text_Enable_And_DisableFild() throws InterruptedException {
        driver.get("file:\\C:\\Users\\user\\Desktop\\CQA_119\\Selenium_Automation\\javascriptExecutor.html");
        JavascriptExecutor jsExecute = (JavascriptExecutor)driver;
        Thread.sleep(5000);
        jsExecute.executeScript("document.getElementById('t1').value='Nagraj Panchal'");
        Thread.sleep(5000);
        jsExecute.executeScript("document.getElementById('t2').value=''");
        Thread.sleep(5000);
        jsExecute.executeScript("document.getElementById('t2').value='Software Engineer'");
        Thread.sleep(5000);
        jsExecute.executeScript("document.getElementById('t2').type='button'");
        Thread.sleep(5000);
    }
    @AfterSuite //(enabled = false)
    public void close()
    {
        driver.close();
    }
}
