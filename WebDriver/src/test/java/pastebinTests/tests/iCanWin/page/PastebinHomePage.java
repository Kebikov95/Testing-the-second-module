package pastebinTests.tests.iCanWin.page;

import org.openqa.selenium.support.PageFactory;
import pastebinTests.structure.abstractPageFactory.AbstractPage;
import pastebinTests.structure.enums.homePage.PasteExposureHomePageEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage extends AbstractPage {
    private final String HOME_PAGE = "https://pastebin.com";
    private String optionPath = "//span[@class='select2-results']//li[text()='%s']";

    private final String PASTE_EXPOSURE = "//span[@class='select2-results']//li[text()='%s']";
    private final String PASTE_EXPIRATION_LABEL = "//label[text()='Paste Expiration:']/following-sibling::div";
    private final String POST_FORM_EXPIRATION_CONTAINER = "//label[text()='Paste Expiration:']/following-sibling::div";

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

    public PastebinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPasteExposurePath(PasteExposureHomePageEnum exposure) {
        return String.format(PASTE_EXPOSURE, exposure.getName());
    }

    public String getPasteExpirationLabel() {
        return PASTE_EXPIRATION_LABEL;
    }

    public String getPostformExpirationContainer() {
        return POST_FORM_EXPIRATION_CONTAINER;
    }

    public PastebinResultPage searchForTerms(String code, String title, PasteExposureHomePageEnum exposure) {
        codeTextArea.sendKeys(code);
        titleInput.sendKeys(title);
        pasteExpirationSelect.click();
        pasteExpirationOption.findElement(By.xpath(String.format(optionPath, exposure.getName()))).click();
        createNewPasteButton.click();
        return new PastebinResultPage(driver);
    }

    protected AbstractPage openPage() {
        driver.get(HOME_PAGE);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        return this;
    }
}
