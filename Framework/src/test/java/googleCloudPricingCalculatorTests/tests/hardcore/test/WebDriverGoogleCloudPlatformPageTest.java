package googleCloudPricingCalculatorTests.tests.hardcore.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverGoogleCloudPlatformPageTest extends CommonConditions {
    private final By searchPanelLocator = By.xpath("//input[@name='q']");

    @Test
    public void searchInputNotNullTest() {
        WebElement searchInput = driver.findElement(searchPanelLocator);
        Assert.assertNotNull(searchInput);
    }
}
