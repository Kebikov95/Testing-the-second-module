package com.hardcore.test;

import com.hardcore.driver.DriverSingleton;
import com.hardcore.page.GoogleCloudPlatformPage;
import com.hardcore.page.GoogleCloudPlatformPricingCalculatorPage;
import com.hardcore.util.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    private final Logger logger = LogManager.getRootLogger();
    protected GoogleCloudPlatformPage homePage;
    protected GoogleCloudPlatformPricingCalculatorPage resultPage;
    protected WebDriver driver;

    @BeforeMethod()
    public void browserSetup() {
        logger.info("System value 'surefire.suiteXmlFiles': [" + System.getProperty("surefire.suiteXmlFiles") + "]");
        logger.info("System value 'environment': [" + System.getProperty("environment") + "]");
        logger.info(" System value 'browser': [" + System.getProperty("browser") + "]");
        System.setProperty("browser", "chrome");
        System.setProperty("environment", "staging");
        driver = DriverSingleton.getDriver();
        homePage = new GoogleCloudPlatformPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
