package com.juice.pages;


import com.juice.utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class OrdersHistoryPage extends Base {

    /** webElements Locators **/


    /** Builder **/
    public OrdersHistoryPage (WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    /** Methods **/

    public void takeScreenshotToPurchaseOrders(String OrdersScreenshot){
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("src/test/java/" + OrdersScreenshot + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}