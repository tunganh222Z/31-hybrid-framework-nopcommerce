package com.nopcommerce.account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level02_BasePage_Static {
    WebDriver driver;
    // nên che giấu, không nên khởi tạo trực tiếp đối tượng ở trên class test ( Encapsulation )
    private BasePage basePage = BasePage.getBasePage();


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void Register_01_Empty_Data() {
        basePage.openPageURL(driver,"http://localhost/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getWebElementText(driver,"//span[@id='FirstName-error']"), "First name is required.");
        Assert.assertEquals(basePage.getWebElementText(driver,"//span[@id='LastName-error']"), "Last name is required.");
        Assert.assertEquals(basePage.getWebElementText(driver,"//span[@id='Email-error']"), "Email is required.");
        Assert.assertEquals(basePage.getWebElementText(driver,"//span[@id='ConfirmPassword-error']"), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        basePage.openPageURL(driver,"http://localhost/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Tung");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']", "Anh");
        basePage.sendkeyToElement(driver,"//input[@id='Email']", "tunganh@gmail@cus");
        basePage.sendkeyToElement(driver,"//input[@id='Password']", "123124214");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']", "123124214");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getWebElementText(driver,"//span[@id='Email-error']"), "Please enter a valid email address.");

    }

    @Test
    public void Register_03_Invalid_Password() {
        basePage.openPageURL(driver,"http://localhost/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Tung");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']", "Anh");
        basePage.sendkeyToElement(driver,"//input[@id='Email']", "tunganh97@gmail.com");
        basePage.sendkeyToElement(driver,"//input[@id='Password']", "123");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']", "123");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getWebElementText(driver, "//span[@class='field-validation-error']"), "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        basePage.openPageURL(driver,"http://localhost/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Tung");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']", "Anh");
        basePage.sendkeyToElement(driver,"//input[@id='Email']", "tunganh97@gmail.com");
        basePage.sendkeyToElement(driver,"//input[@id='Password']", "123");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']", "1235");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getWebElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
    }

    @Test
    public void Register_05_Success() {
        basePage.openPageURL(driver,"http://localhost/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Tung");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']", "Anh");
        basePage.sendkeyToElement(driver,"//input[@id='Email']", getEmailRandom());
        basePage.sendkeyToElement(driver,"//input[@id='Password']", "123tunganh");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']", "123tunganh");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getWebElementText(driver,"//div[@class='result']"), "Your registration completed");
    }

    public String getEmailRandom(){
        return "tunganh97tuaf" + new Random().nextInt(9999) + "@gmail.com";
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
