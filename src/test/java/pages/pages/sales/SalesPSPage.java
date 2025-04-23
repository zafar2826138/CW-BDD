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

public class SalesPSPage {
    public SalesPSPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    Faker faker = new Faker();
    @FindBy(xpath = "(//a[.='Products and services'])[1]")
    WebElement productAndServicesLink;
    @FindBy(xpath = "//button[.='Add products or service']")
    WebElement addProductAndServicesButton;
    @FindBy(css = "#product_title_input_text")
    WebElement productAndServicesName;
    @FindBy(css = "#product_price_input_text")
    WebElement productAndServicesPrice;
    @FindBy(xpath = "//label[.='Select service type']")
    WebElement productAndServicesType;
    @FindBy(xpath = "//tr[1]/td[6]/div/button[1]")
    WebElement editIconPS;
    @FindBy(xpath = "//label[.='Select category income']")
    WebElement productAndServicesCategory;
    @FindBy(xpath = "//h3")
    WebElement productAndServicesHeader;
    @FindBy(css = "#product_description_input_text")
    WebElement productAndServicesDescription;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement productAndServicesSaveButton;
    @FindBy(xpath = "//tr[1]/td[6]/div/button[2]")
    WebElement deleteIconPS;
    @FindBy(xpath = "//div[.='[\"This name already exists\"]']")
    WebElement duplicateMessagePS;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div/div/div/div/div[.='Service  successfully created']")
    WebElement productAndServicesMessage;

    public void clickPSTab() {
        productAndServicesLink.click();
    }

    public void clickAddPSBUtton() {
        addProductAndServicesButton.click();
    }

    public void fillPSForm(WebDriver driver) throws InterruptedException {

        Actions actions = new Actions(driver);
        productAndServicesName.sendKeys(faker.name().name());
        productAndServicesPrice.sendKeys(faker.number().digit());
        actions.click(productAndServicesType).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        actions.click(productAndServicesCategory).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        productAndServicesDescription.sendKeys(faker.funnyName().name());
        productAndServicesSaveButton.click();

    }
    public void validatePSFromList(){
        Assert.assertEquals("Product and service", BrowserUtils.getText(productAndServicesHeader));
    }
    public void fillPSFormNegativePrice(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        productAndServicesName.sendKeys(faker.name().name());
        productAndServicesPrice.sendKeys("-"+faker.number().digit());
        actions.click(productAndServicesType).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        actions.click(productAndServicesCategory).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        productAndServicesDescription.sendKeys(faker.funnyName().name());
        productAndServicesSaveButton.click();

    }
    public void validateNegativePriceCannotBeAdded(WebDriver driver){
        Assert.assertEquals("https://cashwise.us/dashboard/sales/products-and-services?isCreate=true", driver.getCurrentUrl());
    }

    public void clickEditIconPS(){
        editIconPS.click();
    }
    public void fillEditFormPS(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        productAndServicesName.clear();
        productAndServicesName.sendKeys(faker.name().name());
        productAndServicesPrice.clear();
        productAndServicesPrice.sendKeys(faker.number().digit());
        actions.click(productAndServicesType).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        actions.click(productAndServicesCategory).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        productAndServicesDescription.clear();
        productAndServicesDescription.sendKeys(faker.funnyName().name());
        productAndServicesSaveButton.click();
        Thread.sleep(2000);

    }
    public void validateEditedPS(WebDriver driver){
        Assert.assertEquals("https://cashwise.us/dashboard/sales/products-and-services?isEdit=false", driver.getCurrentUrl());
    }
    public void clickDeleteIconPS(){
        deleteIconPS.click();
    }
    public void validateDeletionPS(WebDriver driver){
        Assert.assertTrue( driver.getCurrentUrl().contains("https://cashwise.us/dashboard/sales/products-and-services?isDelete=true"));

    }
    public void fillPSFormDuplicateName(WebDriver driver) throws InterruptedException {

        Actions actions = new Actions(driver);
        productAndServicesName.sendKeys("Banana");
        productAndServicesPrice.sendKeys(faker.number().digit());
        actions.click(productAndServicesType).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        actions.click(productAndServicesCategory).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        productAndServicesDescription.sendKeys(faker.funnyName().name());
        productAndServicesSaveButton.click();
        Thread.sleep(2000);

    }
    public void validateDuplicatePS(){
        Assert.assertEquals("[\"This name already exists\"]", BrowserUtils.getText(duplicateMessagePS));
    }
}
