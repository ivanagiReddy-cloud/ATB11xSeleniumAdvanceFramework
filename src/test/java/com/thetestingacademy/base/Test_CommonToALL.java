package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Test_CommonToALL {


    @BeforeMethod
    public void setUp() {
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.down();
    }
}
