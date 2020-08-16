package pastebinTests.structure.abstractPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class AbstractPage {
    protected WebDriver driver;
    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
//        return new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.presenceOfElementLocated(by));
//    }
}
