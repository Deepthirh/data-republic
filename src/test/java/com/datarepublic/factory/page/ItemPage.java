package com.datarepublic.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemPage {

    @FindBy(css = "h1#itemTitle")
    private WebElement itemTextElement;

    @FindBy(css = "a#isCartBtn_btn")
    private WebElement addToCart;

    @FindBy(css = "div.adndesc.addon-overlay-body")
    private WebElement addOnOverlay;

    @FindBy(css = "button.addonbtn.addonnothx.addon-overlay-close-button")
    private List<WebElement> noThanksButtons;
    private String itemText;

    public ItemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        itemText = itemTextElement.getText();
        addToCart.click();
        if (addOnOverlay.isDisplayed()) {
            noThanksButtons.get(1).click();
        }
    }

    public String getItemText() {
        return itemText;
    }
}
