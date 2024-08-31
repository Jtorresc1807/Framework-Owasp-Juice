package com.juice.steps;

import com.juice.factory.OrdersFactory;
import com.juice.listeners.CustomListeners;
import com.juice.logs.Log;
import com.juice.utils.Base;
import com.juice.utils.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.time.Duration;
import java.util.List;

@Listeners(CustomListeners.class)

public class OrdersSteps extends Base {

    protected OrdersFactory ordersFactory = new OrdersFactory(driver);

    protected Hooks hooks;

    public OrdersSteps(Hooks hooks) {
        this.hooks = hooks;
    }

    @Then("user add {int} products \\(Apple, Banana, T-shirt) to basket")
    public void user_add_products_apple_banana_t_shirt_to_basket(Integer int1, DataTable dataTable) {
        Allure.getLifecycle().updateTestCase(result ->result.setName("Login on OWASP juice-shop and add products to basket and do purchase"));
        Allure.label("tag", "Environment: QA ");
        Allure.link("Documentatión", "https://github.com/juice-shop/juice-shopeeeee");
        Allure.issue("Bug-123555", "https://Url_del_Bug123333");
        Allure.tms("TMS-123", "https://Url donde esta la descripcion");
        Allure.epic("EPIC: Testing And Integration To Plataform OWASP Juice Shop");
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
        }     */
    }
}