package com.datarepublic.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EBayHomePage {
    @FindBy(css = "input[placeholder='Search for anything']")
    private WebElement searchTextField;

    public EBayHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String searchText) {
        searchTextField.clear();
        searchTextField.sendKeys(searchText + "\n");
    }
}
