package googleCloudPricingCalculatorTests.tests.hurtMePlenty.test;

import googleCloudPricingCalculatorTests.structure.enums.*;
import googleCloudPricingCalculatorTests.tests.hurtMePlenty.page.GoogleCloudPlatformPageAbstractPO;
import googleCloudPricingCalculatorTests.tests.hurtMePlenty.page.GoogleCloudPlatformPricingCalculatorPageAbstractPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverGoogleCloudPlatformPricingCalculatorPageAbstractPOTest {
    private WebDriver driver;
    private GoogleCloudPlatformPageAbstractPO homePage;
    private GoogleCloudPlatformPricingCalculatorPageAbstractPO resultPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com");
        driver.manage().window().maximize();
        homePage = new GoogleCloudPlatformPageAbstractPO(driver);
    }

    @Test
    public void fillingOutPriceFormTest() {
        resultPage = homePage.openGoogleCloudPlatformPricingCalculator();

        resultPage.clickComputeEngine();
        resultPage.sendNumberToNumberOfInstances(4);
        resultPage.chooseMachineType(MachineTypeEnum.N1_STANDARD_8);
        resultPage.checkAddGpusCheckbox();
        resultPage.chooseNumberOfGpus(NumberOfGpusEnum.ONE);
        resultPage.chooseGpuType(GpuTypeEnum.NVIDIA_TESLA_V100);
        resultPage.chooseLocalSsd(LocalSsdEnum.TWO);
        resultPage.chooseDataCenterLocation(DataCenterLocationEnum.FRANKFURT);
        resultPage.chooseCommitedUsage(CommittedUsageEnum.ONE_YEAR);
        resultPage.clickAddToEstimateButton();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
