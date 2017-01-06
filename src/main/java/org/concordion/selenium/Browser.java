package org.concordion.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Manages the browser session.
 */
public class Browser {

    private static final String proxyHost = "YOUR_PROXY_HERE";
    private static final int proxyPort = 8080;
    private WebDriver driver;

    Browser() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", proxyHost);
        profile.setPreference("network.proxy.http_port", proxyPort);
        profile.setPreference("network.proxy.ssl", proxyHost);
        profile.setPreference("network.proxy.ssl_port", proxyPort);
        driver = new FirefoxDriver(profile);
    }

    void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}