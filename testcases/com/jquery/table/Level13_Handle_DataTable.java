package com.jquery.table;

import commons.BaseTestJQuery;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

import java.util.ArrayList;
import java.util.List;

public class Level13_Handle_DataTable extends BaseTestJQuery {
    WebDriver driver;
    private HomePageObject homePage;
    List<String> allValueUI = new ArrayList<String>();
    List<String> allValueDB = new ArrayList<String>();

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void TC_01_Search_Data (){
        //Search dữ liệu trong 1 Table (trên Header)
        //homePage.sendKeyToColumnTextBox("Females", "384187");
        //homePage.sendKeyToColumnTextBox("Country", "Afghanistan");
        //homePage.sendKeyToColumnTextBox("Males", "407124");
        //homePage.sendKeyToColumnTextBox("Total", "791312");
    }

    @Test
    public void TC_02_Paging (){

       // homePage.clickToPageByNumber("1");
       // homePage.isPageActiveByNumber("1");

    }

    @Test
    public void TC_03_Displayed (){
        //Verify any row
        //homePage.isRowValuesDisplayed("159979", "Chad", "161889", "321868");

    }

    @Test
    public void TC_04_Icon_Button_Checkbox (){
        //homePage.clickToRowActionByCountry("Comoros", "remove");

    }

    @Test
    public void TC_05_Get_All_Row_Values(){
        //allValueUI = homePage.getAllPageValueByColumnName("Country");
    }

    @Test
    public void TC_06_Action_By_Index(){
        homePage.openPageURL(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");

        homePage.enterToTextBoxByColumnNameAndRowIndex("Contact Person", "2", "TungAnh");
        //Nhập vào textbox tại Contact person row 2
        // Select dữ liệu Country row 3
        //Click vào checkbox tại cột NOP row 1

        homePage.selectDropdownAndRowIndex("Country", "Taiwan","3");
    }

    @AfterClass
    public void afterClass(){
       // closeBrowser();
    }
}
