package com.juice.pages;

import com.juice.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Base {

    /** webElements Locators **/
    By btnDismiss = By.xpath("//span[contains(text(),'Dismiss')]");
    By inputEmail = By.id("emailControl");
    By inputPass = By.id("passwordControl");
    By inputRepass = By.id("repeatPasswordControl");
    By inputAnswer = By.id("securityAnswerControl");
    By btnRegister = By.id("registerButton");

    By DwnBoxQuestion = By.xpath("(//span[contains(@class,'mat-select-min-line')])[1]");
    By inputOptionQuestion = By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span");


    /** Builder **/
    public RegisterPage (WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    /** Methods **/

    public void fillOutForm(String email, String pass, String repass, String answer) {
        driver.findElement(btnDismiss).click();
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPass).sendKeys(pass);
        driver.findElement(inputRepass).sendKeys(repass);
        driver.findElement(DwnBoxQuestion).click();
        driver.findElement(inputOptionQuestion).click();
        driver.findElement(inputAnswer).sendKeys(answer);
    }

    public void clickOnRegister() {
        driver.findElement(btnRegister).click();
    }

}

