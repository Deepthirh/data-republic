package com.datarepublic.factory.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriver extends AbstractDriver {

    private final DesiredCapabilities capabilities;

    public ChromeDriver() {
        capabilities = DesiredCapabilities.chrome();
    }

    @Override
    public Capabilities getCapabilities() {
        return capabilities;
    }

    @Override
    protected WebDriver getWebDriverInner() {
        return new org.openqa.selenium.chrome.ChromeDriver();
    }
}
