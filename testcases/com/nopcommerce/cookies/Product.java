package com.nopcommerce.cookies;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.user.CustomerPageObject;
import pageObjects.nopcommerce.user.HomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

public class Product extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private CustomerPageObject customerPage;
    private UserLoginPageObject loginPage;
    private String adminURL, userURL;


    @Parameters({"browser", "adminURL", "userURL"})
    @BeforeClass
    public void beforeClass(String browserName, String adminURL, String userURL) {
        driver = getBrowserDriver(browserName,userURL);

        this.adminURL = adminURL;
        this.userURL = userURL;

        homePage = PageGeneratorManager.getHomePage(driver);
        loginPage = homePage.clickToLoginLink();

        loginPage.setCookies(driver, Common_Register.cookies);
        loginPage.sleepInSecond(5);
        loginPage.refreshCurrentPage(driver);

        // valid data login > login success > Homepage
        customerPage = homePage.clickToMyAccountLink();
        // -> Customer page

        //verify
        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), Common_Register.firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), Common_Register.lastName);
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), Common_Register.emailAddress);

    }

    @Test
    public void Product_01_New_Product() {

    }

    @Test
    public void Product_02_View_Product() {

    }

    @Test
    public void Product_03_Edit_Product() {

    }


    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

}
