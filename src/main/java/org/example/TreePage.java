package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TreePage extends BasePage {

    public TreePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public ShoppingCartPage clickAddToCartButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        WebElement button = getDriver().findElement(By.xpath("//button[@type='submit']"));
        button.click();
        return new ShoppingCartPage(getDriver(), getWait());
    }
}
