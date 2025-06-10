package com.thetestingacademy.pages;

import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //page Locators
    @FindBy(xpath = "//input[@name='username']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement login;
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    WebElement error_msg;
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement PIM;


//    private By username = By.xpath("//input[@name='username']");
//    private By password = By.xpath("//input[@name='password']");
//    private By login = By.xpath("//button[normalize-space()='Login']");
//    private By erro_msg = By.xpath("//p[text()='Invalid credentials']");


    //page Actions

    public String InvalidValidCredentials(String user, String pass) {

        driver.get(PropertiesReader.readKey("url"));
        WaitHelpers.waitExplicitWait(driver, username, 10);
        username.sendKeys(user);
        password.sendKeys(pass);
        login.click();

        WaitHelpers.waitExplicitWait(driver, error_msg, 5);
        String exp_Message = error_msg.getText();
        return exp_Message;

    }

    public void ValidCredentials(String user, String pass) {

        driver.get(PropertiesReader.readKey("url"));
        WaitHelpers.waitExplicitWait(driver, username, 10);
        username.sendKeys(user);
        password.sendKeys(pass);
        login.click();
        WaitHelpers.waitExplicitWait(driver, PIM, 5);

    }
}
