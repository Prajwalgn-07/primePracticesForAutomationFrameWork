package com.primePracticesForAutomationFrameWork.pages;

import com.primePracticesForAutomationFrameWork.models.Item;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {
    private int resultNumber;
    public SearchResultPage(WebDriver driver) {
    }

    public List<Item> getDisplayedItems() {
        return new ArrayList<>();
    }

    public int getResultNumber() {
        return resultNumber;
    }
}
