package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class Login
{
    public WebDriver driver;
    @BeforeSuite
    public void launchChrome()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
    @BeforeClass
    public void launchFaceBook()
    {
        driver.get("https://www.facebook.com/");
    }

    @Test (priority = 1)
    public void login()
    {
        WebElement emailID = driver.findElement(By.id("email"));
        emailID.sendKeys("nagrajPanchal@gmail.com");
        WebElement pass = driver.findElement(By.name("pass"));
        pass.sendKeys("Panchal");
        WebElement btn_login = driver.findElement(By.xpath("//*[@name=\"login\"]"));
        btn_login.click();
    }

    @AfterSuite
    public void Close() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
