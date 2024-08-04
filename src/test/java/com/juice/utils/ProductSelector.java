package com.juice.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductSelector extends Base{
    private WebDriver driver;

    public ProductSelector(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> selectRandomProducts(int count) {
        // Asume que los productos están en elementos con la clase 'product'
        List<WebElement> allProducts = driver.findElements(By.xpath("//mat-grid-tile[contains(@class, 'mat-grid-tile')]"));

        List<WebElement> selectedProducts = new ArrayList<>();
        Random random = new Random();

        // Verifica si hay suficientes productos para seleccionar
        if (allProducts.size() < count) {
            throw new IllegalStateException("No hay suficientes productos para seleccionar " + count + " elementos.");
        }

        for (int i = 0; i < count; i++) {
            if (allProducts.isEmpty()) {
                break; // Salir del bucle si ya no quedan productos
            }
            int randomIndex = random.nextInt(allProducts.size());
            selectedProducts.add(allProducts.get(randomIndex));
            allProducts.remove(randomIndex);
        }

        return selectedProducts;
    }


}
