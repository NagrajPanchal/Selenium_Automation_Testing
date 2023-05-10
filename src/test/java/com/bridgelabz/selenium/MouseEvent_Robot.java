package com.bridgelabz.selenium;

import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.InputEvent;

public class MouseEvent_Robot extends  BaseLaunch
{
    @Test
    public void mouseEvent_Using_Robot() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.mouseWheel(2);
        Thread.sleep(3000);
        robot.mouseWheel(-2);
        Thread.sleep(3000);
        robot.mouseMove(950,550);
        Thread.sleep(3000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(5000);
    }
}
