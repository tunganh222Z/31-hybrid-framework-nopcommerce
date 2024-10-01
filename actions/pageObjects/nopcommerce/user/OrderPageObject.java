package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

public class OrderPageObject extends MyAccountSideBarPageObject{
    WebDriver driverPageObject;

    public OrderPageObject(WebDriver driverPageObject) {
        super(driverPageObject);
        this.driverPageObject = driverPageObject;
    }
}
