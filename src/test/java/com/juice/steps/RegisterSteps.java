package com.juice.steps;

import com.juice.logs.Log;
import com.juice.pages.RegisterPage;
import com.juice.utils.Base;
import com.juice.utils.Hooks;
import io.cucumber.java.en.And;
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

public class RegisterSteps extends Base {

    protected RegisterPage registerPage = new RegisterPage(driver);
    protected Hooks hooks;

    /** Builder **/
    public RegisterSteps(Hooks hooks) {
        this.hooks = hooks;
    }

    @Given("new user is on register page {string}")
    public void new_user_is_on_register_page(String url) {
        Allure.getLifecycle().updateTestCase(result ->result.setName("Register on OWASP juice-shop"));  // --Allure ok
        Allure.label("tag", "Environment: Preprod ");   // --Allure ok
        Allure.link("Documentatión", "https://github.com/juice-shop/juice-shopeeeee");  // --Allure ok
        Allure.issue("Bug-123321", "https://Url_del_Bug123111");   // --Allure ok
        Allure.tms("TMS-123", "https://Url donde esta la descripcion");  // --Allure ok
        Allure.epic("EPIC: Testing And Integration To Plataform OWASP Juice Shop");  // --Allure ok section Behaviors
        Log.info("A new user is on register page");
        driver.get(url);
    }

    @When("user fill out form with {string} {string} {string} {string}")
    public void user_fill_out_form_with(String email, String pass, String repass, String answer) {
        Log.info("A new user fill out form with to register");
        registerPage.fillOutForm(email, pass, repass, answer);
    }

    @And("user clicks on register")
    public void user_clicks_on_register() {
        Log.info("A new user clicks on register");
        registerPage.clickOnRegister();
    }

    @Then("system create new account for each new user")
    public void system_create_new_account_for_each_new_user() {
        Log.info("The system create new account for each new user");
        String expected_header = "Login";
        WebElement title = new WebDriverWait(hooks.getDriver(), Duration.ofSeconds(TIME_OUT))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h1[contains(text(),'Login')]")));
        Assert.assertEquals(title.getText(), expected_header);
    }
}