package googleCloudPricingCalculatorTests.tests.hurtMePlenty.page;

import googleCloudPricingCalculatorTests.structure.abstractPageFactory.AbstractPage;
import googleCloudPricingCalculatorTests.structure.enums.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPlatformPricingCalculatorPageAbstractPO extends AbstractPage {
    private WebDriver driver;
    private final String HOME_PAGE = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "(//*[@id='mainForm']//div/div[text()='Compute Engine'])[1]")
    private WebElement computeEngineBlock;
    @FindBy(xpath = "//input[@id='input_61']")
    private WebElement numberOfInstancesInput;
    @FindBy(xpath = "//input[@id='input_62']")
    private WebElement instancesForInput;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_54']/span/div[@class='md-text']")
    private WebElement operatingSystemSelect;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_58']/span/div[@class='md-text']")
    private WebElement machineTypeSelect;
    @FindBy(xpath = "(//div[contains(text(), 'Add GPUs')]/..)[1]")
    private WebElement addGpusCheckbox;
    @FindBy(xpath = "//*[@id='select_value_label_350']")
    private WebElement numberOfGpusSelect;
    @FindBy(xpath = "//*[@id='select_value_label_350']")
    private WebElement gpuTypeSelect;
    @FindBy(xpath = "//*[@id='select_value_label_184']")
    private WebElement localSddSelect;
    @FindBy(xpath = "//*[@id='select_value_label_59']")
    private WebElement dataCenterLocationSelect;
    @FindBy(xpath = "//*[@id='select_value_label_100']")
    private WebElement committedUsageSelect;
    @FindBy(xpath = "//button[text()='Add to Estimate']")
    private WebElement addToEstimateButton;

    protected GoogleCloudPlatformPricingCalculatorPageAbstractPO(WebDriver driver) {
        super(driver);
        waitingForItemToLoad("(//*[@id='mainForm']//div/div[text()='Compute Engine'])[1]");
    }

    protected AbstractPage openPage() {
        driver.get(HOME_PAGE);
        waitingForItemToLoad("//button[text()='Add to Estimate']");
        return this;
    }

    // Set information in inputs.
    public void clickComputeEngine() {
        computeEngineBlock.click();
    }

    public void sendNumberToNumberOfInstances(int number) {
        numberOfInstancesInput.sendKeys(String.valueOf(number));
    }

    public void sendLineToInstancesForInput(String line) {
        instancesForInput.sendKeys(String.valueOf(line));
    }

    public void chooseMachineType(MachineTypeEnum type) {
        driver.findElement(By.xpath(getMachineTypePath(type))).click();
    }

    public void checkAddGpusCheckbox() {
        addGpusCheckbox.click();
    }

    public void chooseNumberOfGpus(NumberOfGpusEnum number) {
        driver.findElement(By.xpath(getNumberOfGpuPath(number))).click();
    }

    public void chooseGpuType(GpuTypeEnum type) {
        driver.findElement(By.xpath(getGpuTypePath(type)));
    }

    public void chooseLocalSsd(LocalSsdEnum ssd) {
        driver.findElement(By.xpath(getLocalSsdEnum(ssd))).click();
    }

    public void chooseDataCenterLocation(DataCenterLocationEnum location) {
        driver.findElement(By.xpath(getDataCenterLocationEnum(location))).click();
    }

    public void chooseCommitedUsage(CommittedUsageEnum usage) {
        driver.findElement(By.xpath(getCommittedUsageEnum(usage))).click();
    }

    public void clickAddToEstimateButton() {
        addToEstimateButton.click();
    }

    // Get path.
    public String getMachineTypePath(MachineTypeEnum type) {
        return String.format("//md-option/div[@class='md-text ng-binding']" +
                "[contains(text(), '%s')]", type.getName());
    }

    public String getNumberOfGpuPath(NumberOfGpusEnum number) {
        return String.format("//md-option[@id='select_option_357']" +
                "/div[@class='md-text ng-binding'][contains(text(), '%s')]", number.getName());
    }

    public String getGpuTypePath(GpuTypeEnum type) {
        return String.format("//md-option[@id='select_option_364']" +
                "/div[@class='md-text ng-binding'][contains(text(), '%s')]", type.getName());
    }

    public String getLocalSsdEnum(LocalSsdEnum ssd) {
        return String.format("//md-option[@id='select_option_248']" +
                "/div[@class='md-text ng-binding'][contains(text(), '%s')]", ssd.getName());
    }

    public String getDataCenterLocationEnum(DataCenterLocationEnum location) {
        return String.format("//md-option[@id='select_option_196']" +
                "/div[@class='md-text ng-binding'][contains(text(), '%s')]", location.getName());
    }

    public String getCommittedUsageEnum(CommittedUsageEnum usage) {
        return String.format("//md-option[@id='select_option_93']" +
                "/div[@class='md-text'][contains(text(), '%s')]", usage.getName());
    }

    // Find elements.
    public WebElement findComputeEngineBlock() {
        return computeEngineBlock;
    }

    public WebElement findNumberOfInstancesInput() {
        return numberOfInstancesInput;
    }

    public WebElement findInstancesForInput() {
        return instancesForInput;
    }

    public WebElement findOperatingSystemSelect() {
        return operatingSystemSelect;
    }

    public WebElement findMachineTypeSelect() {
        return machineTypeSelect;
    }

    public WebElement findAddGpusCheckbox() {
        return addGpusCheckbox;
    }

    public WebElement findNumberOfGpusSelect() {
        return numberOfGpusSelect;
    }

    public WebElement findGpuTypeSelect() {
        return gpuTypeSelect;
    }

    public WebElement findLocalSddSelect() {
        return localSddSelect;
    }

    public WebElement findDataCenterLocationSelect() {
        return dataCenterLocationSelect;
    }

    public WebElement findCommittedUsageSelect() {
        return committedUsageSelect;
    }

    public WebElement findAddToEstimateButton() {
        return addToEstimateButton;
    }
}
