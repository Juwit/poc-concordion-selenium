package google;

import google.pages.GoogleResultsPage;
import google.pages.GoogleSearchPage;
import org.concordion.api.extension.ConcordionExtension;
import org.concordion.api.extension.Extension;
import org.concordion.ext.ScreenshotExtension;
import org.concordion.selenium.BrowserFixture;
import org.concordion.selenium.SeleniumScreenshotTaker;

public class GoogleTestFixture extends BrowserFixture {

    private GoogleResultsPage resultsPage;

    /**
     * Searches for the specified topic, and waits for the results page to load.
     */
    public void searchFor(String topic) {
        GoogleSearchPage searchPage = new GoogleSearchPage(browser);
        resultsPage = searchPage.searchFor(topic);
    }

    /**
     * Returns the result from Google calculation.
     */
    public String getCalculatorResult() {
        return resultsPage.getCalculatorResult();
    }
}

