package googleCloudPricingCalculatorTests.tests.hardcore.test;

import googleCloudPricingCalculatorTests.tests.hardcore.page.GoogleCloudPlatformPage;
import googleCloudPricingCalculatorTests.tests.hardcore.page.GoogleCloudPlatformPricingCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

public class CommonConditions {
    protected WebDriver driver;
    protected GoogleCloudPlatformPage homePage;
    protected GoogleCloudPlatformPricingCalculatorPage resultPage;
    protected ArrayList<String> tabs;

    @BeforeMethod()
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com");
        driver.manage().window().maximize();
        homePage = new GoogleCloudPlatformPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
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
