package com.jquery.upload;

import commons.BaseTestJQuery;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadPageObject;

import java.util.ArrayList;
import java.util.List;

public class TC_01_Upload_File extends BaseTestJQuery {
    WebDriver driver;
    private UploadPageObject uploadPage;
    List<String> allValueUI = new ArrayList<String>();
    List<String> allValueDB = new ArrayList<String>();
    String image75 = "image (75).png";
    String image76 = "image (76).png";
    String image1 = "Image1.png";
    String image2 = "image2.jpg";
    String[] fileNames = {image75, image1, image2, image76};


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        uploadPage = PageGeneratorManager.getUploadPage(driver);
    }

    @Test
    public void TC_01_Upload_Single_File (){
        uploadPage.openPageURL(driver, "https://blueimp.github.io/jQuery-File-Upload/");
        uploadPage.uploadMultipleFiles(driver, image75);
        uploadPage.uploadMultipleFiles(driver, image76);
        uploadPage.uploadMultipleFiles(driver, image1);
        uploadPage.uploadMultipleFiles(driver, image2);
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(image75));

        uploadPage.clickStartButtonEachFile();

        Assert.assertTrue(uploadPage.isFileUploadedSuccess(image75));
    }

    @Test
    public void TC_02_Upload_Multiple_Files(){
        uploadPage.refreshCurrentPage(driver);
        uploadPage.uploadMultipleFiles(driver, fileNames);
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(image75));

        uploadPage.clickStartButtonEachFile();

        Assert.assertTrue(uploadPage.isFileUploadedSuccess(image75));
    }

    @AfterClass
    public void afterClass(){
       // closeBrowser();
    }
}
