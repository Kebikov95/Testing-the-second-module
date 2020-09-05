package com.hardcore.test;

import com.hardcore.driver.DriverSingleton;
import com.hardcore.page.GoogleCloudPlatformPage;
import com.hardcore.page.GoogleCloudPlatformPricingCalculatorPage;
import com.hardcore.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected GoogleCloudPlatformPage homePage;
    protected GoogleCloudPlatformPricingCalculatorPage resultPage;
    protected WebDriver driver;

    @BeforeMethod()
    public void browserSetup() {
//        System.setProperty("browser", "chrome");
//        System.setProperty("environment", "qa");
        driver = DriverSingleton.getDriver();
        homePage = new GoogleCloudPlatformPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
