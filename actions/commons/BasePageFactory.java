package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageFactory {

    public void sendKeyToElement (WebDriver driver, WebElement element, String keyToSend){
        element.clear();
        element.sendKeys(keyToSend);
    }

    public void clickToElement (WebDriver driver, WebElement element){
        element.click();
    }

    public String getTextElement (WebDriver driver, WebElement element){
        return element.getText();
    }

    public String getElementAttribute (WebDriver driver, WebElement element, String attribute){
        return element.getAttribute(attribute);
    }

    public void waitForElementClickable (WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisible (WebDriver driver, WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
    }
}
