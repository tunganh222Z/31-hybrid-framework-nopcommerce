package com.facebook.home;


import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level20_Element_Undisplayed extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;

    @Parameters({"browser", "facebookURL"})
    @BeforeClass
    public void beforeClass(String browser, String facebookURL){
        driver = getBrowserDriver(browser, facebookURL);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void TC_01_Element_Displayed(){

        log.info("Click to create new account button");
        homePage.clickToCreateNewAccountButton();

        log.info("Verify confirm Firstname textbox is not displayed");
        verifyTrue(homePage.isFirstNameTextboxDisplayed());

        log.info("Verify confirm Surname textbox is not displayed");
        verifyTrue(homePage.isSurNameTextboxDisplayed());

        log.info("Verify confirm Email textbox is not displayed");
        verifyTrue(homePage.isEmailTextboxDisplayed());

        log.info("Verify confirm Password textbox is not displayed");
        verifyTrue(homePage.isPasswordTextboxDisplayed());

        homePage.enterToEmailTextbox("automation@gmail.com");

        log.info("Verify confirm Email textbox is displayed");
        verifyTrue(homePage.isConfirmEmailTextboxDisplayed());
    }

    @Test
    public void TC_02_Element_Undisplayed(){
        homePage.enterToEmailTextbox("");

        log.info("Verify confirm email textbox is not displayed");
        verifyFalse(homePage.isConfirmEmailTextboxDisplayed());

    }

    @Test
    public void TC_03_Element_Undisplayed_Not_In_DOM(){

        log.info("Click to close sign up popup");
        homePage.clickToCloseSignUpPopup();

        log.info("Verify confirm Firstname textbox is not displayed");
        verifyFalse(homePage.isFirstNameTextboxDisplayed());

        log.info("Verify confirm Surname textbox is not displayed");
        verifyFalse(homePage.isSurNameTextboxDisplayed());

        log.info("Verify confirm Email textbox is not displayed");
        verifyFalse(homePage.isEmailTextboxDisplayed());

        log.info("Verify confirm Password textbox is not displayed");
        verifyFalse(homePage.isPasswordTextboxDisplayed());

    }


}
