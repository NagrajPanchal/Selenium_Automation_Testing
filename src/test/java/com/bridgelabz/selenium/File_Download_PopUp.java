package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class File_Download_PopUp
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
    public void file_Upload() throws InterruptedException {
        String key = "browser.helperApps.neverAsk.saveToDisk";
        String value = "application/zip";
//        profile.setPreference(key, value);
//        profile.setPreference("browser.download.folderList", 2);
//        profile.setPreference("browser.download.dir", "D:\\Ajit\\Others");
        Thread.sleep(2000);
    }

    @AfterClass
    public void close()
    {
        driver.close();
    }
}
