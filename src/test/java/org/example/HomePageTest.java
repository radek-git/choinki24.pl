package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15);

        driver.get("https://choinka24.pl/");
        driver.manage().window().maximize();

        homePage = new HomePage(driver, wait);
    }



    @Test
    public void selectCheapestFir() {
        int kindLinks = homePage.getKindLinks().size();

        for (int i = 0; i < kindLinks; i++) {
            KindPage kindPage = homePage.clickKindLink(homePage.getKindLinks().get(i)); // link.click();
            TreePage treePage = kindPage.clickCheapestAvailableTree();
            if (treePage != null) {
                ShoppingCartPage shoppingCartPage = treePage.clickAddToCartButton();
                homePage = shoppingCartPage.backToHomePage();
            } else {
                homePage = kindPage.backToHomePage();
            }
        }


    }
}
