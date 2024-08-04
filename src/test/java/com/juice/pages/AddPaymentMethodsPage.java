package com.juice.pages;

import com.juice.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddPaymentMethodsPage extends Base {

    /** webElements Locators **/
    By btnAddNewCard = By.xpath("(//mat-expansion-panel-header[@id='mat-expansion-panel-header-0'])[1]");
    By inpName = By.xpath("(//input[@type='text'])[2]");
    By inpCardNumber = By.xpath("//input[@type='number']");
    By btnCookies = By.xpath("//a[@class='cc-btn cc-dismiss']");
    By btnSubmit = By.xpath("//button[@color='primary']");

    /** Builder **/
    public AddPaymentMethodsPage (WebDriver driver){
       PageFactory.initElements(driver, this);

    }

    /** Methods **/


    public void fillOutFormAddPaymentMethods(String name, String cardnumber){
        driver.findElement(btnCookies).click();
        driver.findElement(btnAddNewCard).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Language has been changed to English')]")));
        driver.findElement(inpName).sendKeys(name);
        driver.findElement(inpCardNumber).sendKeys(cardnumber);
        WebElement expMonth = driver.findElement(By.xpath("(//select[@aria-required='true'])[1]"));
        Select cbexpMonth = new Select(expMonth);
        cbexpMonth.selectByValue("10");
        WebElement expYear = driver.findElement(By.xpath("(//select[@aria-required='true'])[2]"));
        Select cbexpYear = new Select(expYear);
        cbexpYear.selectByValue("2080");
        driver.findElement(btnSubmit).click();
        driver.navigate().refresh();
    }


    public void fillOutFormAddPaymentMethodsTwo(String name, String cardnumber){
        driver.findElement(btnAddNewCard).click();
        driver.findElement(inpName).sendKeys(name);
        driver.findElement(inpCardNumber).sendKeys(cardnumber);
        WebElement expMonth = driver.findElement(By.xpath("(//select[@aria-required='true'])[1]"));
        Select cbexpMonth = new Select(expMonth);
        cbexpMonth.selectByValue("8");
        WebElement expYear = driver.findElement(By.xpath("(//select[@aria-required='true'])[2]"));
        Select cbexpYear = new Select(expYear);
        cbexpYear.selectByValue("2090");
        driver.findElement(btnSubmit).click();
    }
}
