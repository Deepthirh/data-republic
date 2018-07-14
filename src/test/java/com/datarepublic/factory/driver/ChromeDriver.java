package com.datarepublic.factory.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriver extends AbstractDriver {

    public ChromeDriver() {
        setDriverExecutable("webdriver.chrome.driver", "chrome", "chromedriver");
    }

    @Override
    protected WebDriver getWebDriverInner() {
        return new org.openqa.selenium.chrome.ChromeDriver(new ChromeOptions());
    }
}
