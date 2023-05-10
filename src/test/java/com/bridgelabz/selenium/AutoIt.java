package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoIt
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
    public void file_Upload()
    {
//        AutoItX autoIt = new AutoItX();
        driver.get("https://www.example.com");
        driver.findElement(By.id("upload-button")).click();
//        autoIt.winWaitActive("File Upload");
//        autoIt.controlSetText("File Upload", "", "Edit1", "C:\\path\\to\\file.txt");
//        autoIt.controlClick("File Upload", "", "Button1");
    }
}
