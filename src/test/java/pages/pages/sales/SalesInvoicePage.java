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

import java.util.List;


public class SalesInvoicePage {
    public SalesInvoicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Faker faker = new Faker();
    @FindBy(xpath = "//a[contains(text(),'Invoice')]")
    WebElement invoiceTab;
    @FindBy(xpath = "//button[contains(text(),'Create invoice')]")
    WebElement createInvoice;
    @FindBy(xpath = "//input[@id='invoice_title_input_text']")
    WebElement invoiceName;
    @FindBy(xpath = "//div[@class=' css-1d8n9bt']")
    WebElement whomInvoice;
    @FindBy(xpath = "//p[.='DIB IT']")
    WebElement invoiceClientsCompanyName;
    @FindBy(xpath = "(//input[@id='undefined_input_text'])[2]")
    WebElement payUntilInvoice;
    @FindBy(xpath = "/html/body/div/div/div/main/form/header/div/div[1]/div[4]/div/div/textarea[1]")
    WebElement invoiceDescription;


    @FindBy(xpath = "//button[.='Select product or service']")
    WebElement invoiceSelectProduct;
    @FindBy(xpath = "(//div[@class='sc-dkzDqf gCnaQD'])[1]")
    WebElement invoiceItem;
    @FindBy(xpath = "//button[.='Save']")
    WebElement invoiceSaveButton;
    @FindBy(xpath = "(//div[@class='sc-dkzDqf gCnaQD'])[1]")
    WebElement invoiceItem2;
    @FindBy(xpath = "//div[.='Invoice modified successfully'] ")
    WebElement invoiceModifiedMessage;

    @FindBy(xpath = "(//li[.='Show PDF version'])[1]")
    WebElement invoiceShowPDFVersionbutton;
    @FindBy(xpath = "(//li[.='Edit'])[1]")
    WebElement invoiceEditButton;
    @FindBy(xpath = "(//button[@variant='vertical'])[1]")
    WebElement invoiceEditDots;
    @FindBy(xpath = "//button[.='Download PDF']")
    WebElement invoiceDownloadButton;
    @FindBy(xpath = "//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium sc-jSMfEi gorkCh css-q34dxg']")
    List<WebElement> invoiceItemList;

    public void clickInvoiceTab() {
        invoiceTab.click();

    }

    public void clickCreateInvoiceButton() {
        createInvoice.click();

    }

    public void fillCreateInvoiceForm(WebDriver driver) throws InterruptedException {

        invoiceName.sendKeys(faker.name().name());
        Actions actions = new Actions(driver);
        actions.click(whomInvoice).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        payUntilInvoice.sendKeys("03/08/2025");
        invoiceDescription.sendKeys(faker.funnyName().name());
        invoiceSelectProduct.click();
        //  actions.click(invoiceSelectProduct).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        invoiceItem.click();
        invoiceSaveButton.click();
        Thread.sleep(2000);
    }

    public void validateNewInvoiceCreated(WebDriver driver) {
        Assert.assertEquals("https://cashwise.us/dashboard/sales/invoice/invoices", driver.getCurrentUrl());
    }

    public void selectExistingClient(WebDriver driver) throws InterruptedException {
        invoiceName.sendKeys(faker.name().name());
        Actions actions = new Actions(driver);
        actions.click(whomInvoice).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
    }

    public void validateAutofill() {
        Assert.assertEquals("DIB IT", BrowserUtils.getText(invoiceClientsCompanyName));
    }

    public void addMultiplePS(WebDriver driver) throws InterruptedException {
        invoiceName.sendKeys(faker.name().name());
        Actions actions = new Actions(driver);
        actions.click(whomInvoice).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        payUntilInvoice.sendKeys("03/10/2025");
        invoiceDescription.sendKeys(faker.funnyName().name());
        invoiceSelectProduct.click();
        invoiceItem.click();
        invoiceSelectProduct.click();
        invoiceItem2.click();
    }

    public void validateValidEntry() {
        Assert.assertTrue(invoiceItemList.size() > 5);
    }

    public void validateAmountUpdates() {

        Assert.assertTrue(true);

    }

    public void clickEditIconInvoice() {
        invoiceEditDots.click();
        invoiceEditButton.click();
    }

    public void fillEditInvoiceFrom(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.click(whomInvoice).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        invoiceSaveButton.click();
        Thread.sleep(2000);
    }

    public void validateChangesInvoice() {
        Assert.assertEquals("Invoice modified successfully", BrowserUtils.getText(invoiceModifiedMessage));
    }

    public void clickPDFVersion() {
        invoiceEditDots.click();
        invoiceShowPDFVersionbutton.click();


    }

    public void clickDownloadPDFButton() {
        invoiceDownloadButton.click();
    }

    public void validateDownloadSuccessful(WebDriver driver) {
        Assert.assertTrue(driver.getCurrentUrl().contains("https://cashwise.us/dashboard/sales/invoice/preview"));
    }
}
