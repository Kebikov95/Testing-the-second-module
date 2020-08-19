package pastebinTests.tests.iCanWin.page;

import org.openqa.selenium.support.PageFactory;
import pastebinTests.structure.abstractPageFactory.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinResultPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='info-bar']//h1")
    private WebElement infoBarTitle;
    @FindBy(xpath = "//div[@class='info-bar']//div[@class='expire']")
    private WebElement infoBarExposure;
    @FindBy(xpath = "//div[@class='source']//div")
    private WebElement textCode;
    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement textareaCode;

    protected PastebinResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitingForItemToLoad("//div[@class='info-bar']//h1");
    }

    protected AbstractPage openPage() {
        return null;
    }

    public WebElement findCode() {
        return textareaCode;
    }

    public WebElement findTitle() {
        return infoBarTitle;
    }

    public WebElement findExposure() {
        return infoBarExposure;
    }
}
