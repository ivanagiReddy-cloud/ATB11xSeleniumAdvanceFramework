package com.thetestingacademy.tests.pageObjectModel.orangeHRM;

import com.thetestingacademy.base.Test_CommonToALL;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.listeners.RetryAnalyzer;
import com.thetestingacademy.pages.DashBoardPage;
import com.thetestingacademy.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class Test_DahsBoard extends Test_CommonToALL {

    private WebDriver driver;
    private DashBoardPage dashBoardPage;
    private LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(Test_DahsBoard.class);

    public void setUpTest() {
        driver = DriverManager.getDriver();
        dashBoardPage = new DashBoardPage(driver);
        loginPage = new LoginPage(driver);

    }


    public void test_VerifyPIModule() {


    }


}
