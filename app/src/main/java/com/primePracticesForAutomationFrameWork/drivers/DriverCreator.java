package com.primePracticesForAutomationFrameWork.drivers;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DriverCreator {

    public WebDriverContext createDriverContext(String browser) {
        browser = setDefaultBrowser(browser);
        DriverManager<WebDriver> webDriverDriverManager = getBrowserManagers().get(browser);
        return new WebDriverContext(webDriverDriverManager);
    }

    public Map<String, DriverManager<WebDriver>> getBrowserManagers() {
        Map<String,DriverManager<WebDriver>> driverManagerMap = new HashMap<>();
        driverManagerMap.put("chrome", new ChromeDriverManager());
        driverManagerMap.put("firefox", new FireFoxDriverManager());
        return driverManagerMap;
    }

    private String setDefaultBrowser(String browser) {
        if(Objects.isNull(browser) || browser.isEmpty()) {
            browser = "chrome";
        }
        return browser;
    }
}