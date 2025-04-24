package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.pages.signIn.SignInPage;
import utils.DriverHelper;


public class SingInSteps {
    WebDriver driver = DriverHelper.getDriver();
    SignInPage signInPage = new SignInPage(driver);

    @Given("User is on the Sign-In page")
    public void user_is_on_the_sign_in_page() {
     signInPage.clickSignInButton();
    }

    @When("User enters a valid {string} and  valid {string}")
    public void user_enters_a_valid_and_valid(String email, String password) {
      signInPage.enterEmail(email);
      signInPage.enterPassword(password);
    }
    @When("User enters a invalid {string} and  invalid {string}")
    public void user_enters_a_invalid_and_invalid(String email, String password) {
       signInPage.enterInvalidCredentials(email, password);
    }

    @When("User clicks the Sign In button")
    public void user_clicks_the_sign_in_button() {
        signInPage.clickLoginButton();

    }

    @When("User enters clicks Forgot Pasword link")
    public void user_enters_clicks_forgot_pasword_link() {
        signInPage.clickForgotPasswordLink();
    }

    @When("User enters {string} and clicks send button")
    public void user_enters_and_clicks_send_button(String email) {
            signInPage.enterEmailForForgotPassword(email);
    }

    @Then("User validates logotype")
    public void user_validates_logotype() {
        signInPage.validateMessage("Logotype");

    }
    @Then("User validates not signed in")
    public void user_validates_not_signed_in() {
      signInPage.validateUserIsNotSignedIn(driver);
    }


}
