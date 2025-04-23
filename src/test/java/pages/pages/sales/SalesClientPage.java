package pages.pages.sales;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class SalesClientPage {
    public SalesClientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    Faker faker = new Faker();
    @FindBy(xpath = "//li[.='Sales']")
    WebElement salesTab;
    @FindBy(xpath = "//button[.='Add client']")
    WebElement addClientbutton;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/form/div[1]/div/div/div/div[1]")
    WebElement clientTag;
    @FindBy(css = "input[id=\"company_name_input_text\"]")
    WebElement clientCompanyName;
    @FindBy(id = "client_name_input_text")
    WebElement clientFullName;
    @FindBy(id = "email_input_text")
    WebElement clientEmail;
    @FindBy(id = "phone_number_input_text")
    WebElement clientPhoneNumber;
    @FindBy(id = "address_input_text")
    WebElement clientAddress;
    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    WebElement clientSaveButton;

    @FindBy(xpath = "//td[.='+1 993 331 1177']")
    WebElement clientNumber;
    @FindBy(xpath = "//td[8]/div/*")
    WebElement editClientIcon;
    @FindBy(xpath = "(//td[8]/div/button)[2]")
    WebElement clientArchiveButton;
    @FindBy(xpath = "//a[@href='/dashboard/sales/clients/archieved']")
    WebElement clientArchivedTab;
    @FindBy(xpath = "(//td)[6]")
    WebElement clientFromArchivedListData;
    @FindBy(xpath = "//div[@class=\"SnackbarContainer-top SnackbarContainer-right SnackbarContainer-root css-uwcd5u\"]")
    WebElement clientDuplicateMessage;
    public void clickSalesTab() {
        salesTab.click();
    }

    public void clickAddClientButton() throws InterruptedException {
        addClientbutton.click();
        Thread.sleep(2000);
    }

    public void fillAddClientForm(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.click(clientTag).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        // clientTag.sendKeys(Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER);
        clientCompanyName.sendKeys(faker.name().firstName());
        clientFullName.sendKeys(faker.name().fullName());
        clientEmail.sendKeys(faker.internet().emailAddress());
        clientPhoneNumber.sendKeys("19933311177");
        clientAddress.sendKeys(faker.address().fullAddress());
        clientSaveButton.click();
    }

    public void validateAddedClient() {
             Assert.assertEquals("+1 993 331 1177", BrowserUtils.getText(clientNumber));
    }

    public void clickEditClientIcon() {
        editClientIcon.click();

    }
    public void fillEditForm(){
        clientPhoneNumber.clear();
        clientPhoneNumber.sendKeys("9933311177");
        clientSaveButton.click();
    }
    public void validateChangesEditFormClient(){
        Assert.assertEquals("+1 993 331 1177", BrowserUtils.getText(clientNumber));
    }
    public void  clickClientArchiveButton(){
        clientArchiveButton.click();
    }
    public void  validateFromClientArchiedList(){
        clientArchivedTab.click();
        Assert.assertFalse(BrowserUtils.getText(clientFromArchivedListData).isEmpty());

    }
    public void fillAddClientDublicateForm(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.click(clientTag).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        // clientTag.sendKeys(Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER);
        clientCompanyName.sendKeys(faker.name().firstName());
        clientFullName.sendKeys(faker.name().fullName());
        clientEmail.sendKeys("candelaria.kovacek@yahoo.com");
        clientPhoneNumber.sendKeys("19933311177");
        clientAddress.sendKeys(faker.address().fullAddress());
        clientSaveButton.click();
    }
    public void validateDuplicateClient(){
        Assert.assertEquals("[\"Email already exists\"]", BrowserUtils.getText(clientDuplicateMessage) );
    }

}
