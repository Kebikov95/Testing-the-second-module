package googleCloudPricingCalculatorTests.tests.hurtMePlenty.test;

import googleCloudPricingCalculatorTests.structure.enums.*;
import googleCloudPricingCalculatorTests.tests.hurtMePlenty.page.GoogleCloudPlatformPage;
import googleCloudPricingCalculatorTests.tests.hurtMePlenty.page.GoogleCloudPlatformPricingCalculatorPage;
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

    private String NUMBER_OF_INSTANCE_EXPECTED_RESULT = "4 x";
    private String MACHINE_CLASS_EXPECTED_RESULT = "VM class: regular";
    private String INSTANCE_TYPE_EXPECTED_RESULT = "Instance type: n1-standard-8";
    private String DATA_CENTER_LOCATION_EXPECTED_RESULT = "Region: Frankfurt";
    private String LOCAL_SSD_EXPECTED_RESULT = "Total available local SSD space 2x375 GiB";
    private String COMMITTED_USAGE_EXPECTED_RESULT = "Commitment term: 1 Year";
    private String ESTIMATED_COMPONENT_COST_EXPECTED_RESULT = "Estimated Component Cost: USD 1,082.77 per 1 month";

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
        resultPage.machineTypeOptionClick(MachineTypeEnum.N1_STANDARD_8);
        resultPage.addGpusCheckboxClick();
        resultPage.numbersOfGpusClick();
        resultPage.numbersOfGpusOptionClick(NumberOfGpusEnum.ONE);
        resultPage.gpuTypeClick();
        resultPage.gpuTypeOptionClick(GpuTypeEnum.NVIDIA_TESLA_V100);
        resultPage.localSddClick();
        resultPage.localSddOptionClick(LocalSsdEnum.TWO);
        resultPage.dataCenterLocationClick();
        resultPage.dataCenterLocationOptionClick(DataCenterLocationEnum.FRANKFURT);
        resultPage.committedUsageClick();
        resultPage.committedUsageOptionClick(CommittedUsageEnum.ONE_YEAR);
        resultPage.addToEstimateClick();

        Assert.assertEquals(resultPage.findNumberOfInstanceResult(), NUMBER_OF_INSTANCE_EXPECTED_RESULT);
        Assert.assertEquals(resultPage.findMachineClassResult(), MACHINE_CLASS_EXPECTED_RESULT);
        Assert.assertEquals(resultPage.findInstanceTypeResult(), INSTANCE_TYPE_EXPECTED_RESULT);
        Assert.assertEquals(resultPage.findDataCenterLocationResult(), DATA_CENTER_LOCATION_EXPECTED_RESULT);
        Assert.assertEquals(resultPage.findLocalSsdResult(), LOCAL_SSD_EXPECTED_RESULT);
        Assert.assertEquals(resultPage.findCommittedUsageResult(), COMMITTED_USAGE_EXPECTED_RESULT);
        Assert.assertEquals(resultPage.findEstimatedComponentCostResult(), ESTIMATED_COMPONENT_COST_EXPECTED_RESULT);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
