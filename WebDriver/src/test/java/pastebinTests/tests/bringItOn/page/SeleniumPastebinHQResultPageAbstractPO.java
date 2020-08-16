package pastebinTests.tests.bringItOn.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pastebinTests.structure.abstractPageFactory.AbstractPage;
import pastebinTests.structure.enums.homePage.PasteExposureHomePageEnum;
import pastebinTests.structure.enums.homePage.SyntaxHighlightingHomePageEnum;

public class SeleniumPastebinHQResultPageAbstractPO extends AbstractPage {
    private String code;
    private String title;
    private SyntaxHighlightingHomePageEnum syntax;
    private PasteExposureHomePageEnum exposure;

    @FindBy(xpath = "//div[@class=\"info-bar\"]//h1")
    private WebElement infoBarTitle;
    @FindBy(xpath = "//div[@class=\"info-bar\"]//div[@class=\"expire\"]")
    private WebElement infoBarExposure;
    @FindBy(xpath = "//div[@class=\"source\"]//div")
    private WebElement textCode;
    @FindBy(xpath = "//textarea[@class=\"textarea\"]")
    private WebElement textareaCode;
    @FindBy(xpath = "//div[@class=\"left\"]/a")
    private WebElement syntaxType;

    public SeleniumPastebinHQResultPageAbstractPO(WebDriver driver, String code, String title,
                                                     PasteExposureHomePageEnum exposure) {
        super(driver);
        this.code = code;
        this.title = title;
        this.exposure = exposure;
    }

    public SeleniumPastebinHQResultPageAbstractPO(WebDriver driver, String code, String title,
                                                  SyntaxHighlightingHomePageEnum syntax,
                                                  PasteExposureHomePageEnum exposure) {
        super(driver);
        this.code = code;
        this.title = title;
        this.syntax = syntax;
        this.exposure = exposure;
    }

    public WebElement findTitle() {
        return infoBarTitle;
    }

    public WebElement findExposureTime() {
        return infoBarExposure;
    }

    public WebElement findTextCode() {
        return textCode;
    }

    public WebElement findTextareaCode() {
        return textareaCode;
    }

    public WebElement findSyntaxType() { return syntaxType; }

    protected AbstractPage openPage() {
        return null;
    }
}
