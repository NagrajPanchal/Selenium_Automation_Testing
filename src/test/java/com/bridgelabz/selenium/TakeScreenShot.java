package com.bridgelabz.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;

public class TakeScreenShot extends BaseLaunch
{
    @Test
    public void Take_ScreenShort() throws InterruptedException, IOException
    {
        Thread.sleep(5000);
        WebElement mobileNumber = driver.findElement(By.id("email"));
        mobileNumber.sendKeys("9739713842");
        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("Panchal");
        Thread.sleep(5000);
        TakesScreenshot ts = (TakesScreenshot)driver;
        File SFile = ts.getScreenshotAs(OutputType.FILE);
        File DFile = new File(".\\Selenium_Automation\\"+"Facebook.png");
        FileUtils.copyFile(SFile, DFile);
    }
}
