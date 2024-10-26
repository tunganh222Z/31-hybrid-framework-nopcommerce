package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import jsonData.Nopcommerce.UserInfo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.CustomerPageObject;
import pageObjects.nopcommerce.user.HomePageObject;
import pageObjects.nopcommerce.user.RegisterPageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

public class Level28_Data_Json extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerPageObject customerPage;
    private UserLoginPageObject loginPage;
    private String emailAddress = getEmailRandom();
    private String adminURL, userURL;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;
    private UserInfo userInfo;
    private String email, lastName, firstName, password;


    @Parameters({"browser", "adminURL", "userURL"})
    @BeforeClass
    public void beforeClass(String browserName, String adminURL, String userURL) {
        driver = getBrowserDriver(browserName,userURL);

        this.adminURL = adminURL;
        this.userURL = userURL;

       homePage = PageGeneratorManager.getHomePage(driver);

       userInfo = UserInfo.getUserInfo("userData.json");

       email = userInfo.getEmail();
       firstName = userInfo.getFirstname();
       lastName = userInfo.getLastname();
       password = userInfo.getPassword();
    }


    @Test
    public void User_05_Register_Success() {
        homePage.clickToHeaderLinksByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.enterToTextBoxByID("FirstName", firstName);
        registerPage.enterToTextBoxByID("LastName", lastName);
        registerPage.enterToTextBoxByID("Email", email);
        registerPage.enterToTextBoxByID("Password", password);
        registerPage.enterToTextBoxByID("ConfirmPassword", password);

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getRegistrationCompletedMsg(), "Your registration completed");


    }

    @Test
    public void User_06_Login_Success() {
        registerPage.clickToHeaderLinksByName("Log out");

        homePage = PageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLinksByName("Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);


        loginPage.enterToTextBoxByID("Email",emailAddress);
        loginPage.enterToTextBoxByID("Password","123tunganh");

        loginPage.clickToButtonByText("Log in");
        homePage = PageGeneratorManager.getHomePage(driver);
        // valid data login > login success > Homepage

        homePage.clickToHeaderLinksByName("My account");
        customerPage = PageGeneratorManager.getCustomerPage(driver);
        // -> Customer page

        //verify

        Assert.assertEquals(customerPage.getTextboxAttributeValueByID("FirstName"),"Tung");

        Assert.assertEquals(customerPage.getTextboxAttributeValueByID("LastName"),"Anh");

        Assert.assertEquals(customerPage.getTextboxAttributeValueByID("Email"),emailAddress);

        customerPage.clickToNopcommerceLogo();
    }



    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

}
