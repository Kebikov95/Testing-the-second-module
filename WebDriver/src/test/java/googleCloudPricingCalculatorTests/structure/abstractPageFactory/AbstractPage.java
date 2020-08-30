package googleCloudPricingCalculatorTests.structure.abstractPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected abstract AbstractPage openPage();

    public void waitingForItemToLoad(String path) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
    }

    public void waitingForItemToLoad(String path, int seconds) {
        new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
    }

    public void clickToElement(String path) {
        waitingForItemToLoad(path);
        driver.findElement(By.xpath(path)).click();
    }
}
