package com.nopcommerce.account;

import commons.BaseTestJQuery;
import commons.PageGenratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadPageObject;
import pageObjects.nopcommerce.user.HomePageObject;

import java.util.ArrayList;
import java.util.List;

public class Level15_Assert_Verify extends BaseTestJQuery {
    WebDriver driver;
    HomePageObject homePage;



    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenratorManager.getHomePage(driver);
    }

    @Test
    public void TC_01_Upload_Single_File (){

    }

    @Test
    public void TC_02_Upload_Multiple_Files(){

    }

    @AfterClass
    public void afterClass(){
       // closeBrowser();
    }
}
