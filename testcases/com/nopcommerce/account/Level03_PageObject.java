package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.user.CustomerPageObject;
import pageObjects.nopcommerce.user.HomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.RegisterPageObject;

import java.time.Duration;
import java.util.Random;

public class Level03_PageObject {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerPageObject customerPage;
    private UserLoginPageObject loginPage;
    private String emailAddress = getEmailRandom();

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("http://localhost/");
        // Mở ra URL page nào -> khởi tạo nó lên
        // Từ 1 page này chuyển qua page kia -> Khở tạo page đó lên
        homePage = new HomePageObject(driver);
    }

    @Test
    public void User_01_Register_Empty_Data() {
        homePage.clickToRegisterLink();
        // Từ homepage click registerLink > RegisterPage
        registerPage = new RegisterPageObject(driver);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Email is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "Password is required.");
    }

    @Test
    public void User_02_Register_Invalid_Email() {
        // step cuối cùng của tc01 đang nằm ở registerPage
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

        loginPage = new UserLoginPageObject(driver);

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

    public String getEmailRandom() {
        return "tunganh97tuaf" + new Random().nextInt(9999) + "@gmail.com";
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
