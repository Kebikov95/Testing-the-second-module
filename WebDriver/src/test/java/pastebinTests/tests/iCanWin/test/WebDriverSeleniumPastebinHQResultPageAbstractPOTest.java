package pastebinTests.tests.iCanWin.test;

import pastebinTests.tests.iCanWin.page.SeleniumPastebinHQHomePageAbstractPO;
import pastebinTests.tests.iCanWin.page.SeleniumPastebinHQResultPageAbstractPO;
import pastebinTests.structure.enums.homePage.PasteExposureHomePageEnum;
import pastebinTests.structure.enums.resultPage.PasteExposureResultPageEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSeleniumPastebinHQResultPageAbstractPOTest {
    private WebDriver driver;
    private SeleniumPastebinHQHomePageAbstractPO homePage;
    private SeleniumPastebinHQResultPageAbstractPO resultPage;
    private WebElement searchCode;
    private WebElement searchTitle;
    private WebElement searchPasteExposure;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        driver.manage().window().maximize();
        homePage = new SeleniumPastebinHQHomePageAbstractPO(driver);
    }

    @Test(description = "Test with params:" +
            "code: 'Hello from WebDriver'" +
            "title: 'helloweb'" +
            "paste expiration: '10 Minutes'")
    public void commonSearchTermResultAreEqual() {
        resultPage = homePage.searchForTerms("Hello from WebDriver","helloweb",
                PasteExposureHomePageEnum.TEN_MINUTES);
        searchCode = resultPage.findTextareaCode();
        searchTitle = resultPage.findTitle();
        searchPasteExposure = resultPage.findExposureTime();

        Assert.assertEquals(searchCode.getText(), "Hello from WebDriver");
        Assert.assertEquals(searchTitle.getText(), "helloweb");
        Assert.assertEquals(searchPasteExposure.getText(), PasteExposureResultPageEnum.TEN_MINUTES.getName());
        System.out.println(searchCode.getText());
        System.out.println(searchTitle.getText());
        System.out.println(searchPasteExposure.getText());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
