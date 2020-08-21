package googleCloudPricingCalculatorTests.tests.hurtMePlenty;

import googleCloudPricingCalculatorTests.structure.enums.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();

        // google cloud
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[@class='devsite-search-field devsite-search-query']")));
        WebElement searchInput = driver.findElement(By.xpath("//input[@class='devsite-search-field devsite-search-query']"));
        searchInput.click();
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
        searchInput.submit();

        // google cloud search
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@class=\"gs-webResult gs-result\"]//a[@class='gs-title']")));
        List<WebElement> findElements = driver
                .findElements(By.xpath("//div[@class=\"gs-webResult gs-result\"]//a[@class='gs-title']"));
        findElements.get(0).click();

        // google cloud price calculator
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='/products/" +
                "calculator/index_ad8ca20a6d1799e286a0c0839aeb86ca523afe927b04501d8ba77dc59e5b8523.frame']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='myFrame']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//div[@class='name ng-binding'][text()='Compute Engine'])[1]")));
        driver.findElement(By.xpath("(//div[@class='name ng-binding'][text()='Compute Engine'])[1]")).click();
        driver.findElement(By.xpath("//input[@id='input_61']")).click();
        driver.findElement(By.xpath("//input[@id='input_61']")).sendKeys("4");
        driver.findElement(By.xpath("//md-select-value[@id='select_value_label_58']")).click();
        driver.findElement(By.xpath("//md-option[@id='select_option_228']/div[contains(text(), 'n1-standard-8 (vCPUs: 8, RAM: 30GB)')]")).click();
        driver.findElement(By.xpath("(//div[contains(text(), 'Add GPUs')]/..)[1]")).click();
        driver.findElement(By.xpath("//md-select-value[@id='select_value_label_350']")).click();
        driver.findElement(By.xpath("//md-option[@id='select_option_357']/div[contains(text(), '1')]")).click();
        driver.findElement(By.xpath("//md-select-value[@id='select_value_label_351']")).click();
        driver.findElement(By.xpath("//md-option[@id='select_option_364']/div[contains(text(), 'NVIDIA Tesla V100')]")).click();
        driver.findElement(By.xpath("//md-select-value[@id='select_value_label_184']")).click();
        driver.findElement(By.xpath("//md-option[@id='select_option_249']/div[contains(text(), '2x375 GB')]")).click();
        driver.findElement(By.xpath("//md-select-value[@id='select_value_label_59']")).click();
        driver.findElement(By.xpath("//md-option[@id='select_option_196']/div[contains(text(), 'Frankfurt (europe-west3)')]")).click();
        driver.findElement(By.xpath("//md-select-value[@id='select_value_label_60']")).click();
        driver.findElement(By.xpath("//md-option[@id='select_option_93']/div[text()='1 Year']")).click();
        driver.findElement(By.xpath("//button[text()='Add to Estimate']")).click();

        driver.quit();
    }

    public static String getMachineTypePath(MachineTypeEnum type) {
        return String.format("//md-option/div[@class='md-text ng-binding']" +
                "[contains(text(), '%s')]", type.getName());
    }

    public static String getNumberOfCpuPath(NumberOfGpusEnum number) {
        return String.format("//md-option[@id='select_option_357']" +
                "/div[@class='md-text ng-binding'][contains(text(), '%s')]", number.getName());
    }

    public static String getCpuTypePath(GpuTypeEnum type) {
        return String.format("//md-option[@id='select_option_364']" +
                "/div[@class='md-text ng-binding'][contains(text(), '%s')]", type.getName());
    }

    public static String getLocalSsdEnum(LocalSsdEnum ssd) {
        return String.format("//md-option[@id='select_option_248']" +
                "/div[@class='md-text ng-binding'][contains(text(), '%s')]", ssd.getName());
    }

    public static String getDataCenterLocationEnum(DataCenterLocationEnum location) {
        return String.format("//md-option[@id='select_option_196']" +
                "/div[@class='md-text ng-binding'][contains(text(), '%s')]", location.getName());
    }

    public static String getCommittedUsageEnum(CommittedUsageEnum usage) {
        return String.format("//md-option[@id='select_option_93']" +
                "/div[@class='md-text'][contains(text(), '%s')]", usage.getName());
    }
}
