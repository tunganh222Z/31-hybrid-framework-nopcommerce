package com.saucelab.sort;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.*;
import pageObjects.saucelab.LoginPageObject;
import pageObjects.saucelab.PageGenerator;
import pageObjects.saucelab.ProductPageObject;

public class Level31_Sort_ASC_DESC extends BaseTest {
    WebDriver driver;
    private ProductPageObject productPage;
    private LoginPageObject loginPage;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName,url);

        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.enterToUserName("standard_user");
        loginPage.enterToPassword("secret_sauce");
        productPage = loginPage.clickToLoginButton();
    }


    @Test
    public void Sort_01_Name() {
        productPage.selectItemInSortDropdown("Name (A to Z)");

        Assert.assertTrue(productPage.isProductSortByAscending());

        productPage.selectItemInSortDropdown("Name (Z to A)");

        Assert.assertTrue(productPage.isProductSortByDescending());


    }

//    @Test
    public void Sort_Price() {
        productPage.selectItemInSortDropdown("Price (low to high)");

        productPage.selectItemInSortDropdown("Price (high to low)");



    }


    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

}
