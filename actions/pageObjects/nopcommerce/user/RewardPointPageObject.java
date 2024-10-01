package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

public class RewardPointPageObject extends MyAccountSideBarPageObject{
    WebDriver driverPageObject;

    public RewardPointPageObject(WebDriver driverPageObject) {
        super(driverPageObject);
        this.driverPageObject = driverPageObject;
    }
}
