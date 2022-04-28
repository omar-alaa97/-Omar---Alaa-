package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By welcomeMessage= By.xpath("//span[contains(text(),'Welcome to Facebook')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeMessage(){
        return driver.findElement(welcomeMessage).getText();
    }
}
