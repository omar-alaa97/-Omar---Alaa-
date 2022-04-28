package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    private WebDriver driver;
    private boolean alertExist;
    private By registrationLink = By.partialLinkText("Create New Account");
    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By logInButton = By.name("login");
    private By createAccountButton = By.xpath("//a[@data-testid='open-registration-form-button']");
    private By firstName = By.name("firstname");
    private By lastname = By.name("lastname");
    private By regEmailConfirmation = By.name("reg_email_confirmation__");
    private By reg_email = By.name("reg_email__");
    private By newPassword = By.id("password_step_input");
    private By day_DateOfBirth = By.id("day");
    private By month_DateOfBirth = By.id("month");
    private By year_DateOfBirth = By.id("year");
    private By signUpButton = By.name("websubmit");
    private By alertIcon = By.xpath("//i[contains(@class, 'sx_54513f')]");
    private By dateOfBirthTitle = By.xpath("//div[contains(text(),'Date of birth')]");
    private By genderTitle = By.xpath("//div[contains(text(),'Gender')]");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage enterValidCredentials(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(logInButton).click();
        return new HomePage(driver);
    }

    public LoginValidationsPage verifyValidations(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(logInButton).click();
        return new LoginValidationsPage(driver);
    }

    public void openRegisterWindow() {
        driver.findElement(createAccountButton).click();
    }

    public MoreInfoPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new MoreInfoPage(driver);
    }

    public void fillRegisterForm(String first_Name, String last_Name, String reg_mail, String pass,String day,String month,String year ,String egender) {
        Select dayList = new Select(driver.findElement(day_DateOfBirth));
        Select monthList = new Select(driver.findElement(month_DateOfBirth));
        Select yearList = new Select(driver.findElement(year_DateOfBirth));
        driver.findElement(firstName).sendKeys(first_Name);
        driver.findElement(lastname).sendKeys(last_Name);
        driver.findElement(reg_email).sendKeys(reg_mail);
        driver.findElement(regEmailConfirmation).sendKeys(reg_mail);
        driver.findElement(newPassword).sendKeys(pass);
        dayList.selectByValue(day);
        monthList.selectByValue(month);
        yearList.selectByValue(year);
        driver.findElement(By.xpath("//label[text()='"+ egender + "']")).click();
    }
    public Boolean firstnameAlert(){
        return driver.findElement(firstName).findElement(alertIcon).isEnabled();
    }
    public Boolean lastNameAlert(){
        return driver.findElement(lastname).findElement(alertIcon).isDisplayed();
    }
    public Boolean emailAlert(){
        return driver.findElement(reg_email).findElement(alertIcon).isDisplayed();
    }
    public Boolean dateAlert(){
        return driver.findElement(dateOfBirthTitle).findElement(alertIcon).isDisplayed();
    }
    public Boolean genderAlert(){
        return driver.findElement(genderTitle).findElement(alertIcon).isDisplayed();
    }

    public void fillEmail(String mail){
        driver.findElement(reg_email).sendKeys(mail);
    }

    public Boolean checkEmailConfirmationField(){
        return driver.findElement(regEmailConfirmation).isDisplayed();
    }
}
