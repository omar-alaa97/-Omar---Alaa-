package steps;

import com.facebook.base.Base;
import com.facebook.pages.LoginPage;
import com.facebook.pages.MoreInfoPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class registerSteps extends Base {

    LoginPage loginPage;
    MoreInfoPage moreInfoPage;

    @Given("User open the website and open the register form")
    public void openRegisterForm(){
        initialization();

        driver.get(props.getProperty("url"));
        loginPage=new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("login")));
        loginPage.openRegisterWindow();
    }

    @When("User click submit without filling any fields")
    public void submitEmptyForm(){
        loginPage.clickSignUpButton();
    }

    @Then("a validation message appears for all required fields")
    public void verifyFieldsValidation(){
        Assert.assertTrue("FirstName doesn't have Validation",loginPage.firstnameAlert());
        Assert.assertTrue("LastName doesn't have Validation",loginPage.lastNameAlert());
        Assert.assertTrue("Email doesn't have Validation",loginPage.emailAlert());
        Assert.assertTrue("Date doesn't have Validation",loginPage.dateAlert());
        Assert.assertTrue("Gender doesn't have Validation",loginPage.genderAlert());
    }

    @When("User submit all required fields")
    public void fillRegisterForm(DataTable dataTable){
        loginPage.fillRegisterForm(dataTable.cell(0,0), dataTable.cell(0,1),
                dataTable.cell(0,2), dataTable.cell(0,3), dataTable.cell(0,4)
                , dataTable.cell(0,5), dataTable.cell(0,6),dataTable.cell(0,7) );
    }

    @Then("user should move to next step of register")
    public void nextPage(){
       moreInfoPage = loginPage.clickSignUpButton();
        Assert.assertTrue(moreInfoPage.checkRegisterSuccess());
    }

    @When("User fill email field with proper format")
    public void fillEmailWithValidFormat(DataTable dataTable){
        loginPage.fillEmail(dataTable.cell(0,0));
    }

    @Then("Email confirmation field appears")
    public void checkConfirmationField(){
        Assert.assertTrue(loginPage.checkEmailConfirmationField());
    }
}
