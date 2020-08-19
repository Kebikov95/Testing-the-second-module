package pastebinTests.tests.iCanWin.page;

import pastebinTests.structure.abstractPageFactory.AbstractPage;
import pastebinTests.structure.enums.homePage.PasteExposureHomePageEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHQHomePageAbstractPO extends AbstractPage {
    private final String HOME_PAGE = "https://pastebin.com";
    private String optionPath = "//span[@class='select2-results']//li[text()='%s']";

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement codeTextArea;
    @FindBy(xpath = "//label[text()='Paste Expiration:']/following-sibling::div")
    private WebElement pasteExpirationSelect;
    @FindBy(xpath = "//span[@class='select2-results']//li[text()='10 Minutes']")
    private WebElement pasteExpirationOption;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement titleInput;
    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createNewPasteButton;

    public PastebinHQHomePageAbstractPO(WebDriver driver) {
        super(driver);
    }

    protected AbstractPage openPage() {
        driver.get(HOME_PAGE);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        return this;
    }

    public PastebinHQResultPageAbstractPO searchForTerms(String code, String title, PasteExposureHomePageEnum exposure) {
        codeTextArea.sendKeys("Hello from WebDriver");
        titleInput.sendKeys("helloweb");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pasteExpirationSelect.click();
//        pasteExpirationOption.click();
        pasteExpirationOption.findElement(By.xpath(String.format(optionPath, exposure.getName()))).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createNewPasteButton.click();
        return new PastebinHQResultPageAbstractPO(driver, code, title, exposure);
    }
}
