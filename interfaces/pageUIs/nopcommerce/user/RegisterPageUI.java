package pageUIs.nopcommerce.user;

public class RegisterPageUI {
    // define duy nhất 1 lần ở đây không trùng lặp chỗ khác
    // màn hình nào quản lý element riêng của màn hình đó không liên quan thằng khác
    public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@id='FirstName']";
    public static final String LASTNAME_TEXTBOX = "xpath=//input[@id='LastName']";
    public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
    public static final String CONFIRM_PASSWORD_TEXTBOX = "xpath=//input[@id='ConfirmPassword']";
    public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
    public static final String FIRSTNAME_ERROR_MSG = "xpath=//span[@id='FirstName-error']";
    public static final String LASTNAME_ERROR_MSG = "xpath=//span[@id='LastName-error']";
    public static final String EMAIL_ERROR_MSG = "xpath=//span[@id='Email-error']";
    public static final String PASSWORD_ERROR_MSG = "xpath=//span[@class='field-validation-error']";
    public static final String CONFIRM_PASSWORD_MSG = "xpath=//span[@id='ConfirmPassword-error']";
    public static final String REGISTRATION_COMPLETED_MSG = "xpath=//div[@class='result']";

    public static final String LOGOUT_LINK ="xpath=//a[@class='ico-logout']";

}
