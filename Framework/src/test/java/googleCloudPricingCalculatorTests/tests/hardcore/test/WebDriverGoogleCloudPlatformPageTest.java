package googleCloudPricingCalculatorTests.tests.hardcore.test;

import googleCloudPricingCalculatorTests.tests.hardcore.page.GoogleCloudPlatformPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebDriverGoogleCloudPlatformPageTest {
    private WebDriver driver;
    private GoogleCloudPlatformPage page;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com");
        driver.manage().window().maximize();
        page = new GoogleCloudPlatformPage(driver);
    }

    @Test
    public void searchInputNotNullTest() {
        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']"));
        Assert.assertNotNull(searchInput);
    }

    @AfterTest
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
