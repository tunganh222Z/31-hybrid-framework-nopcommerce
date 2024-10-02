package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

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


    public List<String> getAllPageValueByColumnName(String columnName) {
        List<String> allValues = new ArrayList<String>();

        waitForListElementsVisible(driverPageObject, HomePageUI.ALL_PAGE_LINKS);

        List<WebElement> allPageLinks = getListWebElements(driverPageObject, HomePageUI.ALL_PAGE_LINKS);

        int getIndexByRowName = getListElementsSize(driverPageObject, HomePageUI.COLUMN_INDEX_BY_NAME,columnName) + 1;


        for (WebElement pageLink : allPageLinks){
            List<WebElement> rowsByIndex = getListWebElements(driverPageObject, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, String.valueOf(getIndexByRowName));
            for (WebElement rowByIndex : rowsByIndex){
                allValues.add(rowByIndex.getText());
            }
            pageLink.click();
        }
        //sort ASC / DESC
        return allValues;
        }

    public void enterToTextBoxByColumnNameAndRowIndex(String columnName, String rowIndex, String keyToSend) {
        List<WebElement> getIndexByColumnName = getListWebElements(driverPageObject, HomePageUI.COLUMN_INDEX_BY_NAME_2, columnName);
        int index = getIndexByColumnName.size() +1 ;

        sendkeyToElement(driverPageObject, HomePageUI.TEXT_BOX_BY_INDEX, keyToSend, String.valueOf(index), rowIndex);

    }

    public void selectDropdownAndRowIndex(String columnName, String itemValue, String rowIndex) {
        int index = getListElementsSize(driverPageObject, HomePageUI.COLUMN_INDEX_BY_NAME_2, columnName) + 1;
        waitForElementClickable(driverPageObject, HomePageUI.DROPDOWN_BY_INDEX, String.valueOf(index), rowIndex);
        selectItemInDefaultDropdown(driverPageObject, HomePageUI.DROPDOWN_BY_INDEX, itemValue, String.valueOf(index), rowIndex);
    }
}
