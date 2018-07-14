package com.datarepublic.factory.driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractDriver implements Driver {

    @Override
    public WebDriver getWebDriver() {
        WebDriver driver = getWebDriverInner();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    protected abstract WebDriver getWebDriverInner();
}
