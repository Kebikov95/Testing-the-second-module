package pastebinTests.tests.bringItOn.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pastebinTests.structure.enums.homePage.PasteExposureHomePageEnum;
import pastebinTests.structure.enums.homePage.SyntaxHighlightingHomePageEnum;
import pastebinTests.tests.bringItOn.page.PastebinHQHomePageAbstractPO;
import pastebinTests.tests.bringItOn.page.PastebinHQResultPageAbstractPO;

public class WebDriverPastebinHQHomePageAbstractPOTest {
    private WebDriver driver;
    private PastebinHQHomePageAbstractPO homePage;
    private PastebinHQResultPageAbstractPO resultPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        driver.manage().window().maximize();
        homePage = new PastebinHQHomePageAbstractPO(driver);
    }

    // Syntax type tests.
    @Test
    public void setSearchSyntaxTypeNone(){
        driver.findElement(By.xpath("//span[@id='select2-postform-format-container']")).click();
        driver.findElement(By.xpath(getSyntaxTypePath(SyntaxHighlightingHomePageEnum.NONE))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-format-container']")).getText();
        Assert.assertEquals(exposureLine, "None");
    }

    @Test
    public void setSearchSyntaxTypeBash(){
        driver.findElement(By.xpath("//span[@id='select2-postform-format-container']")).click();
        driver.findElement(By.xpath(getSyntaxTypePath(SyntaxHighlightingHomePageEnum.BASH))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-format-container']")).getText();
        Assert.assertEquals(exposureLine, "Bash");
    }

    @Test
    public void setSearchSyntaxTypeC(){
        driver.findElement(By.xpath("//span[@id='select2-postform-format-container']")).click();
        driver.findElement(By.xpath(getSyntaxTypePath(SyntaxHighlightingHomePageEnum.C))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-format-container']")).getText();
        Assert.assertEquals(exposureLine, "C");
    }

    @Test
    public void setSearchSyntaxTypeCPlusPlus(){
        driver.findElement(By.xpath("//span[@id='select2-postform-format-container']")).click();
        driver.findElement(By.xpath(getSyntaxTypePath(SyntaxHighlightingHomePageEnum.C_PLUS_PLUS))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-format-container']")).getText();
        Assert.assertEquals(exposureLine, "C++");
    }

    @Test
    public void setSearchSyntaxTypeCSharp(){
        driver.findElement(By.xpath("//span[@id='select2-postform-format-container']")).click();
        driver.findElement(By.xpath(getSyntaxTypePath(SyntaxHighlightingHomePageEnum.C_SHARP))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-format-container']")).getText();
        Assert.assertEquals(exposureLine, "C#");
    }

    @Test
    public void setSearchSyntaxTypeCss(){
        driver.findElement(By.xpath("//span[@id='select2-postform-format-container']")).click();
        driver.findElement(By.xpath(getSyntaxTypePath(SyntaxHighlightingHomePageEnum.CSS))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-format-container']")).getText();
        Assert.assertEquals(exposureLine, "CSS");
    }

    @Test
    public void setSearchSyntaxTypeJava(){
        driver.findElement(By.xpath("//span[@id='select2-postform-format-container']")).click();
        driver.findElement(By.xpath(getSyntaxTypePath(SyntaxHighlightingHomePageEnum.JAVA))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-format-container']")).getText();
        Assert.assertEquals(exposureLine, "Java");
    }

    @Test
    public void setSearchSyntaxTypeJavaScript(){
        driver.findElement(By.xpath("//span[@id='select2-postform-format-container']")).click();
        driver.findElement(By.xpath(getSyntaxTypePath(SyntaxHighlightingHomePageEnum.JAVA_SCRIPT))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-format-container']")).getText();
        Assert.assertEquals(exposureLine, "JavaScript");
    }

    @Test
    public void setSearchSyntaxTypeJson(){
        driver.findElement(By.xpath("//span[@id='select2-postform-format-container']")).click();
        driver.findElement(By.xpath(getSyntaxTypePath(SyntaxHighlightingHomePageEnum.JSON))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-format-container']")).getText();
        Assert.assertEquals(exposureLine, "JSON");
    }

    @Test
    public void setSearchSyntaxTypeLua(){
        driver.findElement(By.xpath("//span[@id='select2-postform-format-container']")).click();
        driver.findElement(By.xpath(getSyntaxTypePath(SyntaxHighlightingHomePageEnum.LUA))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-format-container']")).getText();
        Assert.assertEquals(exposureLine, "Lua");
    }

    // Paste exposure tests.
    @Test
    public void setSearchPasteExposureNever(){
        driver.findElement(By.xpath("//label[text()='Paste Expiration:']/following-sibling::div")).click();
        driver.findElement(By.xpath(getPasteExposurePath(PasteExposureHomePageEnum.NEVER))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-expiration-container']")).getText();
        Assert.assertEquals(exposureLine, "Never");
    }

    @Test
    public void setSearchPasteExposureTenMinutes(){
        driver.findElement(By.xpath("//label[text()='Paste Expiration:']/following-sibling::div")).click();
        driver.findElement(By.xpath(getPasteExposurePath(PasteExposureHomePageEnum.TEN_MINUTES))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-expiration-container']")).getText();
        Assert.assertEquals(exposureLine, "10 Minutes");
    }

    @Test
    public void setSearchPasteExposureOneHour(){
        driver.findElement(By.xpath("//label[text()='Paste Expiration:']/following-sibling::div")).click();
        driver.findElement(By.xpath(getPasteExposurePath(PasteExposureHomePageEnum.ONE_HOUR))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-expiration-container']")).getText();
        Assert.assertEquals(exposureLine, "1 Hour");
    }

    @Test
    public void setSearchPasteExposureOneDay(){
        driver.findElement(By.xpath("//label[text()='Paste Expiration:']/following-sibling::div")).click();
        driver.findElement(By.xpath(getPasteExposurePath(PasteExposureHomePageEnum.ONE_DAY))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-expiration-container']")).getText();
        Assert.assertEquals(exposureLine, "1 Day");
    }

    @Test
    public void setSearchPasteExposureOneWeek(){
        driver.findElement(By.xpath("//label[text()='Paste Expiration:']/following-sibling::div")).click();
        driver.findElement(By.xpath(getPasteExposurePath(PasteExposureHomePageEnum.ONE_WEEK))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-expiration-container']")).getText();
        Assert.assertEquals(exposureLine, "1 Week");
    }

    @Test
    public void setSearchPasteExposureTwoWeeks(){
        driver.findElement(By.xpath("//label[text()='Paste Expiration:']/following-sibling::div")).click();
        driver.findElement(By.xpath(getPasteExposurePath(PasteExposureHomePageEnum.TWO_WEEKS))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-expiration-container']")).getText();
        Assert.assertEquals(exposureLine, "2 Weeks");
    }

    @Test
    public void setSearchPasteExposureOneMonth(){
        driver.findElement(By.xpath("//label[text()='Paste Expiration:']/following-sibling::div")).click();
        driver.findElement(By.xpath(getPasteExposurePath(PasteExposureHomePageEnum.ONE_MONTH))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-expiration-container']")).getText();
        Assert.assertEquals(exposureLine, "1 Month");
    }

    @Test
    public void setSearchPasteExposureSixMonths(){
        driver.findElement(By.xpath("//label[text()='Paste Expiration:']/following-sibling::div")).click();
        driver.findElement(By.xpath(getPasteExposurePath(PasteExposureHomePageEnum.SIX_MONTHS))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-expiration-container']")).getText();
        Assert.assertEquals(exposureLine, "6 Months");
    }

    @Test
    public void setSearchPasteExposureOneYear(){
        driver.findElement(By.xpath("//label[text()='Paste Expiration:']/following-sibling::div")).click();
        driver.findElement(By.xpath(getPasteExposurePath(PasteExposureHomePageEnum.ONE_YEAR))).click();
        String exposureLine = driver.findElement(
                By.xpath("//span[@id='select2-postform-expiration-container']")).getText();
        Assert.assertEquals(exposureLine, "1 Year");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    public String getPasteExposurePath(PasteExposureHomePageEnum exposure) {
        return String.format("//span[@class='select2-results']//li[text()='%s']", exposure.getName());
    }

    public String getSyntaxTypePath(SyntaxHighlightingHomePageEnum syntaxType) {
        return String.format("//span[@class='select2-results']//li[text()='%s']", syntaxType.getName());
    }
}
