package com.hardcore.util;

import com.hardcore.driver.DriverSingleton;

import java.util.ArrayList;

public class BrowserTabsManager {
    private static ArrayList<String> tabs;

    public static void getPreviousWebPage() {
        tabs = new ArrayList<String>(DriverSingleton.getDriver().getWindowHandles());
        DriverSingleton.getDriver().switchTo().window(tabs.get(0));
    }

    public static void getNextWebPage() {
        tabs = new ArrayList<String>(DriverSingleton.getDriver().getWindowHandles());
        DriverSingleton.getDriver().switchTo().window(tabs.get(1));
    }
}
