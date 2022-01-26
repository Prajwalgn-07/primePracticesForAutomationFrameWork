package com.primePracticesForAutomationFrameWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class PageWaits {
    private WebDriver webDriver;
    private FluentWait<WebDriver>wait;
    public PageWaits(WebDriver driver){
        this.webDriver=driver;
        wait=initWait(webDriver);
    }


    public List<WebElement> waitUntilAllElementsAreVisible(By by){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public WebElement waitForElementToBeVisible(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private FluentWait<WebDriver> initWait(WebDriver webDriver) {
        return new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }
}
