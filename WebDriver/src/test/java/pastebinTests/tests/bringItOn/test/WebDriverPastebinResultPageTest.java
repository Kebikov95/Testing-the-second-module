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

    private final String TEXTAREA_EXPECTED_RESULT = "git config --global user.name  'New Sheriff in Town'\n" +
            "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')\n" +
            "git push origin master --force";
    private final String TITLE_EXPECTED_RESULT = "how to gain dominance among developers";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        driver.manage().window().maximize();
        homePage = new PastebinHomePage(driver);
    }

    @Test(description = "Test with params:" +
            "code: " +
                "'git config --global user.name  'New Sheriff in Town'" +
                "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')\n" +
                "git push origin master --force'" +
            "title: 'how to gain dominance among developers'" +
            "Syntax Highlighting: 'Bash'" +
            "paste expiration: '10 Minutes'")
    public void commonSearchTermResultAreEqualWithSyntax() {
        resultPage = homePage.searchForTerms(TEXTAREA_EXPECTED_RESULT, TITLE_EXPECTED_RESULT,
                SyntaxHighlightingHomePageEnum.BASH, PasteExposureHomePageEnum.TEN_MINUTES);

        Assert.assertEquals(resultPage.findTextareaCode(), TEXTAREA_EXPECTED_RESULT);
        Assert.assertEquals(resultPage.findTitle(), TITLE_EXPECTED_RESULT);
        Assert.assertEquals(resultPage.findExposureTime(), PasteExposureResultPageEnum.TEN_MINUTES.getName());
        Assert.assertEquals(resultPage.findSyntaxType(), SyntaxHighlightingResultPageEnum.BASH.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
