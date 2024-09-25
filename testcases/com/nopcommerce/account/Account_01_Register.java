package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Account_01_Register {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void Register_01_Empty_Data(){

    }
    @Test
    public void Register_02_Invalid_Email(){

    }
    @Test
    public void Register_03_Invalid_Password(){

    }
    @Test
    public void Register_04_Incorrect_Confirm_Password(){

    }
    @Test
    public void Register_05_Success(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
