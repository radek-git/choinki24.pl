package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class KindPage extends BasePage {

    public KindPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public TreePage clickCheapestAvailableTree() {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> items = getDriver().findElements(By.xpath("//div[@class='product-inner-wrap' and ./div[contains(@class, 'buttons')]/form/fieldset/button/span/text()='Do koszyka']"));
        System.out.println(items.size());

        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        Map<WebElement, Integer> firs = new HashMap<>();

        for (WebElement item : items) {
            getWait().until(ExpectedConditions.elementToBeClickable(item.findElement(By.xpath("a"))));
            WebElement link = item.findElement(By.xpath("a"));
            WebElement priceDiv = item.findElement(By.xpath("div[contains(@class, 'price')]/em"));
            String priceString = priceDiv.getText();
            int index = priceString.indexOf(",");
            priceString = priceString.substring(0, index);
            Integer price = Integer.parseInt(priceString);
            firs.put(link, price);
        }

        Map<WebElement, Integer> sortedFirs = MapUtil.sortByValue(firs);
        for (Map.Entry<WebElement, Integer> e : sortedFirs.entrySet()) {
            e.getKey().click();
            return new TreePage(getDriver(), getWait());
        }

        return null;
    }

    public HomePage backToHomePage() {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'link-logo-img')]")));
        WebElement logoLink = getDriver().findElement(By.xpath("//a[contains(@class, 'link-logo-img')]"));
        logoLink.click();
        return new HomePage(getDriver(), getWait());
    }



}
