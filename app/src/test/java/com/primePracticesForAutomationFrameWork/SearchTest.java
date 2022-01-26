package com.primePracticesForAutomationFrameWork;

import com.primePracticesForAutomationFrameWork.drivers.DriverCreator;
import com.primePracticesForAutomationFrameWork.models.Item;
import com.primePracticesForAutomationFrameWork.pages.HomePage;
import com.primePracticesForAutomationFrameWork.pages.LauncherPage;
import com.primePracticesForAutomationFrameWork.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {
    LauncherPage launcherPage;
    HomePage homePage;
    SearchResultPage searchResultPage;
    WebDriver webDriver;

    @BeforeTest
    public void setUp(){
        //Arrange
        webDriver =new DriverCreator().createDriverContext("chrome").create();
        launcherPage=new LauncherPage(webDriver);
        homePage=new HomePage(webDriver);
        searchResultPage=new SearchResultPage(webDriver);
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");
    }


    @Test(enabled = false)
    public void verifySearchItemDoesNotShowTheRelevantResults(){
        String searchItem="Cake";

        //Act
        homePage.search(searchItem);
        List<Item> searchItems=homePage.getSearchItems();
        System.out.println(searchItems);

        //Assert
        Assert.assertEquals(searchItems.size(),0);
    }

    @Test(enabled = false)
    public void verifyAllTheResultsListedBelongToSearchItem(){
        String searchItem="Hazel Brown";

        //Act
        homePage.search(searchItem);
        List<Item> searchItems=homePage.getSearchItems();

        //Assert
        Assert.assertFalse((searchItems.stream().allMatch(item -> item.getName().contains(searchItem))));
    }
    @Test
    public void verifyNumberOfItemsDisplayedIsEqualToResultNumber(){
        String searchItem="Jeans";

        //Act
        homePage.search(searchItem).submitSearch();
        List<Item> searchItems=searchResultPage.getDisplayedItems();
        int resultNumber=searchResultPage.getResultNumber();

        //Assert
        Assert.assertEquals(searchItems.size(),resultNumber);
    }
    @AfterTest
    public void tearDown(){
        webDriver.quit();
    }
}
