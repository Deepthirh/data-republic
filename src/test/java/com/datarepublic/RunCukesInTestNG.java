package com.datarepublic;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumberHtmlReport",     //  for html result
                "json:target/cucumber-json-report.json"   // for json result
        },
        features = "src/test/resources/features/ebay-shopping-cart.feature")
public class RunCukesInTestNG extends AbstractTestNGCucumberTests {

    @Parameters("browserName")
    @BeforeTest
    public void beforeTest(String browserName) {
        System.setProperty("data.republic." + browserName.toLowerCase(), "not-used");
    }
}
