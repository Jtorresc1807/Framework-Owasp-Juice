package com.juice.steps;

import com.juice.factory.OrdersFactory;
import com.juice.logs.Log;
import com.juice.utils.Base;
import com.juice.utils.Hooks;
import com.juice.utils.ProductSelector;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Listeners(com.juice.listeners.CustomListeners.class)
//@Epic("Epic - Login Module")
//@Feature("Feature - Login validation for the application demo.nopcommerce.com with different test cases")

public class OrdersSteps extends Base {

    protected OrdersFactory ordersFactory = new OrdersFactory(driver);
    protected Hooks hooks;

    public OrdersSteps(Hooks hooks) {
        this.hooks = hooks;
    }

    @Test(testName = "User add 3 products apple, banana and t_shirt", priority = 1, groups = {"Regression", "Integration"})
    @Description("Test Description: Add 3 products to basket to do purchase")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Jaime Torres")
    @Story("User story 456732, Sprint 65")
    @Name("User add 3 products to basket")
    @Then("user add {int} products \\(Apple, Banana, T-shirt) to basket")
    public void user_add_products_apple_banana_t_shirt_to_basket(Integer int1, io.cucumber.datatable.DataTable dataTable) {
        Log.info("The user add 3 products... (Apple, Banana, T-shirt)");
        List<List<String>> loginData = dataTable.asLists();
        for (List<String> list : loginData) {
            ordersFactory.add3ProductsToBasket(list.get(0), list.get(1), list.get(2));
        }
    }

    @When("select second address and first payment methods")
    public void select_second_address_and_first_payment_methods() {
        Log.info("The user select second address and first payment methods");
        ordersFactory.doProductsCheckout();
    }

    @When("do purchase")
    public void do_purchase() {
        Log.info("The user do purchase");
        ordersFactory.doPurchaseOfProducts();
        String expected_confirmation = "Thank you for your purchase!";
        WebElement title = new WebDriverWait(hooks.getDriver(), Duration.ofSeconds(TIME_OUT))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h1[@class='confirmation']")));
        Assert.assertEquals(title.getText(), expected_confirmation);
    }

    @Then("user add two products to basket")
    public void user_add_two_products_to_basket() {
        Log.info("The user add two products random to basket");
        ordersFactory.add2ProductsToBasket();
       /*   ProductSelector selector = new ProductSelector(driver);
        List<WebElement> selectedProducts = selector.selectRandomProducts(2);

        for (WebElement product  : selectedProducts) {
            product.click();
        } */
    }
}

