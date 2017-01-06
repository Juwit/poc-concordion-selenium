package google.pages;

import org.concordion.selenium.Browser;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    @CacheLookup
    @FindBy(name = "q")
    private WebElement queryBox;

    @CacheLookup
    @FindBy(name = "btnG")
    private WebElement submitButton;

    private Browser browser;

    /**
     * Opens the Google Search Page.
     */
    public GoogleSearchPage(Browser browser) {
        this.browser = browser;
        WebDriver driver = browser.getDriver();
        PageFactory.initElements(driver, this);
        driver.get("http://www.google.com");
    }

    /**
     * Searches for the specified string and opens the results page,
     * waiting for the page to fully load.
     */
    public GoogleResultsPage searchFor(String query) {
        queryBox.sendKeys(query);
        queryBox.sendKeys(Keys.ESCAPE);
        submitButton.click();
        return new GoogleResultsPage(browser);
    }

}




