package org.concordion.selenium;

import org.concordion.api.extension.Extension;
import org.concordion.ext.ScreenshotExtension;
import org.junit.After;

public class BrowserFixture extends AbstractFixture{

    protected Browser browser;

    @Extension
    private ScreenshotExtension extension = new ScreenshotExtension();

    public BrowserFixture() {
        browser = new Browser();
        extension.setScreenshotTaker(new SeleniumScreenshotTaker(browser));
        extension.setScreenshotOnAssertionSuccess(true);
        extension.setScreenshotOnAssertionFailure(true);
    }

    @After
    public void close() {
        browser.close();
    }

}
