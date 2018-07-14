package com.datarepublic.factory.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriver extends AbstractDriver {

    private final DesiredCapabilities capabilities;

    public FirefoxDriver() {
        capabilities = DesiredCapabilities.firefox();
    }

    @Override
    public Capabilities getCapabilities() {
        return capabilities;
    }

    @Override
    protected WebDriver getWebDriverInner() {
        return new org.openqa.selenium.firefox.FirefoxDriver();
    }
}
