package org.example.tests;

import org.example.pages.PageObjectModel.LoginPage_POM;
import org.example.pages.PageObjectModel.DashboardPage_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DashboardTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://app.vwo.com");
    }

    @Test
    public void testDashboardAfterLogin() {
        LoginPage_POM loginPage = new LoginPage_POM(driver);
        loginPage.login("validUsername", "validPassword");

        DashboardPage_POM dashboardPage = new DashboardPage_POM(driver);
        Assert.assertTrue(dashboardPage.isDashboardLoaded(), "Dashboard did not load successfully!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
