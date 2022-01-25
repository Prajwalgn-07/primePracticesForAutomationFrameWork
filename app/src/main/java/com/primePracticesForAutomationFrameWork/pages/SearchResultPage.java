package com.primePracticesForAutomationFrameWork.pages;

import com.primePracticesForAutomationFrameWork.models.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {
    WebDriver webDriver;
    By productsName=By.xpath("//*[@class=\"card-information__text h5\"]//a");
    By numberOfResults=By.cssSelector("p#ProductCountDesktop");
    public SearchResultPage(WebDriver driver) {
        this.webDriver =driver;
    }

    public List<Item> getDisplayedItems() {
        List<WebElement> elements = webDriver.findElements(productsName);
        List<Item> items = new ArrayList<>();
        for(WebElement element : elements) {
            String name = element.getText();
            Item item = new Item();
            item.setName(name);
            items.add(item);
        }
        return items;
    }

    public int getResultNumber() {
        String result=webDriver.findElement(numberOfResults).getText();
        return Integer.parseInt(result.replaceAll("[^0-9]", ""));
    }
}
