package com.juice.utils;

import com.juice.logs.Log;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class Hooks extends Base{

    @Before
    public  void setUp() {
        Log.info("Instantiating Browser...");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        Log.info("Maximize the window...");
        driver.manage().window().maximize();
        Log.info("Delete Cookies...");
        driver.manage().deleteAllCookies();
    }

    @After
    public  void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = (byte[])((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Log.info("Tests are ending ... ");
        if (driver != null) {
            //driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}