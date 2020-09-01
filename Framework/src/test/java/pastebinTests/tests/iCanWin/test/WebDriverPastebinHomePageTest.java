package pastebinTests.tests.iCanWin.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pastebinTests.structure.enums.homePage.PasteExposureHomePageEnum;
import pastebinTests.tests.iCanWin.page.PastebinHomePage;
import pastebinTests.tests.iCanWin.page.PastebinResultPage;

public class WebDriverPastebinHomePageTest {
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

    @Test
    public void setSearchPasteExposureNeverTest(){
        driver.findElement(By.xpath(homePage.getPasteExpirationLabel())).click();
        driver.findElement(By.xpath(homePage.getPasteExposurePath(PasteExposureHomePageEnum.NEVER))).click();
        String exposureLine = driver.findElement(By.xpath(homePage.getPostformExpirationContainer())).getText();
        Assert.assertEquals(exposureLine, "Never");
    }

    @Test
    public void setSearchPasteExposureTenMinutesTest(){
        driver.findElement(By.xpath(homePage.getPasteExpirationLabel())).click();
        driver.findElement(By.xpath(homePage.getPasteExposurePath(PasteExposureHomePageEnum.TEN_MINUTES))).click();
        String exposureLine = driver.findElement(By.xpath(homePage.getPostformExpirationContainer())).getText();
        Assert.assertEquals(exposureLine, "10 Minutes");
    }

    @Test
    public void setSearchPasteExposureOneHourTest(){
        driver.findElement(By.xpath(homePage.getPasteExpirationLabel())).click();
        driver.findElement(By.xpath(homePage.getPasteExposurePath(PasteExposureHomePageEnum.ONE_HOUR))).click();
        String exposureLine = driver.findElement(By.xpath(homePage.getPostformExpirationContainer())).getText();
        Assert.assertEquals(exposureLine, "1 Hour");
    }

    @Test
    public void setSearchPasteExposureOneDayTest(){
        driver.findElement(By.xpath(homePage.getPasteExpirationLabel())).click();
        driver.findElement(By.xpath(homePage.getPasteExposurePath(PasteExposureHomePageEnum.ONE_DAY))).click();
        String exposureLine = driver.findElement(By.xpath(homePage.getPostformExpirationContainer())).getText();
        Assert.assertEquals(exposureLine, "1 Day");
    }

    @Test
    public void setSearchPasteExposureOneWeekTest(){
        driver.findElement(By.xpath(homePage.getPasteExpirationLabel())).click();
        driver.findElement(By.xpath(homePage.getPasteExposurePath(PasteExposureHomePageEnum.ONE_WEEK))).click();
        String exposureLine = driver.findElement(By.xpath(homePage.getPostformExpirationContainer())).getText();
        Assert.assertEquals(exposureLine, "1 Week");
    }

    @Test
    public void setSearchPasteExposureTwoWeeksTest(){
        driver.findElement(By.xpath(homePage.getPasteExpirationLabel())).click();
        driver.findElement(By.xpath(homePage.getPasteExposurePath(PasteExposureHomePageEnum.TWO_WEEKS))).click();
        String exposureLine = driver.findElement(By.xpath(homePage.getPostformExpirationContainer())).getText();
        Assert.assertEquals(exposureLine, "2 Weeks");
    }

    @Test
    public void setSearchPasteExposureOneMonthTest(){
        driver.findElement(By.xpath(homePage.getPasteExpirationLabel())).click();
        driver.findElement(By.xpath(homePage.getPasteExposurePath(PasteExposureHomePageEnum.ONE_MONTH))).click();
        String exposureLine = driver.findElement(By.xpath(homePage.getPostformExpirationContainer())).getText();
        Assert.assertEquals(exposureLine, "1 Month");
    }

    @Test
    public void setSearchPasteExposureSixMonthsTest(){
        driver.findElement(By.xpath(homePage.getPasteExpirationLabel())).click();
        driver.findElement(By.xpath(homePage.getPasteExposurePath(PasteExposureHomePageEnum.SIX_MONTHS))).click();
        String exposureLine = driver.findElement(By.xpath(homePage.getPostformExpirationContainer())).getText();
        Assert.assertEquals(exposureLine, "6 Months");
    }

    @Test
    public void setSearchPasteExposureOneYearTest(){
        driver.findElement(By.xpath(homePage.getPasteExpirationLabel())).click();
        driver.findElement(By.xpath(homePage.getPasteExposurePath(PasteExposureHomePageEnum.ONE_YEAR))).click();
        String exposureLine = driver.findElement(By.xpath(homePage.getPostformExpirationContainer())).getText();
        Assert.assertEquals(exposureLine, "1 Year");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
