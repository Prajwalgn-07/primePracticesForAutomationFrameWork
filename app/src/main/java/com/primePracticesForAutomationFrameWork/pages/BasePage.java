package com.primePracticesForAutomationFrameWork.pages;

import org.openqa.selenium.WebDriver;

public class BasePage{
    protected PageWaits pageWaits;
    private WebDriver webDriver;
    protected PageActions pageActions;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.pageWaits = new PageWaits(webDriver);
        this.pageActions = new PageActions(webDriver);
    }
}
