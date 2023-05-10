package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseLaunch
{
    public WebDriver driver;
    @BeforeSuite
    public void launchChrome() {
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

    @BeforeMethod
    public void setUpPage()
    {
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void getDetailsPage()
    {
        String title = driver.getTitle();
        System.out.println(title);
        String url = driver.getCurrentUrl();
        System.out.println(url);
    }
    @AfterSuite //(enabled = false)
    public void close()
    {
        driver.close();
    }
}
