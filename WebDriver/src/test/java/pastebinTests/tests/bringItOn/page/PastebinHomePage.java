package pastebinTests.tests.bringItOn.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pastebinTests.structure.abstractPageFactory.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pastebinTests.structure.enums.homePage.PasteExposureHomePageEnum;
import pastebinTests.structure.enums.homePage.SyntaxHighlightingHomePageEnum;

public class PastebinHomePage extends AbstractPage {
    private final String HOME_PAGE = "https://pastebin.com";
    private String optionPath = "//span[@class='select2-results']//li[text()='%s']";

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement codeTextArea;
    @FindBy(xpath = "//span[@id='select2-postform-format-container']")
    private WebElement syntaxHighlightingSelect;
    @FindBy(xpath = "(//ul[@id='select2-postform-format-results']//li[text()='Bash'])[1]")
    private WebElement syntaxHighlightingOption;
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

    protected AbstractPage openPage() {
        driver.get(HOME_PAGE);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        return this;
    }

    public PastebinResultPage searchForTerms(String code, String title, PasteExposureHomePageEnum exposure) {
        codeTextArea.sendKeys("Hello from WebDriver");
        titleInput.sendKeys("helloweb");
        pasteExpirationSelect.click();
        pasteExpirationOption.findElement(By.xpath(String.format(optionPath, exposure.getName()))).click();
        createNewPasteButton.submit();
        return new PastebinResultPage(driver);
    }

    public PastebinResultPage searchForTerms(String code, String title,
                                             SyntaxHighlightingHomePageEnum syntax,
                                             PasteExposureHomePageEnum expiration) {
        codeTextArea.sendKeys(code);
        titleInput.sendKeys(title);
        syntaxHighlightingSelect.click();
        syntaxHighlightingOption.click();
        pasteExpirationSelect.click();
        pasteExpirationOption.click();
        createNewPasteButton.submit();
        return new PastebinResultPage(driver);
    }
}
