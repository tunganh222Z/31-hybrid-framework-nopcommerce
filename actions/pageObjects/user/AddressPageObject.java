package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class AddressPageObject extends MyAccountSideBarPageObject{
    WebDriver driverPageObject;

    public AddressPageObject(WebDriver driverPageObject) {
        super(driverPageObject);
        this.driverPageObject = driverPageObject;
    }
}
