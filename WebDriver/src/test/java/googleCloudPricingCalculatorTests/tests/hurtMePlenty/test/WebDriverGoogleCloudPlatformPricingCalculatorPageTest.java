package googleCloudPricingCalculatorTests.tests.hurtMePlenty.test;

import googleCloudPricingCalculatorTests.structure.enums.*;
import googleCloudPricingCalculatorTests.tests.hurtMePlenty.page.GoogleCloudPlatformPage;
import googleCloudPricingCalculatorTests.tests.hurtMePlenty.page.GoogleCloudPlatformPricingCalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverGoogleCloudPlatformPricingCalculatorPageTest {
    private WebDriver driver;
    private GoogleCloudPlatformPage homePage;
    private GoogleCloudPlatformPricingCalculatorPage resultPage;

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
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
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
        resultPage.waitingForItemToLoad(path);
        driver.findElement(By.xpath(path)).click();
    }
}
