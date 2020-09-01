package com.hardcore.page;

import com.structure.abstractPageFactory.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenMinutesMailPage extends AbstractPage {
    private final int ONE_MINUTE = 60;
    private final String HOME_PAGE = "https://10minutemail.com";
    private final By searchPlatformPostLocator = By.xpath("//section[@id='mail_messages']" +
            "//span[text()='Google Cloud Platform Price Estimate']");
    private final By searchTotalCostResultLocator = By.xpath("//table//h3[contains(text(), 'USD')]");


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
        waitingForItemToLoad(searchPlatformPostLocator, ONE_MINUTE);
        driver.findElement(searchPlatformPostLocator).click();
    }

    public String getTotalCost() {
        waitingForItemToLoad(searchTotalCostResultLocator, ONE_MINUTE / 10);
        return driver.findElement(searchTotalCostResultLocator).getText().trim();
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