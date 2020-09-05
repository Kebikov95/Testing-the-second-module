package com.hardcore.page;

import com.structure.abstractPageFactory.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GoogleCloudPlatformPage extends AbstractPage {
    private final String HOME_PAGE = "https://cloud.google.com";
    private final String SEARCH_PLATFORM = "Google Cloud Platform Pricing Calculator";
    private final Logger logger = LogManager.getRootLogger();

    private final By searchPanelLocator = By.xpath("//input[@name='q']");
    private final By firstExpectedLinkLocator = By.xpath("//div[@class='gs-webResult gs-result']//a[@class='gs-title']");

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    public GoogleCloudPlatformPage(WebDriver driver) {
        super(driver);
        driver.get("https://cloud.google.com");
        PageFactory.initElements(driver, this);
    }

    protected AbstractPage openPage() {
        driver.get(HOME_PAGE);
        waitingForItemToLoad(searchPanelLocator);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage openGoogleCloudPlatformPricingCalculator() {
        searchInput.click();
        logger.info("Search in GoogleCloudPlatform: [" + SEARCH_PLATFORM + "]");
        searchInput.sendKeys(SEARCH_PLATFORM);
        searchInput.submit();
        waitingForItemToLoad(firstExpectedLinkLocator);
        List<WebElement> findElements = driver.findElements(firstExpectedLinkLocator);
        findElements.get(0).click();
        return new GoogleCloudPlatformPricingCalculatorPage(driver);
    }
}
