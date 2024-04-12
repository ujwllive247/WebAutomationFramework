package org.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVwoLogin {

    @Test
    public void TestVwologin(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

    }
}
