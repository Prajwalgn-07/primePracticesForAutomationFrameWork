package com.primePracticesForAutomationFrameWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageActions {
    private WebDriver webDriver;
    private PageWaits pageWaits;
    public PageActions(WebDriver driver) {
        this.webDriver=driver;
        this.pageWaits=new PageWaits(driver);
    }
    public void click(By by){
        pageWaits.waitForElementToBeVisible(by).click();
    }
    public void type(By by, String value){
        pageWaits.waitForElementToBeVisible(by).sendKeys(value);
    }
    public String getChildText(WebElement webElement, By by){
        return webElement.findElement(by).getText();
    }
}
