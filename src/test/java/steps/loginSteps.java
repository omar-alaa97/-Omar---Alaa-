package steps;

import com.facebook.base.Base;
import com.facebook.pages.HomePage;
import com.facebook.pages.LoginPage;
import com.facebook.pages.LoginValidationsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import org.junit.Assert;

public class loginSteps extends Base {

    LoginPage loginPage;
    HomePage homePage;
    LoginValidationsPage loginValidationsPage;

@Given("User open the website on login page")
    public void openLoginPage(){
    initialization();
    driver.get(props.getProperty("url"));
    loginPage=new LoginPage(driver);
}
@When("User enter valid credentials email & password")
    public void enterValidCredentials(DataTable dataTable){
    homePage = loginPage.enterValidCredentials(dataTable.cell(0,0), dataTable.cell(0,1));

}

@Then("The user should be logged in")
    public void checkLoginStatus(){
    Assert.assertTrue(homePage.getWelcomeMessage().contains("Welcome"));
}

@When("User click login button with empty or  wrong {string} & correct {string}")
public void verifyEmailValidationMessage (String email,String password){
   loginValidationsPage= loginPage.verifyValidations(email,password);
}
@Then("A validation message should appear for email field")
    public void checkEmailValidationMessage(){
Assert.assertTrue(loginValidationsPage.checkEmailValidationMessage());
    }

    @When("User enter valid {string} & invalid  or empty {string}")
    public void VerifyPasswordValidationMessage(String email,String password){
      loginValidationsPage=  loginPage.verifyValidations(email,password);
    }
    @Then("A password error message should appear")
    public void checkPasswordValidationMessage(){
        Assert.assertTrue(loginValidationsPage.checkPasswordValidationMessage());
}

    @When("User enter empty email & password")
    public void VerifyEmptyEmailValidationMessage(DataTable dataTable){
        loginValidationsPage=  loginPage.verifyValidations(dataTable.cell(0,0), dataTable.cell(0,1));
    }
    @Then("The user should an email validation message")
    public void checkEmptyEmailValidationMessage(){
        Assert.assertTrue(loginValidationsPage.checkPasswordValidationMessage());
    }
}
