package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasePage {
    // Hàm dùng để làm gì
    // Dùng hàm nào của Selenium
    // Kiểu trả về của hàm đó
    // Các hàm tương tác thì hầu như là void .click, .sendkeys, .accept, .cancel , ...
    // Các hàm để lấy dữ liệu ra thì hầu như là String, int, WebElement, List<WebElement>. Hầu hết là String
    // Tên hàm đặt theo tiêu chuẩn camelCase
    // Có tham số hay không tùy vào chức năng cần viết
    // Kiểu dữ liệu trả về cho hàm
    public void clickToElement(WebDriver driver, String xpathExpression) {
        driver.findElement(By.xpath(xpathExpression)).click();
    }

    public String getElementText(WebDriver driver, String xpathExpression) {
        String elementText = driver.findElement(By.xpath(xpathExpression)).getText();
        return elementText;
    }

    public String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void sendkeyToElement(WebDriver driver, String xpathExpression, String value) {
        driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
    }

    public Alert waitForAlertPresence (WebDriver driver) {
       return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void cancelToAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public String getTextInAlert(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String keysToSend) {
        driver.switchTo().alert().sendKeys(keysToSend);
    }

    public void sleepInSecond (long timeSleep) {
        try {
            Thread.sleep(timeSleep * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }


}
