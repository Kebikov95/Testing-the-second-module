package pastebinTests.tests.iCanWin.test;

import pastebinTests.tests.bringItOn.page.PastebinHQHomePageAbstractPO;
import pastebinTests.tests.bringItOn.page.PastebinHQResultPageAbstractPO;
import pastebinTests.structure.enums.homePage.PasteExposureHomePageEnum;
import pastebinTests.structure.enums.resultPage.PasteExposureResultPageEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverPastebinHQResultPageAbstractPOTest {
    private WebDriver driver;
    private PastebinHQHomePageAbstractPO homePage;
    private PastebinHQResultPageAbstractPO resultPage;
    private WebElement searchCode;
    private WebElement searchTitle;
    private WebElement searchPasteExposure;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        driver.manage().window().maximize();
        homePage = new PastebinHQHomePageAbstractPO(driver);
    }

    @Test(description = "Test with params:" +
            "code: 'Hello from WebDriver'" +
            "title: 'helloweb'" +
            "paste expiration: '10 Minutes'")
    public void commonSearchTermResultAreEqualTest() {
        resultPage = homePage.searchForTerms("Hello from WebDriver","helloweb",
                PasteExposureHomePageEnum.TEN_MINUTES);
        searchCode = resultPage.findTextareaCode();
        searchTitle = resultPage.findTitle();
        searchPasteExposure = resultPage.findExposureTime();

        Assert.assertEquals(searchCode.getText(), "Hello from WebDriver");
        Assert.assertEquals(searchTitle.getText(), "helloweb");
        Assert.assertEquals(searchPasteExposure.getText(), PasteExposureResultPageEnum.TEN_MINUTES.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
