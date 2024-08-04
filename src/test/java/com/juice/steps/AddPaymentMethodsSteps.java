package com.juice.steps;

import com.juice.logs.Log;
import com.juice.pages.AddPaymentMethodsPage;
import com.juice.utils.Base;
import com.juice.utils.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AddPaymentMethodsSteps extends Base {

    protected AddPaymentMethodsPage addPaymentMethodsPage = new AddPaymentMethodsPage(driver);
    protected Hooks hooks;

    public AddPaymentMethodsSteps(Hooks hooks) {     //Builder
        this.hooks = hooks;
    }

    @When("user goes to Add New Payment Methods {string}")
    public void user_goes_to_add_new_payment_methods(String url) {
        Log.info("user goes to Add New Payment Methods");
        driver.get(url);
    }


    @When("user fill out form to add Payment Methods")
    public void user_fill_out_form_to_add_payment_methods(io.cucumber.datatable.DataTable dataTable) {
        Log.info("user fill out form to add Payment Methods");
        List<List<String>> loginData = dataTable.asLists();
        for (List<String> list : loginData) {
            addPaymentMethodsPage.fillOutFormAddPaymentMethods(list.get(0), list.get(1));
        }
    }


    @When("user fill out form with new Payment Method")
    public void user_fill_out_form_with_new_payment_method(io.cucumber.datatable.DataTable dataTable) {
        Log.info("user fill out form with new Payment Method");
        List<List<String>> loginData = dataTable.asLists();
        for (List<String> list : loginData) {
            addPaymentMethodsPage.fillOutFormAddPaymentMethodsTwo(list.get(0), list.get(1));
        }
    }


    @Then("the Payment Methods are saved")
    public void the_payment_methods_are_saved() {
        Log.info("user saved the Payment Methods");
        WebElement result = new WebDriverWait(hooks.getDriver(), Duration.ofSeconds(TIME_OUT))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='mat-simple-snack-bar-content']")));
        Assert.assertTrue(result.isDisplayed());
    }
}