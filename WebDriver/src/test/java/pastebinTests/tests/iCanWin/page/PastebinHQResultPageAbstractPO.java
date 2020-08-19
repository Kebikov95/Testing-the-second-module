package pastebinTests.tests.iCanWin.page;

import pastebinTests.structure.abstractPageFactory.AbstractPage;
import pastebinTests.structure.enums.homePage.PasteExposureHomePageEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinHQResultPageAbstractPO extends AbstractPage {
    private String code;
    private String title;
    private PasteExposureHomePageEnum exposure;

    @FindBy(xpath = "//div[@class=\"info-bar\"]//h1")
    private WebElement infoBarTitle;
    @FindBy(xpath = "//div[@class=\"info-bar\"]//div[@class=\"expire\"]")
    private WebElement infoBarExposure;
    @FindBy(xpath = "//div[@class=\"source\"]//div")
    private WebElement textCode;
    @FindBy(xpath = "//textarea[@class=\"textarea\"]")
    private WebElement textareaCode;

    protected PastebinHQResultPageAbstractPO(WebDriver driver, String code, String title,
                                                     PasteExposureHomePageEnum exposure) {
        super(driver);
        this.code = code;
        this.title = title;
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

    protected AbstractPage openPage() {
        return null;
    }
}
