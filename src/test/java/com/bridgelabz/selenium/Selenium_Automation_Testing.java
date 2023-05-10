//******************************************************
//Author Name : Nagraj Panchal
//Project     : Selenium Automation Testing - Facebook
//Date        : 10/10/2023
//******************************************************

package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class Selenium_Automation_Testing
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
    @Test (priority = 1)
    public void getDetailsPage()
    {
        String title = driver.getTitle();
        System.out.println(title);
        String url = driver.getCurrentUrl();
        System.out.println(url);
    }

    @Test (priority = 3)
    public void navigateToFlipkart() throws InterruptedException
    {
        Thread.sleep(3000);
        driver.navigate().to("https://www.flipkart.com/");
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().back();
    }
    @Test (priority = 2)
    public void login() throws InterruptedException
    {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("nagrajsubhashpanchal@gmail.com");
        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("Panchal@123");
        WebElement btn_login = driver.findElement(By.name("login"));
        btn_login.click();
        Thread.sleep(5000);
    }
    @Test (priority = 4)
    public void createNewAccount() throws InterruptedException
    {
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(6000);
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Nagraj");
        WebElement surName = driver.findElement(By.name("lastname"));
        surName.sendKeys("Panchal");
        WebElement mobileOrEmail = driver.findElement(By.name("reg_email__"));
        if(mobileOrEmail.isDisplayed()) {
            mobileOrEmail.sendKeys("8310531227");
        }
        else {
            mobileOrEmail.sendKeys("panchal@gmail.com");
        }
        WebElement newPass = driver.findElement(By.name("reg_passwd__"));
        newPass.sendKeys("Panchal");
        WebElement brithday = driver.findElement(By.name("birthday_day"));
        brithday.sendKeys("23");
        WebElement brithMonth = driver.findElement(By.name("birthday_month"));
        brithMonth.sendKeys("Feb");
        WebElement brithYear = driver.findElement(By.name("birthday_year"));
        brithYear.sendKeys("2000");
        WebElement gender = driver.findElement(By.name("sex"));
        WebElement female = gender.findElement(By.xpath("//input[@value='1']"));
        WebElement male = gender.findElement(By.xpath("//input[@value='2']"));
        WebElement custom = gender.findElement(By.xpath("//input[@value='-1']"));
        if(!gender.isEnabled())
        {
            female.click();
        }
        else if (gender.isEnabled())
        {
            male.click();
        }
        else
        {
            custom.click();
        }

        Thread.sleep(5000);
    }

    @Test (priority = 5)
    public void signUp()
    {
        WebElement btn_signup = driver.findElement(By.name("websubmit"));
        btn_signup.click();
    }

    @AfterSuite //(enabled = false)
    public void close()
    {
        driver.close();
    }

}
