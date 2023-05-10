package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ScrollUpandDowntospecificElementonWebpage
{
    public WebDriver driver;
    @BeforeSuite
    public void launchChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("http://seleniumhq.org/download");
        WebElement ele = driver.findElement(By.xpath("//img[contains(@src,'applitools')]"));
        int x = ele.getLocation().getX();
        int y = ele.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+", "+y+")");
        Thread.sleep(2000);
        driver.findElement(By.name("submit")).click();
        Thread.sleep(5000);
    }

    @AfterSuite (enabled = true)
    public void close()
    {
        driver.close();
    }
}
