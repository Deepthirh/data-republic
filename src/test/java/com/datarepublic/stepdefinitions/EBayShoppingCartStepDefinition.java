package com.datarepublic.stepdefinitions;

import com.datarepublic.factory.DriverFactory;
import com.datarepublic.factory.driver.Driver;
import com.datarepublic.factory.page.EBayHomePage;
import com.datarepublic.factory.page.ItemPage;
import com.datarepublic.factory.page.SearchResultPage;
import com.datarepublic.factory.page.ShoppingCartPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class EBayShoppingCartStepDefinition {

    private WebDriver driver;

    private EBayHomePage eBayHomePage;
    private SearchResultPage searchResultPage;
    private ItemPage itemPage;
    private ShoppingCartPage shoppingCartPage;

    @Before
    public void beforeScenario() {
        String browserName = System.getProperty("browserName", "chrome");
        Optional<Driver> optionalDriver = DriverFactory.getInstance().getDriver(browserName);
        driver = optionalDriver.orElseThrow(() -> new IllegalArgumentException("Could not find driver for " + browserName)).getWebDriver();
    }

    @Given("^I go to eBay website$")
    public void i_go_to_eBay_website() {
        driver.get("https://www.ebay.com.au/");
        eBayHomePage = new EBayHomePage(driver);
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String searchText) {
        eBayHomePage.searchFor(searchText);
    }

    @When("^I select first search result$")
    public void i_select_first_search_result() {
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.selectFirstResult();
    }

    @Then("^It should go to the item page$")
    public void it_should_go_to_the_item_page() {
        itemPage = new ItemPage(driver);
    }

    @When("^I click on \"([^\"]*)\"$")
    public void i_click_on(String action) {
        switch (action) {
            case "Add to cart":
                itemPage.addToCart();
                break;

            case "Continue Shopping":
                shoppingCartPage.continueShopping();
                break;

            default:
                throw new IllegalArgumentException("Invalid action '" + action + "'");
        }
    }

    @Then("^The item should be added to the shopping cart$")
    public void the_item_should_be_added_to_the_shopping_cart() {
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Then("^I verify that the shopping cart shows \"([^\"]*)\" item\\(s\\)$")
    public void i_verify_that_the_shopping_cart_shows_item_s(String numberOfItems) {
        shoppingCartPage.containsProduct(itemPage.getItemText());
        shoppingCartPage.hasItems(Integer.valueOf(numberOfItems.trim()));
    }

    @After
    public void afterScenario() {
        driver.close();
        driver.quit();
    }
}
