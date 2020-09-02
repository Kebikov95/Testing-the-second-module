package com.hardcore.page;

import com.hardcore.driver.DriverSingleton;
import com.hardcore.model.ComputeEngine;
import com.hardcore.util.BrowserTabsManager;
import com.structure.abstractPageFactory.AbstractPage;
import com.structure.enums.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPlatformPricingCalculatorPage extends AbstractPage {
    private WebDriverWait waiter;
    private final String HOME_PAGE = "https://cloud.google.com/products/calculator";

    public final static String MAIN_FRAME_PATH = "//iframe[@src='/products/" +
            "calculator/index_ad8ca20a6d1799e286a0c0839aeb86ca523afe927b04501d8ba77dc59e5b8523.frame']";
    public final static String MY_FRAME_PATH = "//iframe[@id='myFrame']";
    public final static String MACHINE_TYPE_OPTION_PATH = "//md-select-menu//div[contains(text(), '%s')]";
    public final static String NUMBERS_OF_GPUS_OPTION_PATH = "//div[@id='select_container_373']//div[contains(text(), '%s')]";
    public final static String GPU_TYPE_OPTION_PATH = "//md-option/div[contains(text(), '%s')]";
    public final static String LOCAL_SDD_OPTION_PATH = "//div[@id='select_container_194']//div[contains(text(), '%s')]";
    public final static String DATA_CENTER_LOCATION_OPTION_PATH = "//div[@id='select_container_89']//div[contains(text(), '%s')]";
    public final static String COMMITTED_USAGE_OPTION_PATH = "//div[@id='select_container_96']//div[contains(text(), '%s')]";

    @FindBy(xpath = "(//div[text()='Compute Engine'])[1]")
    private WebElement computeEngineButton;
    @FindBy(xpath = "//input[@id='input_60']")
    private WebElement numberOfInstancesInput;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_57']")
    private WebElement machineTypeSelect;
    @FindBy(xpath = "(//md-checkbox[@class='ng-pristine ng-untouched ng-valid ng-empty'])[1]")
    private WebElement addGpusCheckbox;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numbersOfGpusSelect;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeSelect;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_192']")
    private WebElement localSddSelect;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_58']")
    private WebElement dataCenterLocationSelect;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_59']")
    private WebElement committedUsageSelect;
    @FindBy(xpath = "(//button[contains(text(), 'Add to Estimate')])[1]")
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

    @FindBy(xpath = "//button[contains(text(), 'Email Estimate')]")
    private WebElement emailEstimateButton;
    @FindBy(xpath = "(//input[@name='description'])[3]")
    private WebElement emailInput;
    @FindBy(xpath = "//md-dialog-actions//button[contains(text(), 'Send Email')]")
    private WebElement sendEmailButton;

    protected GoogleCloudPlatformPricingCalculatorPage(WebDriver driver) {
        super(driver);
        waiter = new WebDriverWait(driver, 10);
        frameWaiting();
        PageFactory.initElements(driver, this);
    }

    private void frameWaiting() {
        waiter.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(MAIN_FRAME_PATH)));
        waiter.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(MY_FRAME_PATH)));
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
    }

    public void login(ComputeEngine engine) {
        this.computeEngineButtonClick();
        this.numberOfInstancesInputSendKeys(engine.getNumberOfInstances());
        this.machineTypeClick();
        this.machineTypeOptionClick(engine.getMachineType());
        this.addGpusCheckboxClick();
        this.numbersOfGpusClick();
        this.numbersOfGpusOptionClick(engine.getNumberOfGpus());
        this.gpuTypeClick();
        this.gpuTypeOptionClick(engine.getGpuType());
        this.localSddClick();
        this.localSddOptionClick(engine.getLocalSsd());
        this.dataCenterLocationClick();
        this.dataCenterLocationOptionClick(engine.getDataCenterLocation());
        this.committedUsageClick();
        this.committedUsageOptionClick(engine.getCommittedUsage());
        this.addToEstimateClick();
    }

    public TenMinutesMailPage sendEmailWithComponentCost(String email) {
        frameWaiting();
        emailEstimateButton.click();
        emailInput.click();
        emailInput.sendKeys(email);
        sendEmailButton.click();
        return new TenMinutesMailPage(driver);
    }

    public String getComponentCostByMail(TenMinutesMailPage mailPage) {
        mailPage.openPageInNewTab();
        BrowserTabsManager.getNextWebPage();
        String email = mailPage.getMailAddress();
        BrowserTabsManager.getPreviousWebPage();
        this.sendEmailWithComponentCost(email);
        BrowserTabsManager.getNextWebPage();
        mailPage.clickToNewPost();
        return mailPage.getTotalCost();
    }

     // Methods for clicking static Web elements.
    public void computeEngineButtonClick() {
        computeEngineButton.click();
    }

    public void numberOfInstancesInputSendKeys(int number) {
        numberOfInstancesInput.sendKeys(String.valueOf(number));
    }

    public void machineTypeClick() { machineTypeSelect.click(); }

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

    // Methods for clicking dynamic Web elements.
    public void machineTypeOptionClick(MachineTypeEnum type) {
        clickToElement(String.format(MACHINE_TYPE_OPTION_PATH, type.getName()));
    }

    public void numbersOfGpusOptionClick(NumberOfGpusEnum type) {
        clickToElement(String.format(NUMBERS_OF_GPUS_OPTION_PATH, type.getName()));
    }

    public void gpuTypeOptionClick(GpuTypeEnum type) {
        clickToElement(String.format(GPU_TYPE_OPTION_PATH, type.getName()));
    }

    public void localSddOptionClick(LocalSsdEnum type) {
        clickToElement(String.format(LOCAL_SDD_OPTION_PATH, type.getName()));
    }

    public void dataCenterLocationOptionClick(DataCenterLocationEnum type) {
        clickToElement(String.format(DATA_CENTER_LOCATION_OPTION_PATH, type.getName()));
    }

    public void committedUsageOptionClick(CommittedUsageEnum type) {
        clickToElement(String.format(COMMITTED_USAGE_OPTION_PATH, type.getName()));
    }

    // Find elements.
    public String findNumberOfInstanceResult() { return numberOfInstanceResult.getText().trim(); }

    public String findMachineClassResult() {
        return machineClassResult.getText().trim();
    }

    public String findInstanceTypeResult() {
        return instanceTypeResult.getText().trim();
    }

    public String findDataCenterLocationResult() {
        return dataCenterLocationResult.getText().trim();
    }

    public String findLocalSsdResult() {
        return localSsdResult.getText().trim();
    }

    public String findCommittedUsageResult() {
        return committedUsageResult.getText().trim();
    }

    public String findEstimatedComponentCostResult() {
        return estimatedComponentCostResult.getText().trim();
    }

    // Override method.
    protected AbstractPage openPage() {
        driver.navigate().to(HOME_PAGE);
        return this;
    }
}
