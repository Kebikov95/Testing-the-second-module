package pastebinTests.tests.iCanWin.test;

import pastebinTests.structure.enums.homePage.PasteExposureHomePageEnum;
import pastebinTests.structure.enums.resultPage.PasteExposureResultPageEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pastebinTests.tests.iCanWin.page.PastebinHomePage;
import pastebinTests.tests.iCanWin.page.PastebinResultPage;

public class WebDriverPastebinResultPageTest {
    private WebDriver driver;
    private PastebinHomePage homePage;
    private PastebinResultPage resultPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        driver.manage().window().maximize();
        homePage = new PastebinHomePage(driver);
    }

    @Test(description = "Test with params:" +
            "code: 'Hello from WebDriver'" +
            "title: 'helloweb'" +
            "paste expiration: '10 Minutes'")
    public void commonSearchTermResultAreEqualTest() {
        resultPage = homePage.searchForTerms("Hello from WebDriver","helloweb",
                PasteExposureHomePageEnum.TEN_MINUTES);

        Assert.assertEquals(resultPage.findCode().getText(), "Hello from WebDriver");
        Assert.assertEquals(resultPage.findTitle().getText(), "helloweb");
        Assert.assertEquals(resultPage.findExposure().getText(), PasteExposureResultPageEnum.TEN_MINUTES.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
