package org.example.tests;

import org.example.pages.PageObjectModel.LoginPage_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestVwoLogin {

    WebDriver driver;
    LoginPage_POM loginPage;

    @BeforeMethod
    public void setup() {
        // Optional: Chrome headless mode for CI/CD
        ChromeOptions options = new ChromeOptions();
        // Comment out below line if you want GUI browser locally
        // options.addArguments("--headless=new");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.get("https://app.vwo.com");
        loginPage = new LoginPage_POM(driver);
    }

    @Test
    public void testVwoLogin_InvalidCredentials() {
        loginPage.enterUsername("invalid@example.com");
        loginPage.enterPassword("wrongPassword");
        loginPage.clickSignIn();

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Your email, password"),
                "Expected error message not found!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
