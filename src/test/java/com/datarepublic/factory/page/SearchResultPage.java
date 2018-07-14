package com.datarepublic.factory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    private final WebDriver driver;

    @FindBy(css = "input[aria-label='Brand New']")
    private WebElement filterBrandNew;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectFirstResult() {
        filterBrandNew.click();
        driver.findElement(By.cssSelector("#srp-river-results-listing1>div:nth-child(1)>div:nth-child(1)")).click();
    }

}
