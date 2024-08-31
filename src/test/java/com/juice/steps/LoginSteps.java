package com.juice.steps;

import com.juice.factory.LoginFactory;
import com.juice.logs.Log;
import com.juice.utils.Base;
import com.juice.utils.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LoginSteps extends Base {

    protected LoginFactory loginFactory = new LoginFactory((WebDriver) driver);
    protected Hooks hooks;

    public LoginSteps(Hooks hooks) {
        this.hooks = hooks;
    }

    @Given("The user is on the login page {string}")
    public void the_user_is_on_the_login_page(String url) {
        Allure.getLifecycle().updateTestCase(result ->result.setName("Login on OWASP juice-shop"));
        Allure.label("tag", "Environment: DEV ");
        Allure.link("Documentatión", "https://github.com/juice-shop/juice-shopeeeee");
        Allure.issue("Bug-123444", "https://Url_del_Bug123333");
        Allure.tms("TMS-123", "https://Url donde esta la descripcion");
        Allure.epic("EPIC: Testing And Integration To Plataform OWASP Juice Shop");
        Log.info("The user is on the login page");
        driver.get(url);
    }

    @When("user fill out form with credentials ok")
    public void user_fill_out_form_with_credentials_ok(DataTable dataTable) {
        Log.info("The user fill out form with credentials ok");
        List<List<String>> loginData = dataTable.asLists();
        for (List<String> list : loginData) {
            loginFactory.fillOutFormLogin(list.get(0), list.get(1));
        }
    }

    @When("user clicks on Log In")
    public void user_clicks_on_log_in() {
        Log.info("The user clicks on Log In");
        loginFactory.clickOnLogin();
    }

    @Then("user logs into his account")
    public void user_logs_into_his_account() {
        Log.info("The user logs into his account");
        //String expected_header = "All Products FAIl";  //assert fail to Categories Product defects in Allure
        String expected_header = "All Products";
        WebElement title = new WebDriverWait(hooks.getDriver(), Duration.ofSeconds(TIME_OUT))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(text(),'All Products')]")));
        Assert.assertEquals(title.getText(), expected_header);
    }

    @When("user fill out form with credentials fails")
    public void user_fill_out_form_with_credentials_fails(DataTable dataTable) {
        Log.info("The user fill out form with credentials fails");
        List<List<String>> loginData = dataTable.asLists();
        for (List<String> list : loginData) {
            loginFactory.fillOutFormLogin(list.get(0), list.get(1));
        }
    }

    @Then("user see Invalid email or password")
    public void user_see_invalid_email_or_password() {
        Log.info("The user see Invalid email or password");
        String expected_header = "Invalid email or password.";
        WebElement title = new WebDriverWait(hooks.getDriver(), Duration.ofSeconds(TIME_OUT))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(text(),'Invalid email or password.')]")));
        Assert.assertEquals(title.getText(), expected_header);
    }
}