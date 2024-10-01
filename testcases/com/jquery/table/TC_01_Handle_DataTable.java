package com.jquery.table;

import commons.BaseTest;
import commons.BaseTestJQuery;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class TC_01_Handle_DataTable extends BaseTestJQuery {
    WebDriver driver;
    private HomePageObject homePage;
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void TC_01_Search_Data (){
        //Search dữ liệu trong 1 Table (trên Header)
        homePage.sendKeyToColumnTextBox("Females", "384187");
        homePage.sendKeyToColumnTextBox("Country", "Afghanistan");
        homePage.sendKeyToColumnTextBox("Males", "407124");
        homePage.sendKeyToColumnTextBox("Total", "791312");
    }

    @Test
    public void TC_02_Paging (){

        homePage.clickToPageByNumber("5");
        homePage.isPageActiveByNumber("5");

    }

    @Test
    public void TC_03_Displayed (){
        //Verify any row
        homePage.isRowValuesDisplayed("159979", "Chad", "161889", "321868");

    }

    @Test
    public void TC_04_Icon_Button_Checkbox (){
        homePage.clickToRowActionByCountry("Comoros", "remove");

    }

    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
