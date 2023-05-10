package com.bridgelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebElement_Methods extends BaseLaunch {
    WebElement email;

    @Test
    public void getSize() {
        driver.findElement(By.name("email"));
        int uNameHeight = email.getSize().getHeight();
        int uNameWidth = email.getSize().getWidth();
        System.out.println("User Name Height : " + uNameHeight);
        System.out.println("User Name Width : " + uNameWidth);
        System.out.println("Email " + email.getSize());
    }

    @Test
    public void webElements() throws InterruptedException {
        System.out.println("Email is enable : " + email.isEnabled());
        System.out.println("Email is displayed : " + email.isDisplayed());
        System.out.println("Email is Selected : " + email.isSelected());
        System.out.println("Email Location : " + email.getLocation());
        System.out.println("Email Attribute : " + email.getAttribute("Nagraj"));
        email.sendKeys("Nagraj");
        email.clear();
        String atrributeElementType = driver.findElement(By.name("email")).getAttribute("Type");
        System.out.println("Email Attribute Type : " + atrributeElementType);
        Thread.sleep(5000);
    }

    @Test
    public void getText()
    {
        WebElement lable = driver.findElement(By.xpath("//form"));
        String text = lable.getText();
        System.out.println("Text content is : " + text);
    }


    @Test (enabled = false)
        public void getCssValue()
    {
        WebElement link =driver.findElement(By.xpath("//a[@href=\\\"/recover/\\\"]"));
        String value = link.getCssValue("color");
        System.out.println(value);
    }

    @Test
    public void submit()
    {
        driver.findElement(By.id("pass")).submit();
    }

    @Test
    public void login()
    {
        WebElement btn_login = driver.findElement(By.name("login"));
        btn_login.click();
    }
}
