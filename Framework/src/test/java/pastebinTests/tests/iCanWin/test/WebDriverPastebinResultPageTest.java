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

    private final String CODE_EXPECTED_RESULT = "Hello from WebDriver";
    private final String TITLE_EXPECTED_RESULT = "helloweb";

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
        resultPage = homePage.searchForTerms(CODE_EXPECTED_RESULT,TITLE_EXPECTED_RESULT,
                PasteExposureHomePageEnum.TEN_MINUTES);

        Assert.assertEquals(resultPage.findCode(), CODE_EXPECTED_RESULT);
        Assert.assertEquals(resultPage.findTitle(), TITLE_EXPECTED_RESULT);
        Assert.assertEquals(resultPage.findExposure(), PasteExposureResultPageEnum.TEN_MINUTES.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
