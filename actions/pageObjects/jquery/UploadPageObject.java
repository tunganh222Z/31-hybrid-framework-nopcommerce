package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.UploadPageUI;

import java.util.List;

public class UploadPageObject extends BasePage {
    WebDriver driverPageObject;

    public UploadPageObject(WebDriver driver){
        this.driverPageObject = driver;
    }

    public boolean isFileLoadedSuccess(String fileName) {
        waitForElementVisible(driverPageObject,UploadPageUI.FILE_LOADED_BY_NAME ,fileName);
        return isElementDisplayed(driverPageObject,UploadPageUI.FILE_LOADED_BY_NAME ,fileName);
    }

    public void clickStartButtonEachFile() {
        List<WebElement> startButtons = getListWebElements(driverPageObject, UploadPageUI.MULTIPLE_START_BUTTON);
        for (WebElement startButton : startButtons){
            clickToListElements(driverPageObject,startButton);
        }
    }

    public boolean isFileUploadedSuccess(String fileName) {
        waitForElementVisible(driverPageObject,UploadPageUI.FILE_UPLOADED_BY_NAME ,fileName);
        return isElementDisplayed(driverPageObject,UploadPageUI.FILE_UPLOADED_BY_NAME ,fileName);
    }
}
