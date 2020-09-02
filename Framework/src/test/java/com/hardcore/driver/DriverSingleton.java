package com.hardcore.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;

public class DriverSingleton {
    private static WebDriver driver;
    private static ArrayList<String> tabs;
    private static final String RESOURCES_PATH = "src\\test\\resources";

    private DriverSingleton() {}

    public static WebDriver getDriver() {
        if(driver == null) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void getPreviousWebPage() {
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public static void getNextWebPage() {
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
