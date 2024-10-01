package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.factory.CustomerPageObject;
import pageObject.factory.HomePageObject;
import pageObject.factory.LoginPageObject;
import pageObject.factory.RegisterPageObject;
import pageObjects.nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;

public class Level06_Selenium_Page_Factory extends BaseTest {
    WebDriver driver;
    private pageObject.factory.HomePageObject homePage;
    private pageObject.factory.RegisterPageObject registerPage;
    private pageObject.factory.CustomerPageObject customerPage;
    private pageObject.factory.LoginPageObject loginPage;
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

        homePage = new HomePageObject(driver);
    }

    @Test
    public void User_01_Register_Empty_Data() {
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Email is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "Password is required.");
    }

    @Test
    public void User_02_Register_Invalid_Email() {

        registerPage.clickToNopcommerceLogo();
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextBox("Tung");
        registerPage.enterToLastNameTextBox("Anh");
        registerPage.enterToEmailTextBox("tunganh@gmail@com");
        registerPage.enterToPasswordTextBox("123");
        registerPage.enterToConfirmPasswordTextBox("123");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Please enter a valid email address.");
    }

    @Test
    public void User_03_Register_Invalid_Password() {
        registerPage.clickToNopcommerceLogo();
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextBox("Tung");
        registerPage.enterToLastNameTextBox("Anh");
        registerPage.enterToEmailTextBox("tunganh@gmail.com");
        registerPage.enterToPasswordTextBox("123");
        registerPage.enterToConfirmPasswordTextBox("123");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getPasswordErrorMsgText(), "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");

    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Password() {
        registerPage.clickToNopcommerceLogo();
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextBox("Tung");
        registerPage.enterToLastNameTextBox("Anh");
        registerPage.enterToEmailTextBox("tunganh@gmail.com");
        registerPage.enterToPasswordTextBox("123tunganh");
        registerPage.enterToConfirmPasswordTextBox("1234tunganh13123");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "The password and confirmation password do not match.");

    }

    @Test
    public void User_05_Register_Success() {
        registerPage.clickToNopcommerceLogo();
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextBox("Tung");
        registerPage.enterToLastNameTextBox("Anh");
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToPasswordTextBox("123tunganh");
        registerPage.enterToConfirmPasswordTextBox("123tunganh");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegistrationCompletedMsg(), "Your registration completed");


    }

    @Test
    public void User_06_Login_Success() {
        registerPage.clickToLogOutLink();

        homePage = new HomePageObject(driver);
        homePage.clickToLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox("123tunganh");
        loginPage.clickToLoginButton();
        // valid data login > login success > Homepage
        homePage = new HomePageObject(driver);
        homePage.clickToMyAccountLink();
        // -> Customer page
        customerPage = new CustomerPageObject(driver);

        //verify
        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "Tung");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "Anh");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);


    }



    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

}
