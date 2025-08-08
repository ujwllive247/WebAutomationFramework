package org.example.pages.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_POM {

    private WebDriver driver;

    // Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");

    // Constructor
    public LoginPage_POM(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public void enterUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickSignIn() {
        driver.findElement(signButton).click();
    }


    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickSignIn();
    }
}
