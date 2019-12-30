package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public KindPage clickKindButton() {
        Actions action = new Actions(getDriver());
        WebElement kindButton = getDriver().findElement(By.xpath("//a[@id='headlink18']"));
        action.moveToElement(kindButton).perform();

        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='headercategory51']")));
        WebElement firButton = getDriver().findElement(By.xpath("//a[@id='headercategory51']"));
        firButton.click();

        return new KindPage(getDriver(), getWait());
    }


    public List<WebElement> getKindLinks() {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='headlink18']")));
        return getDriver().findElements(By.xpath("//li[@id='hcategory_42']/div/ul[@class = 'level1']/li/h3/a"));
    }

    public KindPage clickKindLink(WebElement link) {
        Actions action = new Actions(getDriver());
        WebElement kindButton = getDriver().findElement(By.xpath("//a[@id='headlink18']"));
        action.moveToElement(kindButton).perform();
        link.click();
        return new KindPage(getDriver(), getWait());
    }
}


//    Actions action = new Actions(webdriver);
//    WebElement we = webdriver.findElement(By.xpath("html/body/div[13]/ul/li[4]/a"));
//action.moveToElement(we).moveToElement(webdriver.findElement(By.xpa