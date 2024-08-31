package com.juice.pages;

import com.juice.utils.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

            // Crear un formato de fecha y hora genera un timestamp único.
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = dateFormat.format(new Date());

            // Crear el nombre del archivo con timestamp
            String fileName = "src/test/java/" + OrdersScreenshot + "_" + timestamp + ".png";

            FileUtils.copyFile(screenshotFile, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}