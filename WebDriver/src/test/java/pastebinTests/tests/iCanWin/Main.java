package pastebinTests.tests.iCanWin;

import pastebinTests.structure.enums.homePage.PasteExposureHomePageEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    static String pasteExpirationOptionXpath = "//span[@class='select2-results']//li[text()='%s']";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        String line = String.format(pasteExpirationOptionXpath,
                PasteExposureHomePageEnum.TEN_MINUTES.getName());
        System.out.println(line);

        driver.findElement(By.id("postform-text")).sendKeys("Code WebDriver");
        driver.findElement(By.xpath("//input[@id='postform-name']"))
                .sendKeys("title");
        driver.findElement(By.xpath("//label[text()=\"Paste Expiration:\"]/following-sibling::div")).click();
        WebElement element = driver
                .findElement(By.xpath(String.format(line)));
        element.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Create New Paste']")).click();
        driver.quit();
    }
}
