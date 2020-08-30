package googleCloudPricingCalculatorTests.tests.hardcore.page;

import googleCloudPricingCalculatorTests.structure.abstractPageFactory.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleCloudPlatformPage extends AbstractPage {
    private final String HOME_PAGE = "https://cloud.google.com";
    private final String SEARCH_PLATFORM = "Google Cloud Platform Pricing Calculator";
    private final String FIRST_EXPECTED_LINK = "//div[@class='gs-webResult gs-result']//a[@class='gs-title']";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    public GoogleCloudPlatformPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    protected AbstractPage openPage() {
        driver.get(HOME_PAGE);
        waitingForItemToLoad("//input[@name='q']");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage openGoogleCloudPlatformPricingCalculator() {
        searchInput.click();
        searchInput.sendKeys(SEARCH_PLATFORM);
        searchInput.submit();
        waitingForItemToLoad(FIRST_EXPECTED_LINK);
        List<WebElement> findElements = driver.findElements(By.xpath(FIRST_EXPECTED_LINK));
        findElements.get(0).click();
        return new GoogleCloudPlatformPricingCalculatorPage(driver);
    }
}
