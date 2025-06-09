package com.thetestingacademy.tests.dryRun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class DryRun {

    @Test
    public void test_DryRun(){

        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
    }
}
