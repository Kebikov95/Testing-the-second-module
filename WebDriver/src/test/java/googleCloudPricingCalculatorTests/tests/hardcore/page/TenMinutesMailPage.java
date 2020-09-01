package googleCloudPricingCalculatorTests.tests.hardcore.page;

import googleCloudPricingCalculatorTests.structure.abstractPageFactory.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenMinutesMailPage extends AbstractPage {
    private final String HOME_PAGE = "https://10minutemail.com";
    private final String SEARCH_PLATFORM_POST = "//section[@id='mail_messages']" +
            "//span[text()='Google Cloud Platform Price Estimate']";
    private final String SEARCH_TOTAL_COST_RESULT = "//table//h3[contains(text(), 'USD')]";
    private final int ONE_MINUTE = 60;

    @FindBy(xpath = "//input[@id='mail_address']")
    private WebElement mailInput;

    public TenMinutesMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getMailAddress() {
        return mailInput.getAttribute("value");
    }

    public void clickToNewPost() {
        waitingForItemToLoad(SEARCH_PLATFORM_POST, ONE_MINUTE);
        driver.findElement(By.xpath(SEARCH_PLATFORM_POST)).click();
    }

    public String getTotalCost() {
        waitingForItemToLoad(SEARCH_TOTAL_COST_RESULT, ONE_MINUTE / 10);
        return driver.findElement(By.xpath(SEARCH_TOTAL_COST_RESULT)).getText().trim();
    }

    public AbstractPage openPage() {
        ((JavascriptExecutor) driver).executeScript(String.format("window.open('%s')", HOME_PAGE));
        driver.get(HOME_PAGE);
        return this;
    }

    public AbstractPage openPageInNewTab() {
        ((JavascriptExecutor) driver).executeScript(String.format("window.open('%s')", HOME_PAGE));
        return this;
    }
}
