package com.datarepublic.factory.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public interface Driver {
    Capabilities getCapabilities();
    WebDriver getWebDriver();
}
