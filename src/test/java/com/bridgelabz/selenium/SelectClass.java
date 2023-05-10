package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClass
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
    public void newUser_Registration() throws InterruptedException
    {
        driver.get("file:\\C:\\Users\\user\\Desktop\\CQA_119\\Selenium_Automation\\selectOptions.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("mySelectElement"));
        Select sct = new Select(element);
        Boolean listboxType = sct.isMultiple();
        System.out.println("The list box is Multi Select option list box : "+listboxType);
        List <WebElement>list = sct.getOptions();
        int size = list.size();
        System.out.println("Element Count : "+size);
        for(WebElement webElement : list)
        {
            String text = webElement.getText();
            System.out.println(text);
        }
        sct.selectByIndex(0);
        Thread.sleep(2000);
        sct.selectByValue("option2");
        Thread.sleep(2000);
        sct.selectByVisibleText("Option 3");
        Thread.sleep(2000);
        List <WebElement> list2 = sct.getAllSelectedOptions();
        int size2 = list2.size();
        System.out.println("Selected element count : "+size2);
        for (WebElement webElement2 : list2)
        {
            String text2 = webElement2.getText();
            System.out.println(text2);
        }
        Thread.sleep(2000);
//        sct.deselectByVisibleText("option 3");
//        Thread.sleep(2000);
//        sct.deselectByValue("option2");
//        Thread.sleep(2000);
//        sct.deselectByIndex(0);
        Thread.sleep(2000);




    }
    @AfterClass
    public void close()
    {
        driver.close();
    }
}
