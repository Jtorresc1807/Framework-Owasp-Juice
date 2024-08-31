package com.juice.factory;

import com.juice.utils.Base;
import com.juice.utils.ProductSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrdersFactory extends Base {

    /** WebElements Locators **/
    @FindBy(xpath = "//a[@class='cc-btn cc-dismiss']") protected WebElement btnCookies;
    @FindBy(xpath = "//mat-icon[contains(text(),' search ')]") protected WebElement iconSearch;
    @FindBy(id = "mat-input-0") protected WebElement searchField;
    @FindBy(xpath = "//span[contains(text(),'Add to Basket')]") protected WebElement btnAddBasket;
    @FindBy(xpath = "//span[contains(text(),' Your Basket')]") protected WebElement btnYourBasket;
    @FindBy(id = "checkoutButton") protected WebElement btnCheckout;
    @FindBy(xpath = "(//span[@class='mat-radio-container'])[2]") protected WebElement radioAddress;
    @FindBy(xpath = "//button[@aria-label='Proceed to payment selection']") protected WebElement btnContinue;
    @FindBy(xpath = "(//span[@class='mat-radio-container'])[1]") protected WebElement radioDelivery;
    @FindBy(xpath = "//button[@aria-label='Proceed to delivery method selection']") protected WebElement btnContinueDel;
    @FindBy(xpath = "(//span[@class='mat-radio-outer-circle'])[1]") protected WebElement radioPayment;
    @FindBy(xpath = "//button[@aria-label='Proceed to review']") protected WebElement btnContinuePay;
    @FindBy(xpath = "//button[@aria-label='Complete your purchase']") protected WebElement btnOrderAndPAy;

    /** Builder **/

    public OrdersFactory (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /** Methods **/

    public void add3ProductsToBasket(String product1, String product2, String product3 ){
        btnCookies.click();
        iconSearch.click();
        searchField.sendKeys(product1);
        searchField.sendKeys(Keys.ENTER);
        btnAddBasket.click();
        searchField.clear();
        searchField.sendKeys(product2);
        searchField.sendKeys(Keys.ENTER);
        btnAddBasket.click();
        iconSearch.click();
        searchField.clear();
        searchField.sendKeys(product3);
        searchField.sendKeys(Keys.ENTER);
        btnAddBasket.click();
    }

    public void doProductsCheckout(){
        btnYourBasket.click();
        WebDriverWait wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mat-simple-snack-bar-content']")));
        btnCheckout.click();
        radioAddress.click();
        btnContinue.click();
        radioDelivery.click();
        btnContinueDel.click();
        radioPayment.click();
        btnContinuePay.click();
    }

    public void doPurchaseOfProducts(){
        btnOrderAndPAy.click();
    }

    public void add2ProductsToBasket(){
        btnCookies.click();
        ProductSelector selector = new ProductSelector(driver);
        List<WebElement> selectedProducts = selector.selectRandomProducts(3);
        for (WebElement btnAddBasket : selectedProducts) {
            btnAddBasket.click();
        }
    }
}