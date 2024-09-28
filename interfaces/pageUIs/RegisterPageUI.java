package pageUIs;

public class RegisterPageUI {
    // define duy nhất 1 lần ở đây không trùng lặp chỗ khác
    // màn hình nào quản lý element riêng của màn hình đó không liên quan thằng khác
    public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
    public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
    public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
    public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
    public static final String REGISTER_BUTTON = "//button[@id='register-button']";
    public static final String FIRSTNAME_ERROR_MSG = "//span[@id='FirstName-error']";
    public static final String LASTNAME_ERROR_MSG = "//span[@id='LastName-error']";
    public static final String EMAIL_ERROR_MSG = "//span[@id='Email-error']";
    public static final String PASSWORD_ERROR_MSG = "//span[@class='field-validation-error']";
    public static final String CONFIRM_PASSWORD_MSG = "//span[@id='ConfirmPassword-error']";
    public static final String REGISTRATION_COMPLETED_MSG = "//div[@class='result']";
    public static final String NOPCOMMERCE_LOGO = "//img[@alt='Your store name']";
    public static final String LOGOUT_LINK ="//a[@class='ico-logout']";

}
