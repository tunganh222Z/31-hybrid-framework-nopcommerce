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
import pageObjects.nopcommerce.user.*;

public class Level15_Assert_Verify extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerPageObject customerPage;
    private UserLoginPageObject loginPage;
    private AddressPageObject addressPage;
    private RewardPointPageObject rewardPage;
    private OrderPageObject orderPage;
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

        registerPage = homePage.clickToRegisterLink();

        log.info("User_01_Register_Empty_Data - STEP 01: Open Register page");
        homePage.clickToRegisterLink();

        // Từ homepage click registerLink > RegisterPage
        registerPage = new RegisterPageObject(driver);

        log.info("User_01_Register_Empty_Data - STEP 02: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register_Empty_Data - STEP 03: Verify first name error msg");
        Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First NAME is required.");

        log.info("User_01_Register_Empty_Data - STEP 04: Verify LastName error msg");
        Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is requir3ed.");

        log.info("User_01_Register_Empty_Data - STEP 05: Verify Email error msg");
        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Email is required.");

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "Password is required.");


    }

    @Test
    public void User_02_Login_Success() {
        homePage = registerPage.clickToLogOutLink();

        loginPage = homePage.clickToLoginLink();


        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox("123tunganh");
        homePage = loginPage.clickToLoginButton();
        // valid data login > login success > Homepage
        customerPage = homePage.clickToMyAccountLink();
        // -> Customer page

        //verify
        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "Tung");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "Anh");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);
    }

    @Test
    public void User_03_Switch_Page(){
        // Các page này cùng kế thừa MyAccountSideBarPageObject
        // Cho nên khi switch case gọi như này sẽ không sai bussiness
        // nếu cố tình gọi sai thì trong quá trình compile code sẽ báo luôn
        // Customer Page -> Address page
        addressPage = (AddressPageObject) customerPage.openDynamicSideBar("Addresses");

        orderPage = (OrderPageObject) addressPage.openDynamicSideBar("Orders");

        addressPage = (AddressPageObject) orderPage.openDynamicSideBar("Addresses");

        customerPage = (CustomerPageObject) orderPage.openDynamicSideBar("Customer info");

        //orderPage = (OrderPageObject) customerPage.openDynamicSideBar("Orders");

    }

    @Test
    public void User_04_Switch_Page(){
        // Các page này cùng kế thừa MyAccountSideBarPageObject
        // Cho nên khi switch case gọi như này sẽ không sai bussiness
        // nếu cố tình gọi sai thì trong quá trình compile code sẽ báo luôn
        // Customer Page -> Address page
//        customerPage.openDynamicSideBarByName("Addresses");
//        addressPage = PageGenratorManager.getAddressPage(driver);
//
//        addressPage.openDynamicSideBarByName("Orders");
//        orderPage = PageGenratorManager.getOrderPage(driver);


    }



    @AfterClass
    public void afterClass() {
       // closeBrowser();
    }

}
