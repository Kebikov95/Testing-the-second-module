package com.hardcore.test;

import com.hardcore.driver.DriverSingleton;
import com.hardcore.page.GoogleCloudPlatformPage;
import com.hardcore.page.GoogleCloudPlatformPricingCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

public class CommonConditions {
    protected GoogleCloudPlatformPage homePage;
    protected GoogleCloudPlatformPricingCalculatorPage resultPage;
    protected ArrayList<String> tabs;
    protected WebDriver driver;

    @BeforeMethod()
    public void browserSetup() {
        System.setProperty("browser", "chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://cloud.google.com");
        homePage = new GoogleCloudPlatformPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }

    public void getPreviousWebPage() {
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void getNextWebPage() {
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}