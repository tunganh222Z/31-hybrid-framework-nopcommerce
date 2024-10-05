package commons;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    WebDriver driver;

    // thằng này chứa các hàm dùng chung khi test

    protected WebDriver getBrowserDriver(String browserName, String url){
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        if (browser == BrowserList.FIREFOX){
            driver = new FirefoxDriver();
        } else if (browser == BrowserList.CHROME){
            driver = new ChromeDriver();
        } else if (browser == BrowserList.EDGE) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name is not valid");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /* setSize để test reponsive cũng được
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(720,720));
        */
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    protected String getEmailRandom() {
        return "tunganh97tuaf" + new Random().nextInt(9999) + "@gmail.com";
    }

    protected void closeBrowser(){
        if (!(driver == null)){
            driver.quit();
        }
    }

    protected boolean verifyTrue(boolean condition){
        boolean status = true;
        try{
            Assert.assertTrue(condition);
        } catch (Throwable e) { // Phải dùng Throwable thì sẽ không dùng lại, Exception sẽ dừng lại khi không thỏa mãn
            status = false;

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected Boolean verifyFalse(boolean condition){
        boolean status = true;
        try{
            Assert.assertFalse(condition);
        } catch (Throwable e) { // Phải dùng Throwable thì sẽ không dùng lại, Exception sẽ dừng lại khi không thỏa mãn
            status = false;

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected boolean verifyEqual(Object actual, Object expected){
        boolean status = true;
        try{
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) { // Phải dùng Throwable thì sẽ không dùng lại, Exception sẽ dừng lại khi không thỏa mãn
            status = false;

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
}
