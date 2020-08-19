package pastebinTests.tests.bringItOn.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pastebinTests.structure.enums.homePage.PasteExposureHomePageEnum;
import pastebinTests.structure.enums.homePage.SyntaxHighlightingHomePageEnum;
import pastebinTests.structure.enums.resultPage.PasteExposureResultPageEnum;
import pastebinTests.structure.enums.resultPage.SyntaxHighlightingResultPageEnum;
import pastebinTests.tests.bringItOn.page.PastebinHomePage;
import pastebinTests.tests.bringItOn.page.PastebinResultPage;

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
    public void commonSearchTermResultAreEqualWithoutSyntax() {
        resultPage = homePage.searchForTerms("Hello from WebDriver","helloweb",
                PasteExposureHomePageEnum.TEN_MINUTES);

        Assert.assertEquals(resultPage.findTextareaCode().getText(), "Hello from WebDriver");
        Assert.assertEquals(resultPage.findTitle().getText(), "helloweb");
        Assert.assertEquals(resultPage.findExposureTime().getText(), PasteExposureResultPageEnum.TEN_MINUTES.getName());
    }

    @Test(description = "Test with params:" +
            "code: " +
                "'git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force'" +
            "title: 'how to gain dominance among developers'" +
            "Syntax Highlighting: 'Bash'" +
            "paste expiration: '10 Minutes'")
    public void commonSearchTermResultAreEqualWithSyntax() {
        resultPage = homePage.searchForTerms(
                "git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force",
                "how to gain dominance among developers",
                SyntaxHighlightingHomePageEnum.BASH,
                PasteExposureHomePageEnum.TEN_MINUTES);

        Assert.assertEquals(resultPage.findTextareaCode().getText(),
                "git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force");
        Assert.assertEquals(resultPage.findTitle().getText(), "how to gain dominance among developers");
        Assert.assertEquals(resultPage.findExposureTime().getText(), PasteExposureResultPageEnum.TEN_MINUTES.getName());
        Assert.assertEquals(resultPage.findSyntaxType().getText(), SyntaxHighlightingResultPageEnum.BASH.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
