package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    // Hàm dùng để làm gì
    // Dùng hàm nào của Selenium
    // Kiểu trả về của hàm đó
    // Các hàm tương tác thì hầu như là void .click, .sendkeys, .accept, .cancel , ...
    // Các hàm để lấy dữ liệu ra thì hầu như là String, int, WebElement, List<WebElement>. Hầu hết là String
    // Tên hàm đặt theo tiêu chuẩn camelCase
    // Có tham số hay không tùy vào chức năng cần viết
    // Kiểu dữ liệu trả về cho hàm


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


    public Alert waitForAlertPresence(WebDriver driver) {
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

    public void sleepInSecond(long timeSleep) {
        try {
            Thread.sleep(timeSleep * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public Set<Cookie> getBrowserCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void setCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public void deleteCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    /* WebElement */
    // driver.findelement(By.xpath()) đang bị lặp lại

    public By getByXpath(String xpathExpression) {
        return By.xpath(xpathExpression);
    }

    public WebElement getWebElement(WebDriver driver, String xpathExpression) {
        return driver.findElement(getByXpath(xpathExpression));
    }

    public List<WebElement> getListWebElements(WebDriver driver, String xpathExpression) {
        return driver.findElements(getByXpath(xpathExpression));
    }

    public int getListElementsSize(WebDriver driver, String xpathExpression) {
        return getListWebElements(driver, xpathExpression).size();
    }

    public void clickToElement(WebDriver driver, String xpathExpression) {
        getWebElement(driver, xpathExpression).click();
    }

    public void sendkeyToElement(WebDriver driver, String xpathExpression, String keysToSend) {
        getWebElement(driver, xpathExpression).clear();
        getWebElement(driver, xpathExpression).sendKeys(keysToSend);
    }

    //Default dropdown

    public void selectItemInDefaultDropdown(WebDriver driver, String xpathExpression, String itemValue) {
        new Select(getWebElement(driver, xpathExpression)).selectByVisibleText(itemValue);
    }

    public String getFirstSelectedTextInDefaultDropdown(WebDriver driver, String xpathExpression) {
        return new Select(getWebElement(driver, xpathExpression)).getFirstSelectedOption().getText();
    }

    public boolean isDefaultDropdownMultiple(WebDriver driver, String xpathExpression) {
        return new Select(getWebElement(driver, xpathExpression)).isMultiple();
    }

    //Custom dropdown
    public void selectItemInCustomDropdown(WebDriver driver, String parentXpathExpression, String childXpathExpression, String expectedText) {
        getWebElement(driver, parentXpathExpression).click();
        sleepInSecond(1);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpathExpression)));
        for (WebElement Item : getListWebElements(driver, childXpathExpression)) {
            if (Item.getText().equals(expectedText)) {
                Item.click();
                break;
            }
        }
    }

    public String getWebElementText(WebDriver driver, String xpathExpression) {
        return getWebElement(driver, xpathExpression).getText();
    }

    public String getWebElementAttribute(WebDriver driver, String xpathExpression, String attributeName) {
        return getWebElement(driver, xpathExpression).getAttribute(attributeName);
    }

    public String getWebElementCssValue(WebDriver driver, String xpathExpression, String cssPropertyName) {
        return getWebElement(driver, xpathExpression).getCssValue(cssPropertyName);
    }

    public String convertRGBAToHexColor(WebDriver driver, String xpathExpression) {
        return Color.fromString(getWebElementCssValue(driver, xpathExpression, "background-color")).asHex();
    }

    // Radio button / checkbox

    /**
     * Apply for checkbox and radio button
     *
     * @param driver
     * @param xpathExpression
     */
    public void checkToELement(WebDriver driver, String xpathExpression) {
        if (!getWebElement(driver, xpathExpression).isSelected()) {
            getWebElement(driver, xpathExpression).click();
        }
    }

    /**
     * Only apply for checkbox
     *
     * @param driver
     * @param xpathExpression
     */
    public void uncheckToElement(WebDriver driver, String xpathExpression) {
        if (getWebElement(driver, xpathExpression).isSelected()) {
            getWebElement(driver, xpathExpression).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String xpathExpression) {
        return getWebElement(driver, xpathExpression).isDisplayed();
    }

    public boolean isElementSelected(WebDriver driver, String xpathExpression) {
        return getWebElement(driver, xpathExpression).isSelected();
    }

    public boolean isElementEnabled(WebDriver driver, String xpathExpression) {
        return getWebElement(driver, xpathExpression).isEnabled();
    }

    // Frame / iFrame

    public void switchToiFrame(WebDriver driver, String xpathExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByXpath(xpathExpression)));
    }

    public void switchBackParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //Actions
    public void hoverToElement(WebDriver driver, String xpathExpression) {
        new Actions(driver).moveToElement(getWebElement(driver, xpathExpression)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String xpathExpression) {
        new Actions(driver).doubleClick(getWebElement(driver, xpathExpression)).perform();
    }

    public void rightClickToElement(WebDriver driver, String xpathExpression) {
        new Actions(driver).contextClick(getWebElement(driver, xpathExpression)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String xpathExpressionSource, String xpathExpressionTarget) {
        new Actions(driver).dragAndDrop(getWebElement(driver, xpathExpressionSource), getWebElement(driver, xpathExpressionTarget)).perform();
    }

    public void sendKeyBoardToElement(WebDriver driver, String xpathExpression, Keys key) {
        new Actions(driver).sendKeys(getWebElement(driver, xpathExpression), key);
    }

    public Object executeForBrowser(WebDriver driver, String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(WebDriver driver, String textExpected) {
        String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(WebDriver driver, String xpathExpression) {
        WebElement element = getWebElement(driver, xpathExpression);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String xpathExpression) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, xpathExpression));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(WebDriver driver, String xpathExpression) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathExpression));
    }

    public void scrollToElementOnDown(WebDriver driver, String xpathExpression) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, xpathExpression));
    }

    public void setAttributeInDOM(WebDriver driver, String xpathExpression, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, xpathExpression));
    }

    public void removeAttributeInDOM(WebDriver driver, String xpathExpression, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathExpression));
    }

    public void sendkeyToElementByJS(WebDriver driver, String xpathExpression, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, xpathExpression));
    }

    public String getAttributeInDOM(WebDriver driver, String xpathExpression, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, xpathExpression));
    }

    public String getWebElementValidationMessage(WebDriver driver, String xpathExpression) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathExpression));
    }

    public boolean isImageLoaded(WebDriver driver, String xpathExpression) {
        boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, xpathExpression));
        return status;
    }

    public void waitForElementVisible(WebDriver driver, String xpathExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathExpression)));
    }

    public void waitForListElementsVisible(WebDriver driver, String xpathExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathExpression)));
    }

    public void waitForElementInvisible(WebDriver driver, String xpathExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathExpression)));
    }

    public void waitForListElementsInvisible(WebDriver driver, String xpathExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, xpathExpression)));
    }

    public void waitForElementClickable(WebDriver driver, String xpathExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getByXpath(xpathExpression)));
    }

}























