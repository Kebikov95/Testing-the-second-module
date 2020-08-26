package googleCloudPricingCalculatorTests.tests.hardcore;

import googleCloudPricingCalculatorTests.tests.hardcore.page.GoogleCloudPlatformPage;
import googleCloudPricingCalculatorTests.tests.hardcore.page.GoogleCloudPlatformPricingCalculatorPage;
import googleCloudPricingCalculatorTests.tests.hardcore.page.TenMinutesMailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    static final String HOME_PAGE = "https://cloud.google.com/products/calculator";
    static final int WAIT_TIMEOUT_SECONDS = 10;
    static WebDriver driver;
    static GoogleCloudPlatformPage homePage;
    static GoogleCloudPlatformPricingCalculatorPage resultPage;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/products/calculator");
        TenMinutesMailPage mailPage = new TenMinutesMailPage(driver);
        mailPage.openPageInNewTab();
        System.out.println(mailPage.getMailAddress());
        driver.quit();
    }
}
