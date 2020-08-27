package googleCloudPricingCalculatorTests.tests.hardcore.page;

import googleCloudPricingCalculatorTests.structure.abstractPageFactory.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinutesMailPage extends AbstractPage {
    private final String HOME_PAGE = "https://10minutemail.net";
    private final int HALF_A_MINUTE = 30;
    private final int ONE_MINUTE = 60;

    @FindBy(xpath = "//input[@id='fe_text']")
    private WebElement mailInput;

    public TenMinutesMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getMailElement() {
        return mailInput;
    }

    public String getHomePageAddress() {
        return HOME_PAGE;
    }

    public String getMailAddress() {
        return mailInput.getAttribute("value");
    }

    public TenMinutesMailWithTotalCostPage openTenMinutesMailWithTotalCostPage() {
        refreshPage(HALF_A_MINUTE);
        new WebDriverWait(driver, ONE_MINUTE).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//a[contains(text(), 'Google Cloud Platform Price Estimate')]")));
            driver.findElement(By.xpath("//a[contains(text(), 'Google Cloud Platform Price Estimate')]")).click();
        return new TenMinutesMailWithTotalCostPage(driver);
    }

    private void refreshPage(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
            driver.navigate().refresh();;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public AbstractPage openPage() {
        ((JavascriptExecutor) driver).executeScript("window.open('https://10minutemail.net')");
        driver.get(HOME_PAGE);
        return this;
    }

    public void openPageInNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open('https://10minutemail.net')");
    }
}
