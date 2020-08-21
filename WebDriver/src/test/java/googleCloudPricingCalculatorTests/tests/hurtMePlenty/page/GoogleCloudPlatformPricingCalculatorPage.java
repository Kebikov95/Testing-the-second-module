package googleCloudPricingCalculatorTests.tests.hurtMePlenty.page;

import googleCloudPricingCalculatorTests.structure.abstractPageFactory.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPlatformPricingCalculatorPage extends AbstractPage {
    private WebDriver driver;
    private WebDriverWait waiter;
    private final String HOME_PAGE = "https://cloud.google.com/products/calculator";

    public final static String MACHINE_TYPE_OPTION_PATH = "//md-option[@id='select_option_228']/div[contains(text(), '%s')]";
    public final static String NUMBERS_OF_GPUS_OPTION_PATH = "//md-option[@id='select_option_357']/div[contains(text(), '%s')]";
    public final static String GPU_TYPE_OPTION_PATH = "//md-option[@id='select_option_364']/div[contains(text(), '%s')]";
    public final static String LOCAL_SDD_OPTION_PATH = "//md-option[@id='select_option_249']/div[contains(text(), '%s')]";
    public final static String DATA_CENTER_LOCATION_OPTION_PATH = "//md-option[@id='select_option_196']/div[contains(text(), '%s')]";
    public final static String COMMITTED_USAGE_OPTION_PATH = "//md-option[@id='select_option_93']/div[contains(text(), '%s')]";

    @FindBy(xpath = "(//div[text()='Compute Engine'])[1]")
    private WebElement computeEngineButton;
    @FindBy(xpath = "//input[@id='input_61']")
    private WebElement numberOfInstancesInput;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_58']")
    private WebElement machineTypeSelect;
    @FindBy(xpath = "//md-checkbox[@class='ng-pristine ng-untouched ng-valid ng-empty']")
    private WebElement addGpusCheckbox;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_350']")
    private WebElement numbersOfGpusSelect;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_351']")
    private WebElement gpuTypeSelect;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_184']")
    private WebElement localSddSelect;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_59']")
    private WebElement dataCenterLocationSelect;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_60']")
    private WebElement committedUsageSelect;
    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']//span[@class='ng-binding ng-scope']")
    private WebElement numberOfInstanceResult;
    @FindBy(xpath = "(//md-list[@class='cartitem ng-scope']//div[@class='md-list-item-text ng-binding'])[2]")
    private WebElement machineClassResult;
    @FindBy(xpath = "(//md-list[@class='cartitem ng-scope']//div[@class='md-list-item-text ng-binding'])[3]")
    private WebElement instanceTypeResult;
    @FindBy(xpath = "(//md-list[@class='cartitem ng-scope']//div[@class='md-list-item-text ng-binding'])[4]")
    private WebElement dataCenterLocationResult;
    @FindBy(xpath = "(//md-list[@class='cartitem ng-scope']//div[@class='md-list-item-text ng-binding'])[5]")
    private WebElement localSsdResult;
    @FindBy(xpath = "(//md-list[@class='cartitem ng-scope']//div[@class='md-list-item-text ng-binding'])[6]")
    private WebElement committedUsageResult;
    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']//div[@class='md-list-item-text']")
    private WebElement estimatedComponentCostResult;

    protected GoogleCloudPlatformPricingCalculatorPage(WebDriver driver) {
        super(driver);
        waiter = new WebDriverWait(driver, 10);
        waiter.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='/products/" +
                "calculator/index_ad8ca20a6d1799e286a0c0839aeb86ca523afe927b04501d8ba77dc59e5b8523.frame']")));
        waiter.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='myFrame']")));
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        PageFactory.initElements(driver, this);
    }

//    private WebDriverWait frameWaiterToBeAvailable() {
//        waiter = new WebDriverWait(driver, 10);
//        waiter.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='/products/" +
//                "calculator/index_ad8ca20a6d1799e286a0c0839aeb86ca523afe927b04501d8ba77dc59e5b8523.frame']")));
//        waiter.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='myFrame']")));
//        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
//        return waiter;
//    }

    public void computeEngineButtonClick() {
        computeEngineButton.click();
    }

    public void numberOfInstancesInputSendKeys(int number) {
        numberOfInstancesInput.sendKeys(String.valueOf(number));
    }

    public void machineTypeClick() {
        machineTypeSelect.click();
    }

    public void addGpusCheckboxClick() {
        addGpusCheckbox.click();
    }

    public void numbersOfGpusClick() {
        numbersOfGpusSelect.click();
    }

    public void gpuTypeClick() {
        gpuTypeSelect.click();
    }

    public void localSddClick() {
        localSddSelect.click();
    }

    public void dataCenterLocationClick() { dataCenterLocationSelect.click(); }

    public void committedUsageClick() {
        committedUsageSelect.click();
    }

    public void addToEstimateClick() {
        addToEstimateButton.click();
    }

    // Find elements.
    public WebElement findNumberOfInstanceResult() {
        return numberOfInstanceResult;
    }

    public WebElement findMachineClassResult() {
        return machineClassResult;
    }

    public WebElement findInstanceTypeResult() {
        return instanceTypeResult;
    }

    public WebElement findDataCenterLocationResult() {
        return dataCenterLocationResult;
    }

    public WebElement findLocalSsdResult() {
        return localSsdResult;
    }

    public WebElement findCommittedUsageResult() {
        return committedUsageResult;
    }

    public WebElement findEstimatedComponentCostResult() {
        return estimatedComponentCostResult;
    }

    protected AbstractPage openPage() {
        return null;
    }
}
