package com.datarepublic.factory.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriver extends AbstractDriver {

    private final DesiredCapabilities capabilities;

    public FirefoxDriver() {
        setDriverExecutable("webdriver.gecko.driver", "firefox", "geckodriver");
        capabilities = DesiredCapabilities.firefox();
    }

    @Override
    protected WebDriver getWebDriverInner() {
        return new org.openqa.selenium.firefox.FirefoxDriver(new FirefoxOptions());
    }
}
