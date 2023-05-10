package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class WebDriver_Methods
{
    public WebDriver driver;
    @BeforeSuite
    public void setDriver()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
    @BeforeClass
    public void faceBook_Login_Page_get()
    {
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void manage_FBPage() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.manage().window().fullscreen();
        Thread.sleep(1000);
        driver.manage().window().minimize();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        System.out.println("Window Size : "+driver.manage().window().getSize());
        System.out.println("Window Position : "+driver.manage().window().getPosition());
        System.out.println("Window Class : "+driver.manage().window().getClass());
        System.out.println("Window hashCode : "+driver.manage().window().hashCode());
        System.out.println("Cookies : "+driver.manage().getCookies());
    }

    @Test
    public void getTitle()
    {
        String title = driver.getTitle();
        System.out.println("Title : "+title);
    }

    @Test
    public void getURL()
    {
        String url = driver.getCurrentUrl();
        System.out.println("Current URL : "+url);
    }

    @Test
    public void getPageSource()
    {
        String pageSource = driver.getPageSource();
        System.out.println("Page Source : "+pageSource);
    }

    @Test
    public void navigateToFlipkart() throws InterruptedException
    {
        Thread.sleep(3000);
        driver.navigate().to("https://www.flipkart.com/");
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().forward();
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        String str = driver.navigate().toString();
        System.out.println(str);
    }

    @Test
    public void getWindowHandles()
    {
        System.out.println("Welcome to Window Handles");
    }

    @Test
    public void switchTo() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(8000);

    }

    @Test
    public void sleep_FB() throws InterruptedException {
        Thread.sleep(5000);
    }

    @AfterMethod
    public void manage_Logs()
    {
        System.out.println(driver.manage().logs());
    }

    @AfterClass
    public void close()
    {
        driver.close();
    }

    @AfterSuite
    public void quit()
    {
        driver.quit();
    }
}
