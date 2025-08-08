package org.example.pages.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage_POM {

    private WebDriver driver;

    // Locator for a known element on dashboard
    private By dashboardHeader = By.cssSelector("h1.page-heading"); // update selector based on actual UI

    public DashboardPage_POM(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardLoaded() {
        return driver.findElement(dashboardHeader).isDisplayed();
    }
}
