package googleCloudPricingCalculatorTests.tests.hardcore.test;

import googleCloudPricingCalculatorTests.structure.enums.*;
import googleCloudPricingCalculatorTests.tests.hardcore.page.GoogleCloudPlatformPage;
import googleCloudPricingCalculatorTests.tests.hardcore.page.GoogleCloudPlatformPricingCalculatorPage;
import googleCloudPricingCalculatorTests.tests.hardcore.page.TenMinutesMailPage;
import googleCloudPricingCalculatorTests.tests.hardcore.page.TenMinutesMailWithTotalCostPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class WebDriverGoogleCloudPlatformPricingCalculatorPageTest {
    private WebDriver driver;
    private GoogleCloudPlatformPage homePage;
    private GoogleCloudPlatformPricingCalculatorPage resultPage;
    private ArrayList<String> tabs;
    private final int WAIT_TIMEOUT_SECONDS = 10;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com");
        driver.manage().window().maximize();
        homePage = new GoogleCloudPlatformPage(driver);
    }

    @Test
    public void fillingOutPriceFormTest() {
        resultPage = homePage.openGoogleCloudPlatformPricingCalculator();

        resultPage.computeEngineButtonClick();
        resultPage.numberOfInstancesInputSendKeys(4);
        resultPage.machineTypeClick();
        machineTypeOptionClick(MachineTypeEnum.N1_STANDARD_8);
        resultPage.addGpusCheckboxClick();
        resultPage.numbersOfGpusClick();
        numbersOfGpusOptionClick(NumberOfGpusEnum.ONE);
        resultPage.gpuTypeClick();
        gpuTypeOptionClick(GpuTypeEnum.NVIDIA_TESLA_V100);
        resultPage.localSddClick();
        localSddOptionClick(LocalSsdEnum.TWO);
        resultPage.dataCenterLocationClick();
        dataCenterLocationOptionClick(DataCenterLocationEnum.FRANKFURT);
        resultPage.committedUsageClick();
        committedUsageOptionClick(CommittedUsageEnum.ONE_YEAR);
        resultPage.addToEstimateClick();

        Assert.assertEquals(resultPage
                .findNumberOfInstanceResult()
                .getText().trim(), "4 x");
        Assert.assertEquals(resultPage
                .findMachineClassResult()
                .getText().trim(), "VM class: regular");
        Assert.assertEquals(resultPage
                .findInstanceTypeResult()
                .getText().trim(), "Instance type: n1-standard-8");
        Assert.assertEquals(resultPage
                .findDataCenterLocationResult()
                .getText().trim(), "Region: Frankfurt");
        Assert.assertEquals(resultPage
                .findLocalSsdResult()
                .getText().trim(), "Total available local SSD space 2x375 GiB");
        Assert.assertEquals(resultPage
                .findCommittedUsageResult()
                .getText().trim(), "Commitment term: 1 Year");
        Assert.assertEquals(resultPage
                .findEstimatedComponentCostResult()
                .getText().trim(),"Estimated Component Cost: USD 1,082.77 per 1 month");

        TenMinutesMailPage mailPage = new TenMinutesMailPage(driver);
        mailPage.openPageInNewTab();
        getNextWebPage();
        String email = mailPage.getMailAddress();
        getPreviousWebPage();
        resultPage.sendEmailWithComponentCost(email);
        getNextWebPage();
        TenMinutesMailWithTotalCostPage mailPageWithPriceCost = mailPage.openTenMinutesMailWithTotalCostPage();

        Assert.assertEquals(mailPageWithPriceCost.getEstimatedMonthlyCostElement()
                .getText().trim(), "USD 1,082.77");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    public void getPreviousWebPage() {
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void getNextWebPage() {
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void machineTypeOptionClick(MachineTypeEnum type) {
        optionClick(String.format(resultPage.MACHINE_TYPE_OPTION_PATH, type.getName()));
    }

    public void numbersOfGpusOptionClick(NumberOfGpusEnum type) {
        optionClick(String.format(resultPage.NUMBERS_OF_GPUS_OPTION_PATH, type.getName()));
    }

    public void gpuTypeOptionClick(GpuTypeEnum type) {
        optionClick(String.format(resultPage.GPU_TYPE_OPTION_PATH, type.getName()));
    }

    public void localSddOptionClick(LocalSsdEnum type) {
        optionClick(String.format(resultPage.LOCAL_SDD_OPTION_PATH, type.getName()));
    }

    public void dataCenterLocationOptionClick(DataCenterLocationEnum type) {
        optionClick(String.format(resultPage.DATA_CENTER_LOCATION_OPTION_PATH, type.getName()));
    }

    public void committedUsageOptionClick(CommittedUsageEnum type) {
        optionClick(String.format(resultPage.COMMITTED_USAGE_OPTION_PATH, type.getName()));
    }

    public void optionClick(String path) {
        waitingForItemToLoad(path);
        driver.findElement(By.xpath(path)).click();
    }

    public void waitingForItemToLoad(String path) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
    }
}
