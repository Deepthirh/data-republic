package com.datarepublic.factory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Optional;

public class ShoppingCartPage {

    private final WebDriver driver;

    @FindBy(css = "table.cartSummaryTable")
    private WebElement cartSummaryTable;

    @FindBy(css = "a#contShoppingBtn")
    private WebElement continueShopping;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void containsProduct(String itemText) {
        Optional<WebElement> element = Optional.ofNullable(driver.findElement(By.partialLinkText(itemText)));

        WebElement webElement = element.orElseThrow(() -> new NoSuchElementException(String.format("Product with name '%s' not found in the cart.", itemText)));
        Assert.assertTrue(webElement.isDisplayed());
    }

    public void hasItems(Integer numberOfItems) {
        boolean contains = cartSummaryTable.getText().contains(String.format("Subtotal (%d item%s)", numberOfItems, numberOfItems > 1 ? "s" : ""));

        Assert.assertTrue(contains, "The item does not seem to be added in the cart!");
    }

    public void continueShopping() {
        continueShopping.click();
    }
}
