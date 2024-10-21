package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
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
import pojoData.UserInfo;
import utilities.FakerConfig;

public class Level27_Data_POJO extends BaseTest {
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
    private FakerConfig fakerConfig;


    @Parameters({"browser", "adminURL", "userURL"})
    @BeforeClass
    public void beforeClass(String browserName, String adminURL, String userURL) {
        driver = getBrowserDriver(browserName,userURL);

        this.adminURL = adminURL;
        this.userURL = userURL;

       homePage = PageGeneratorManager.getHomePage(driver);
        // Mở ra URL page nào -> khởi tạo nó lên
        // Từ 1 page này chuyển qua page kia -> Khở tạo page đó lên

        userInfo = UserInfo.getUser();
        userInfo.setEmailAddress(getEmailRandom());
        userInfo.setFirstName(fakerConfig.getFirstName());
        userInfo.setLastName("Kennedy");
        userInfo.setPassword("tunganh123!!@#");

    }

    @Test
    public void User_05_Register_Success() {
        homePage = registerPage.clickToNopcommerceLogo();

        homePage.clickToHeaderLinksByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.setFormRegister(userInfo);
//        registerPage.enterToTextBoxByID("FirstName", userInfo.getFirstName());
//        registerPage.enterToTextBoxByID("LastName", userInfo.getLastName());
//        registerPage.enterToTextBoxByID("Email", userInfo.getEmailAddress());
//        registerPage.enterToTextBoxByID("Password", userInfo.getPassword());
//        registerPage.enterToTextBoxByID("ConfirmPassword", userInfo.getPassword());

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
