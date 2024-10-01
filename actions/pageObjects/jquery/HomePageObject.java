package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driverPageObject;

    public HomePageObject(WebDriver driver) {
        driverPageObject = driver;
    }

    public void sendKeyToColumnTextBox(String columnName, String keysToSend) {
        waitForElementVisible(driverPageObject, HomePageUI.DYNAMIC_COLUMN_TEXTBOX_BY_NAME, columnName);
        sendkeyToElement(driverPageObject, HomePageUI.DYNAMIC_COLUMN_TEXTBOX_BY_NAME, keysToSend, columnName);
    }

    public void clickToPageByNumber(String pageNumber) {
        waitForElementClickable(driverPageObject, HomePageUI.DYNAMIC_PAGINATION_BY_NUMBER, pageNumber);
        clickToElement(driverPageObject, HomePageUI.DYNAMIC_PAGINATION_BY_NUMBER, pageNumber);
    }

    public boolean isPageActiveByNumber(String pageNumber) {
        waitForElementVisible(driverPageObject, HomePageUI.DYNAMIC_PAGINATION_LINK_ACTIVE_BY_NUMBER, pageNumber);
        return isElementDisplayed(driverPageObject, HomePageUI.DYNAMIC_PAGINATION_LINK_ACTIVE_BY_NUMBER, pageNumber);
    }

    public boolean isRowValuesDisplayed (String femalesValue, String countryValue, String malesValue, String totalValue){
        waitForElementVisible(driverPageObject, HomePageUI.DYNAMIC_ROW_VALUES, femalesValue, countryValue, malesValue, totalValue);
        return isElementDisplayed(driverPageObject, HomePageUI.DYNAMIC_ROW_VALUES, femalesValue, countryValue, malesValue, totalValue);
    }
    
    public void clickToRowActionByCountry(String country, String rowAction){
        waitForElementClickable(driverPageObject, HomePageUI.DYNAMIC_ROW_ACTIONS, rowAction);
        clickToElement(driverPageObject, HomePageUI.DYNAMIC_ROW_ACTIONS, rowAction);
    }
}
