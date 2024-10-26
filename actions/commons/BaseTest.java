package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;


public class BaseTest {
    WebDriver driver;
    protected final Logger log;

    public BaseTest(){
        log = LogManager.getLogger(getClass());
    }

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
        // getEnvironment by severName in xml combined with getUrlByServer
    protected WebDriver getBrowserEnvironment(String browserName, String serverName){
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
        driver.get(getUrlByServer(serverName));
        return driver;
    }

    private String getUrlByServer (String serverName){
        String url = null;
        ServerList server = ServerList.valueOf(serverName.toUpperCase());
        switch (server){
            case DEV:
                url = "https://dev.nopcommerce.com";
                break;

            case TEST:
                url = "https://test.nopcommerce.com";
                break;

            case STAGING:
                url = "https://staging.nopcommerce.com";
                break;

            default:
                new IllegalArgumentException("Unexpected value : " + serverName);
        }
        return url;
    }

    protected String getEmailRandom() {
        return "tunganh97tuaf" + new Random().nextInt(9999) + "@gmail.com";
    }

    protected void closeBrowser(){
        String cmd = null;
        try {
            String osName = GlobalConstant.OS_NAME.toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }
            // close browser
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            // quit driver
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean verifyTrue(boolean condition){
        boolean status = true;
        try{
            Assert.assertTrue(condition);
            log.info("------------Passed------------");
        } catch (Throwable e) { // Phải dùng Throwable thì sẽ không dùng lại, Exception sẽ dừng lại khi không thỏa mãn
            status = false;
            log.info("------------Fail------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected Boolean verifyFalse(boolean condition){
        boolean status = true;
        try{
            Assert.assertFalse(condition);
            log.info("------------Passed------------");
        } catch (Throwable e) { // Phải dùng Throwable thì sẽ không dùng lại, Exception sẽ dừng lại khi không thỏa mãn
            status = false;
            log.info("------------Fail------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected boolean verifyEqual(Object actual, Object expected){
        boolean status = true;
        try{
            Assert.assertEquals(actual, expected);
            log.info("------------Passed------------");
        } catch (Throwable e) { // Phải dùng Throwable thì sẽ không dùng lại, Exception sẽ dừng lại khi không thỏa mãn
            status = false;
            log.info("------------Fail------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
