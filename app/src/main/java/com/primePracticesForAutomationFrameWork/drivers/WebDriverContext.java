package com.primePracticesForAutomationFrameWork.drivers;

import org.openqa.selenium.WebDriver;

public class WebDriverContext {
    private DriverManager<WebDriver>driverManager;
    public WebDriverContext(DriverManager<WebDriver>driverManager){
        setDriverManager(driverManager);
    }
    public WebDriver create(){
        return driverManager.create();
    }
    public void setDriverManager(DriverManager<WebDriver> driverManager) {
        this.driverManager = driverManager;
    }
}
