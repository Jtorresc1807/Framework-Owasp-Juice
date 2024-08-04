package com.juice.factory;

import com.juice.utils.Base;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddAddressFactory extends Base {

    /** WebElements Locators **/

    @FindBy(xpath = "//span[contains(text(),'Dismiss')]") protected WebElement btnDismiss;
    @FindBy(xpath = "//span[contains(text(),'Add New Address')]") protected WebElement btnAddNewAddress;
    @FindBy(id = "email") protected WebElement inputEmail;
    @FindBy(id = "password") protected WebElement inputPass;
    @FindBy(id = "loginButton") protected WebElement btnLogin;
    @FindBy(xpath = "//input[@data-placeholder='Please provide a country.']") protected WebElement inpCountry;
    @FindBy(xpath = "//input[@data-placeholder='Please provide a name.']") protected WebElement inpName;
    @FindBy(xpath = "//input[@data-placeholder='Please provide a mobile number.']") protected WebElement inpMobilenumber;
    @FindBy(xpath = "//input[@data-placeholder='Please provide a ZIP code.']") protected WebElement inpZipCode;
    @FindBy(id = "address") protected WebElement inpAddress ;
    @FindBy(xpath = "//input[@data-placeholder='Please provide a city.']") protected WebElement inpCity ;
    @FindBy(xpath = "//input[@data-placeholder='Please provide a state.']") protected WebElement inpState;
    @FindBy(xpath = "//button[@id='submitButton']") protected WebElement btnSubmit;
    //@FindBy()

    /** Builder **/

    public AddAddressFactory (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /** Methods **/

    public void loginWhitCredentials(String email, String pass) {
        btnDismiss.click();
        inputEmail.sendKeys(email);
        inputPass.sendKeys(pass);
        btnLogin.click();
    }

   public void  fillOutFormAddNewAddress(String country, String name, String mobilenumber, String zipcode, String address, String city, String state ){
       btnAddNewAddress.click();
       inpCountry.sendKeys(country);
       inpName.sendKeys(name);
       inpMobilenumber.sendKeys(mobilenumber);
       inpZipCode.sendKeys(zipcode);
       inpAddress.sendKeys(address);
       inpCity.sendKeys(city);
       inpState.sendKeys(state);
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Language has been changed to English')]")));
       btnSubmit.click();
    }

    public void fillOutFormAddNewAddressTwo(String country, String name, String mobilenumber, String zipcode, String address, String city, String state ){
        //btnDismiss.click();
        btnAddNewAddress.click();
        inpCountry.sendKeys(country);
        inpName.sendKeys(name);
        inpMobilenumber.sendKeys(mobilenumber);
        inpZipCode.sendKeys(zipcode);
        inpAddress.sendKeys(address);
        inpCity.sendKeys(city);
        inpState.sendKeys(state);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Language has been changed to English')]")));
        btnSubmit.click();
    }
}
