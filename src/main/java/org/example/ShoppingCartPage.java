package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void selectDeliveryMethod() {
        WebElement option = getDriver().findElement(By.xpath("//div[@class='delivery']/span/span/label"));
        option.click();

    }

    public HomePage clickContinueShopping() {
        WebElement button = getDriver().findElement(By.xpath("(//button[@type='submit'])[3]"));
        button.click();
        return new HomePage(getDriver(), getWait());
    }

    public HomePage backToHomePage() {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'link-logo-img')]")));
        WebElement logoLink = getDriver().findElement(By.xpath("//a[contains(@class, 'link-logo-img')]"));
        logoLink.click();
        return new HomePage(getDriver(), getWait());
    }
}
// kupić najtańszą dostępną choinkę każdego gatunku