package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginValidationsPage {

    private WebDriver driver;
    private By emailValidationMessage = By.xpath("//div[contains(text(),' connected to an account')]");
    private  By passwordValidationMessage=By.xpath("//div[contains(text(),'The password that ')]");

    public LoginValidationsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkEmailValidationMessage(){

        return driver.findElement(emailValidationMessage).isDisplayed();
    }

    public boolean checkPasswordValidationMessage(){
        return driver.findElement(passwordValidationMessage).isDisplayed();
    }
}
