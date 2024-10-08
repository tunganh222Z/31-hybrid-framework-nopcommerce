package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGenratorManager;
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

public class Level21_Pattern_Object extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerPageObject customerPage;
    private UserLoginPageObject loginPage;
    private String emailAddress = getEmailRandom();
    private String adminURL, userURL;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;


    @Parameters({"browser", "adminURL", "userURL"})
    @BeforeClass
    public void beforeClass(String browserName, String adminURL, String userURL) {
        driver = getBrowserDriver(browserName,userURL);

        this.adminURL = adminURL;
        this.userURL = userURL;

       homePage = PageGenratorManager.getHomePage(driver);
        // Mở ra URL page nào -> khởi tạo nó lên
        // Từ 1 page này chuyển qua page kia -> Khở tạo page đó lên

    }

    @Test
    public void User_01_Register_Empty_Data() {

        homePage.clickToHeaderLinksByName("Register");
        registerPage = new RegisterPageObject(driver);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorMsgByID("FirstName"), "First name is required.");
        Assert.assertEquals(registerPage.getErrorMsgByID("LastName"), "Last name is required.");
        Assert.assertEquals(registerPage.getErrorMsgByID("Email"), "Email is required.");
        Assert.assertEquals(registerPage.getErrorMsgByID("ConfirmPassword"), "Password is required.");

    }

    @Test
    public void User_02_Register_Invalid_Email() {
        // step cuối cùng của tc01 đang nằm ở registerPage
        homePage = registerPage.clickToNopcommerceLogo();

        homePage.clickToHeaderLinksByName("Register");
        registerPage = new RegisterPageObject(driver);

        registerPage.enterToTextBoxByID("FirstName", "Tung");
        registerPage.enterToTextBoxByID("LastName", "Anh");
        registerPage.enterToTextBoxByID("Email", "tunganh@gmail#com");
        registerPage.enterToTextBoxByID("Password", "123tunganh");
        registerPage.enterToTextBoxByID("ConfirmPassword", "123tunganh");

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getErrorMsgByID("Email"), "Please enter a valid email address.");
    }

    @Test
    public void User_03_Register_Invalid_Password() {
        homePage = registerPage.clickToNopcommerceLogo();

        homePage.clickToHeaderLinksByName("Register");
        registerPage = new RegisterPageObject(driver);

        registerPage.enterToTextBoxByID("FirstName", "Tung");
        registerPage.enterToTextBoxByID("LastName", "Anh");
        registerPage.enterToTextBoxByID("Email", "tunganh@gmail.com");
        registerPage.enterToTextBoxByID("Password", "123");
        registerPage.enterToTextBoxByID("ConfirmPassword", "123");

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getPasswordErrorMsgText(), "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");

    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Password() {
        homePage = registerPage.clickToNopcommerceLogo();

        homePage.clickToHeaderLinksByName("Register");
        registerPage = new RegisterPageObject(driver);

        registerPage.enterToTextBoxByID("FirstName", "Tung");
        registerPage.enterToTextBoxByID("LastName", "Anh");
        registerPage.enterToTextBoxByID("Email", "tunganh@gmail#com");
        registerPage.enterToTextBoxByID("Password", "123tunganh");
        registerPage.enterToTextBoxByID("ConfirmPassword", "1243tunganh");

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getErrorMsgByID("ConfirmPassword"), "The password and confirmation password do not match.");

    }

    @Test
    public void User_05_Register_Success() {
        homePage = registerPage.clickToNopcommerceLogo();

        homePage.clickToHeaderLinksByName("Register");
        registerPage = new RegisterPageObject(driver);

        registerPage.enterToTextBoxByID("FirstName", "Tung");
        registerPage.enterToTextBoxByID("LastName", "Anh");
        registerPage.enterToTextBoxByID("Email", emailAddress);
        registerPage.enterToTextBoxByID("Password", "123tunganh");
        registerPage.enterToTextBoxByID("ConfirmPassword", "123tunganh");

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getRegistrationCompletedMsg(), "Your registration completed");


    }

    @Test
    public void User_06_Login_Success() {
        registerPage.clickToHeaderLinksByName("Log out");

        homePage = new HomePageObject(driver);

        homePage.clickToHeaderLinksByName("Log in");
        loginPage = new UserLoginPageObject(driver);


        loginPage.enterToTextBoxByID("Email",emailAddress);
        loginPage.enterToTextBoxByID("Password","123tunganh");

        loginPage.clickToButtonByText("Log in");
        homePage = new HomePageObject(driver);
        // valid data login > login success > Homepage

        homePage.clickToHeaderLinksByName("My account");
        customerPage = new CustomerPageObject(driver);
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
