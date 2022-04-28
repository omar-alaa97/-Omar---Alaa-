package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MoreInfoPage {

    private WebDriver driver;
    private By messgae = By.xpath("//span[contains(text(),' We need more information')]");


    public MoreInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkRegisterSuccess(){

        return driver.findElement(messgae).isDisplayed();
    }


}
