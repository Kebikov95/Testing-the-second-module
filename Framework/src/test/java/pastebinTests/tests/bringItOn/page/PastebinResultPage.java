package pastebinTests.tests.bringItOn.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pastebinTests.structure.abstractPageFactory.AbstractPage;

public class PastebinResultPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='info-bar']//h1")
    private WebElement infoBarTitle;
    @FindBy(xpath = "//div[@class='info-bar']//div[@class='expire']")
    private WebElement infoBarExposure;
    @FindBy(xpath = "//div[@class='source']//div")
    private WebElement textCode;
    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement textareaCode;
    @FindBy(xpath = "//div[@class='left']/a")
    private WebElement syntaxType;

    public PastebinResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitingForItemToLoad("//textarea[@class='textarea']");
    }

    public String findTitle() { return infoBarTitle.getText().trim(); }

    public String findExposureTime() {
        return infoBarExposure.getText().trim();
    }

    public String findTextCode() {
        return textCode.getText().trim();
    }

    public String findTextareaCode() { return textareaCode.getText().trim(); }

    public String findSyntaxType() { return syntaxType.getText().trim(); }

    protected AbstractPage openPage() {
        return null;
    }
}
