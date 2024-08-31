package com.juice.steps;

import com.juice.factory.AddAddressFactory;
import com.juice.logs.Log;
import com.juice.utils.Base;
import com.juice.utils.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AddAddressSteps extends Base {

    protected AddAddressFactory addAddressFactory = new AddAddressFactory(driver);
    protected Hooks hooks;

    /** Builder **/
    public AddAddressSteps(Hooks hooks) {
        this.hooks = hooks;
    }

    @Given("user enter log in page {string}")
    public void user_enter_log_in_page(String url) {
        Allure.getLifecycle().updateTestCase(result ->result.setName("Login on OWASP juice-shop and add Shipping Address"));
        Allure.label("tag", "Environment: QA ");
        Allure.link("Documentatión", "https://github.com/juice-shop/juice-shopeeeee");
        Allure.issue("Bug-123321", "https://Url_del_Bug123222");
        Allure.tms("TMS-123", "https://Url donde esta la descripcion");
        Allure.epic("EPIC: Testing And Integration To Plataform OWASP Juice Shop");
        //Allure.label("owner", "JaimeT");
        //Allure.label("severity", "minor");
        Log.info("User go to login page");
        driver.get(url);
    }

    @When("user log in with credentials")
    public void user_log_in_with_credentials(io.cucumber.datatable.DataTable dataTable) {
        Log.info("Login with credentials corrects");
        List<List<String>> loginData = dataTable.asLists();
        for (List<String> list : loginData) {
            addAddressFactory.loginWhitCredentials(list.get(0), list.get(1));
        }
    }

    @When("user goes to Add New Address {string}")
    public void user_goes_to_add_new_address(String url) {
        Log.info("user goes to Add New Address register");
        driver.get(url);
    }

    @When("user fill out form to New Address")
    public void user_fill_out_form_to_new_address(io.cucumber.datatable.DataTable dataTable) {
        Log.info("user fill out form to New Address");
        List<List<String>> loginData = dataTable.asLists();
        for (List<String> list : loginData) {
            addAddressFactory.fillOutFormAddNewAddress(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6));
        }
    }

    @When("user fill out form twice")
    public void user_fill_out_form_twice(io.cucumber.datatable.DataTable dataTable) {
        Log.info("User fill out form to address register twice");
        List<List<String>> loginData = dataTable.asLists();
        for (List<String> list : loginData) {
            addAddressFactory.fillOutFormAddNewAddressTwo(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6));
        }
    }

    @Then("the addresses are saved")
    public void the_addresses_are_saved() {
        Log.info("the addresses are saved ok");
        String expected_header = "My saved addresses";
        WebElement title = new WebDriverWait(hooks.getDriver(), Duration.ofSeconds(TIME_OUT))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h1[contains(text(),'My saved addresses')]")));
        Assert.assertEquals(title.getText(), expected_header);
    }
}