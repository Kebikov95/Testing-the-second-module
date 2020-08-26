package googleCloudPricingCalculatorTests.tests.hardcore.page;

import googleCloudPricingCalculatorTests.structure.abstractPageFactory.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenMinutesMailWithTotalCostPage extends AbstractPage {
    private final String HOME_PAGE = "https://10minutemail.net";

    @FindBy(xpath = "//table[@class='quote']//tr//td[4]")
    private WebElement estimatedMonthlyCost;

    protected TenMinutesMailWithTotalCostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getEstimatedMonthlyCostElement() {
        return estimatedMonthlyCost;
    }

    protected AbstractPage openPage() {
        return null;
    }
}
