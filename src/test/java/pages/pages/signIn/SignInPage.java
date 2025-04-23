package pages.pages.signIn;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.ConfigReader;

public class SignInPage {
    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[.='Sign in']")
    WebElement signInButton;

    @FindBy(css = "#email_input_text")
    WebElement emailInput;

    @FindBy(css = "#password_input_text")
    WebElement passwordInput;

    @FindBy(xpath = "(//form)[2]//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(),'Forgot password?')]")
    WebElement forgotPasswordButton;

    @FindBy(xpath = "//input[@id='email_input_text']")
    WebElement emailBox;

    @FindBy(xpath = "//button[contains(text(),'Отправить')]")
    WebElement sendBox;

    @FindBy(xpath = "//p[contains(text(),'Logotype')]")
    WebElement header;

    public void clickSignInButton() {
        signInButton.click();
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(ConfigReader.ReadProperty("email"));
    }
    public void enterInvalidCredentials(String email, String passwod){
        emailInput.sendKeys("111111@mail.com");
        passwordInput.sendKeys("12345678");
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(ConfigReader.ReadProperty("password"));
    }

    public void clickLoginButton() {
        loginButton.click();
    }
    public void clickForgotPasswordLink(){
        forgotPasswordButton.click();
    }
    public void enterEmailForForgotPassword(String email){
        emailBox.sendKeys(ConfigReader.ReadProperty("email"));
        sendBox.click();
    }
    public void validateMessage(String expectedHeader){
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
    }
    public void validateUserIsNotSignedIn(WebDriver driver){
        Assert.assertEquals("https://cashwise.us/main?showLogin=true", driver.getCurrentUrl());
    }

}
