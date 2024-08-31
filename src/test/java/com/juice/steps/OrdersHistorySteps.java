package com.juice.steps;

import com.juice.logs.Log;
import com.juice.pages.OrdersHistoryPage;
import com.juice.utils.Base;
import com.juice.utils.Hooks;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OrdersHistorySteps extends Base {

    protected OrdersHistoryPage ordersHistoryPage = new OrdersHistoryPage(driver);
    protected Hooks hooks;

    /** Builder **/
    public OrdersHistorySteps(Hooks hooks) {
        this.hooks = hooks;
    }

    @Then("user enter in page {string}")
    public void user_enter_in_page(String url) {
        Allure.getLifecycle().updateTestCase(result ->result.setName("Login on OWASP juice-shop and take screenshot to orders"));
        Allure.label("tag", "Environment: Preprod ");
        Allure.link("Documentatión", "https://github.com/juice-shop/juice-shopeeeee");
        Allure.issue("Bug-123666", "https://Url_del_Bug123333");
        Allure.tms("TMS-123", "https://Url donde esta la descripcion");
        Allure.epic("EPIC: Testing And Integration To Plataform OWASP Juice Shop");
        Log.info("User go to order history page");
        driver.get(url);
    }

    @Then("take screenshot to purchase orders and save to {string}")
    public void take_screenshot_to_purchase_orders_and_save_to_My_screenshot(String OrdersScreenshot) {
        Log.info("User take screenshot to purchase orders and save to package screenshots");
        String expected_title = "Total Price";
        WebElement title = new WebDriverWait(hooks.getDriver(), Duration.ofSeconds(TIME_OUT))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//div[contains(text(),'Total Price')])[1]")));
        Assert.assertEquals(title.getText(), expected_title);
        ordersHistoryPage.takeScreenshotToPurchaseOrders(OrdersScreenshot);
    }
}