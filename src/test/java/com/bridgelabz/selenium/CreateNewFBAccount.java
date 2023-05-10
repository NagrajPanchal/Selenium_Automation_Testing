//******************************************************
//Author Name : Nagraj Panchal
//Project     : Selenium Automation Testing - Facebook
//Date        : 10/10/2023
//******************************************************

package com.bridgelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class CreateNewFBAccount extends BaseLaunch
{
    @Test (priority = 1)
    public void login() throws InterruptedException, AWTException {
        WebElement emailID = driver.findElement(By.xpath("//input[@id='email']"));
        int locX = emailID.getLocation().getX();
        int locY = emailID.getLocation().getY();
        System.out.println("Location X : "+locX);
        System.out.println("Location Y : "+locY);
        Robot robot = new Robot();
        robot.mouseMove(locX,locY);
        Thread.sleep(5000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_G);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_J);
        robot.keyRelease(KeyEvent.VK_J);
        Thread.sleep(5000);
        emailID.clear();
        Thread.sleep(5000);
        WebElement email = driver.findElement(By.cssSelector("input[id='email']"));
        email.sendKeys("NagrajSPanchal@gmail.com");
        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("omshiva");
        WebElement btn_login = driver.findElement(By.name("login"));
        btn_login.click();
        Thread.sleep(5000);
    }
    @Test (priority = 2, dependsOnMethods = "login")
    public void navigateToFlipkart() throws InterruptedException
    {
        Thread.sleep(3000);
        driver.navigate().to("https://www.flipkart.com/");
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().back();
    }

    @Test (priority = 3)
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
        driver.findElement(By.name("websubmit")).click();
    }
}
