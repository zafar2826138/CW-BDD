package pages.pages.signUp;

import com.github.javafaker.Faker;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.SeleniumUtils;


public class SignUpPage {
    Faker faker = new Faker();
    String companyName = faker.company().name();

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButtonBase-root css-k6k41x']")
    WebElement signUpButton;

    @FindBy(css = "#email_input_text")
    WebElement email;

    @FindBy(css = "#password_input_text")
    WebElement password;

    @FindBy(css = "#repeat_password_input_text")
    WebElement passwordConfirm;

    @FindBy(xpath = "//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth MuiButtonBase-root css-1hz3hle']")
    WebElement continueButton;

    @FindBy(css = "#first_name_input_text")
    WebElement name;

    @FindBy(css = "#last_name_input_text")
    WebElement lastName;

    @FindBy(css = "#company_name_input_text")
    WebElement nameOfBusiness;

    @FindBy(css = "#mui-component-select-business_area_id")
    WebElement selectAreaOfBusinessBox;

    @FindBy(xpath = "//li[@data-value='3']")
    WebElement areaOfBusinessIT;

    @FindBy(css = "#address_input_text")
    WebElement address;

    @FindBy(xpath = "//div[@id='mui-component-select-currency']")
    WebElement selectCurrencyButton;

    @FindBy(xpath = "//li[@data-value='USD']")
    WebElement USDcurrency;

    @FindBy(xpath = "//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth MuiButtonBase-root css-1hz3hle']")
    WebElement finalSignUpButton;

    @FindBy(xpath = "//*[@id=\"header\"]/h2")
    WebElement headerNameOfCompany;

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void sendEmailAndPasswordInfo() {

        email.sendKeys(faker.internet().emailAddress());
        password.sendKeys(ConfigReader.ReadProperty("cashwise_password"));
        passwordConfirm.sendKeys(ConfigReader.ReadProperty("cashwise_password"));
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void sendUserInfo(WebDriver driver) throws InterruptedException {

        name.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        nameOfBusiness.sendKeys(companyName);
        Actions actions = new Actions(driver);
        SeleniumUtils.waitForSec(1);
        actions.click(selectAreaOfBusinessBox).perform();
        actions.click(areaOfBusinessIT).perform();
        address.sendKeys(faker.address().fullAddress());
        selectCurrencyButton.click();
        SeleniumUtils.waitForSec(1);
        USDcurrency.click();
        SeleniumUtils.waitForSec(2);
        BrowserUtils.clickWithJS(driver, finalSignUpButton);
        SeleniumUtils.waitForSec(2);

    }

    public void validationOfClientInfo() {
        Assert.assertEquals(BrowserUtils.getText(headerNameOfCompany), companyName);
    }


}

