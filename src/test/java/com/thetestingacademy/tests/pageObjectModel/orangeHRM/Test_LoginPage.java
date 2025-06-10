package com.thetestingacademy.tests.pageObjectModel.orangeHRM;

import com.thetestingacademy.base.Test_CommonToALL;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test_LoginPage extends Test_CommonToALL {

    private WebDriver driver;
    private LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(Test_LoginPage.class);

    @BeforeMethod
    public void steupTest() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        logger.info("Driver initialized and LoginPage instantiated");
    }

    @Test
    public void test_InvalidLoginPage() {

        logger.info("Running test_InvalidLoginPage");

        String error = loginPage.InvalidValidCredentials(PropertiesReader.readKey("invalidUsername"), PropertiesReader.readKey("invalidPassword"));

        logger.info("Error Message Displayed:" + error);
        Assert.assertEquals(error, PropertiesReader.readKey("Actual_message"));
        logger.info("Assertion passed for invalid credentials.");
    }

    @Test
    public void test_ValidLoaginPage() {

        logger.info("Running test_ValidLoginPage");
        loginPage.ValidCredentials(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));
        Assert.assertTrue(driver.getCurrentUrl().contains(PropertiesReader.readKey("currenturlText")));
        logger.info("Cuurent URL contains text Matches with Actual text");
        logger.info("Assertion passed for valid credentials.");
    }
}
