package com.juice.factory;

import com.juice.utils.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFactory extends Base {

    /** WebElements Locators **/
    @FindBy(xpath = "//span[contains(text(),'Dismiss')]") protected WebElement btnDismiss;

    @FindBy(id = "email") protected WebElement inputEmail;

    @FindBy(id = "password") protected WebElement inputPass;

    @FindBy(id = "loginButton")
    @CacheLookup
    protected WebElement btnLogin;

    /** Builder **/

    public LoginFactory (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /** Methods **/

    public void fillOutFormLogin(String email, String pass) {
        btnDismiss.click();
        inputEmail.sendKeys(email);
        inputPass.sendKeys(pass);
    }

    public void clickOnLogin() {
        btnLogin.click();
    }
}