package com.bridgelabz.selenium;

import org.openqa.selenium.*;
import org.testng.annotations.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyEvent_Robot extends BaseLaunch
{
   @Test
   public void KeyEvent_Using_Robot() throws AWTException, InterruptedException {
       Robot robot = new Robot();
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
       robot.keyPress(KeyEvent.VK_CONTROL);
       robot.keyPress(KeyEvent.VK_A);
       robot.keyRelease(KeyEvent.VK_A);
       robot.keyPress(KeyEvent.VK_C);
       robot.keyRelease(KeyEvent.VK_C);
       robot.keyRelease(KeyEvent.VK_CONTROL);
       driver.findElement(By.id("pass")).click();
//       robot.keyPress(KeyEvent.VK_TAB);
//       robot.keyRelease(KeyEvent.VK_TAB);
       robot.keyPress(KeyEvent.VK_CONTROL);
       robot.keyPress(KeyEvent.VK_V);
       robot.keyRelease(KeyEvent.VK_V);
       robot.keyRelease(KeyEvent.VK_CONTROL);
       Thread.sleep(5000);
   }
}
