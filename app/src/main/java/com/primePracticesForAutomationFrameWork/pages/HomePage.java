package com.primePracticesForAutomationFrameWork.pages;

import com.primePracticesForAutomationFrameWork.models.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    By searchIcon = By.cssSelector("summary[aria-label='Search']");
    By searchBar = By.id("Search-In-Modal");
    By otherSearchIcon =By.xpath("//*[@class=\"icon icon-search\"]");
    By searchResults = By.cssSelector("li[id^='predictive-search-option'] a");
    By productName = By.cssSelector(".predictive-search__item-heading");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage search(String searchItem) {
        pageActions.click(searchIcon);
        pageActions.type(searchBar,searchItem);
        return this;
    }
    public void submitSearch(){
        pageActions.click(otherSearchIcon);
    }

    public List<Item> getSearchItems() {
        List<Item> items = new ArrayList<>();
        try {
            List<WebElement> elements = pageWaits.waitUntilAllElementsAreVisible(searchResults);
            for (WebElement element : elements) {
                String name = pageActions.getChildText(element, productName);
                Item item = new Item();
                item.setName(name);
                items.add(item);
            }
        }catch (TimeoutException e){
            return items;
        }
        return items;
    }
}



