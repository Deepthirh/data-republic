package com.datarepublic.stepdefinitions;

import com.datarepublic.factory.DriverFactory;
import com.datarepublic.factory.driver.Driver;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class EBayShoppingCartStepDefinition {

    private WebDriver driver;

    @Before
    public void beforeScenario() {
        String browserName = System.getProperty("browserName", "chrome");
        Optional<Driver> optionalDriver = DriverFactory.getInstance().getDriver(browserName);
        driver = optionalDriver.orElseThrow(() -> new IllegalArgumentException("Could not find driver for " + browserName)).getWebDriver();
    }

    @Given("^I go to eBay website$")
    public void i_go_to_eBay_website() throws Throwable {
        driver.get("https://www.ebay.com.au/");
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String arg1) throws Throwable {
    }

    @When("^I select first search result$")
    public void i_select_first_search_result() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^It should go to the item page$")
    public void it_should_go_to_the_item_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click on \"([^\"]*)\"$")
    public void i_click_on(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The item should be added to the shopping cart$")
    public void the_item_should_be_added_to_the_shopping_cart() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I verify that the shopping cart shows \"([^\"]*)\" item\\(s\\)$")
    public void i_verify_that_the_shopping_cart_shows_item_s(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
