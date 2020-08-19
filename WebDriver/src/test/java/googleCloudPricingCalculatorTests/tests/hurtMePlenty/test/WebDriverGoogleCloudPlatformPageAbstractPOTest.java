package googleCloudPricingCalculatorTests.tests.hurtMePlenty.test;

import googleCloudPricingCalculatorTests.tests.hurtMePlenty.page.GoogleCloudPlatformPageAbstractPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebDriverGoogleCloudPlatformPageAbstractPOTest {
    private WebDriver driver;
    private GoogleCloudPlatformPageAbstractPO page;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com");
        driver.manage().window().maximize();
        page = new GoogleCloudPlatformPageAbstractPO(driver);
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
