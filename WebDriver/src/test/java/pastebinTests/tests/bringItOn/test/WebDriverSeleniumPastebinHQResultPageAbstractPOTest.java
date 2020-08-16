package pastebinTests.tests.bringItOn.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pastebinTests.structure.enums.homePage.PasteExposureHomePageEnum;
import pastebinTests.structure.enums.homePage.SyntaxHighlightingHomePageEnum;
import pastebinTests.structure.enums.resultPage.PasteExposureResultPageEnum;
import pastebinTests.structure.enums.resultPage.SyntaxHighlightingResultPageEnum;
import pastebinTests.tests.bringItOn.page.SeleniumPastebinHQHomePageAbstractPO;
import pastebinTests.tests.bringItOn.page.SeleniumPastebinHQResultPageAbstractPO;

public class WebDriverSeleniumPastebinHQResultPageAbstractPOTest {
    private WebDriver driver;
    private SeleniumPastebinHQHomePageAbstractPO homePage;
    private SeleniumPastebinHQResultPageAbstractPO resultPage;
    private WebElement searchCode;
    private WebElement searchTitle;
    private WebElement searchSyntax;
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
    public void commonSearchTermResultAreEqualWithoutSyntax() {
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
        searchCode = resultPage.findTextareaCode();
        searchTitle = resultPage.findTitle();
        searchSyntax = resultPage.findSyntaxType();
        searchPasteExposure = resultPage.findExposureTime();

        Assert.assertEquals(searchCode.getText(),
                "git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force");
        Assert.assertEquals(searchTitle.getText(), "how to gain dominance among developers");
        Assert.assertEquals(searchPasteExposure.getText(), PasteExposureResultPageEnum.TEN_MINUTES.getName());
        Assert.assertEquals(searchSyntax.getText(), SyntaxHighlightingResultPageEnum.BASH.getName());
        System.out.println(searchCode.getText());
        System.out.println(searchTitle.getText());
        System.out.println(searchPasteExposure.getText());
        System.out.println(searchSyntax.getText());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
