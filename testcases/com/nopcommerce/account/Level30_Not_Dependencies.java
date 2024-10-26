package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.*;

public class Level30_Not_Dependencies extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerPageObject customerPage;
    private UserLoginPageObject loginPage;
    private String emailAddress = getEmailRandom();
    private String adminURL, userURL;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;
    private SearchPageObject searchPage;


    @Parameters({"browser", "adminURL", "userURL"})
    // nếu chạy độc lập thì dùng beforeMethods
    // vì thằng method chạy cho từng testcase
    @BeforeMethod
    public void beforeClass(String browserName, String adminURL, String userURL) {
        driver = getBrowserDriver(browserName,userURL);

        this.adminURL = adminURL;
        this.userURL = userURL;

        PageGeneratorManager.getHomePage(driver);
        searchPage = homePage.clickToSearchLink();
        // Mở ra URL page nào -> khởi tạo nó lên
        // Từ 1 page này chuyển qua page kia -> Khở tạo page đó lên

    }

    @Test
    public void shouldBeSearchByEmptyData() {



    }

    @Test (priority = 0)
    public void shouldBeSearchByProductNotExisting() {

        searchPage = homePage.clickToSearchLink();

    }

    @Test(priority = 1)
    public void shouldBeSearchByContainsProductName() {

        searchPage = homePage.clickToSearchLink();

    }

    @Test
    public void shouldBeSearchByProductName() {

        searchPage = homePage.clickToSearchLink();

    }

    @Test
    public void User_01_Search_Empty_Data() {

        searchPage = homePage.clickToSearchLink();

    }




    @AfterMethod
    public void afterClass() {
        closeBrowser();
    }

}
