package pages.pages.expenses;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.ConfigReader;

import java.util.Arrays;
import java.util.List;

public class ExpensesPSPage {
    public ExpensesPSPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//li[.='Expenses']")
    WebElement expenses;


    @FindBy(xpath = "(//a[text()='Products and services'])[2]")
    WebElement productsAndServices;

    @FindBy(xpath = "//h3")
    WebElement titleProductsAndServices;

    @FindBy(xpath = "//*[@id=\"main\"]/div/header/button")
    WebElement addProductButton;

    @FindBy(xpath = "//input[@name='product_title']")
    WebElement name;

    @FindBy(xpath = "//input[@name='product_price']")
    WebElement productPrice;

    @FindBy(css = "#mui-component-select-service_type_id")
    WebElement serviceType;

    @FindBy(xpath = "//li[.='Product']")
    WebElement productOption;

    @FindBy(css = "#mui-component-select-category_id")
    WebElement category;

    @FindBy(xpath = "//*[@id=\"menu-category_id\"]/div[3]/ul/button")
    WebElement createNewCategory;

    @FindBy(css = "#category_title_input_text")
    WebElement titleCategory;

    @FindBy(css = "#category_description_input_text")
    WebElement descriptionCategory;

    @FindBy(xpath = "(//button[text()='Save'])[2]")
    WebElement buttonSaveInCategory;

    @FindBy(xpath = "//li[@tabindex='0']")
    WebElement firstProduct;

    @FindBy(css = "#product_description_input_text")
    WebElement description;

    @FindBy(xpath = "//input[@name='remind_before_day']")
    WebElement remindBeforeButton;

    @FindBy(xpath = "//input[@value='DO_NOT_REPEAT']")
    WebElement noRepeatBox;

    @FindBy(css = "#undefined_input_text")
    WebElement dateOfPay;


    @FindBy(xpath = "//button[.='Save']")
    WebElement saveButton;

    //@FindBy(xpath = "//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-q34dxg']")
    @FindBy(xpath = "//td")
    List<WebElement> allInformation;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/table/tbody/tr/td[6]/div/button[2]")
   // @FindBy(xpath = "(//span[@class='MuiTouchRipple-root css-w0pj6f'])[3]")
    WebElement deleteTheCreatedProduct;

    @FindBy(xpath = "//button[.='Delete']")
    WebElement deleteButton;

    @FindBy(xpath = "//span[.='List is empty']")
    WebElement listIsEmpty;

    public void openProductAndServicesFromExpenses() throws InterruptedException {
        expenses.click();
        //Thread.sleep(2000);
        productsAndServices.click();
        //Assert.assertEquals(BrowserUtils.getText(titleProductsAndServices), "Products and services (Expense)");


    }

    public void validatesProducts(String actualMessage) {
        Assert.assertEquals(BrowserUtils.getText(titleProductsAndServices), actualMessage);
    }

    public void addProduct() {
        addProductButton.click();
    }

    public void provideInformation() throws InterruptedException {

        //  Thread.sleep(2000);
        name.sendKeys(ConfigReader.ReadProperty("name"));
        productPrice.sendKeys(ConfigReader.ReadProperty("price"));
        serviceType.click();
        productOption.click();
        category.click();
        Thread.sleep(2000);
        createNewCategory.click();
        titleCategory.sendKeys(ConfigReader.ReadProperty("category"));
        descriptionCategory.sendKeys(ConfigReader.ReadProperty("categoryDescription"));
        buttonSaveInCategory.click();
        Thread.sleep(2000);
        firstProduct.click();
        //Thread.sleep(2000);
        description.sendKeys(ConfigReader.ReadProperty("description"));
        dateOfPay.sendKeys(ConfigReader.ReadProperty("date"));


    }

    public void remindBeforeButtonAndNoRepeatBox() {
        remindBeforeButton.clear();
        remindBeforeButton.sendKeys(ConfigReader.ReadProperty("remind"));
        noRepeatBox.click();
    }


    public void saveButton() {
        saveButton.click();
    }

    public void validatesAllInformation() {
        List<String> expectedInformation = Arrays.asList("book", "90 $", "book", "New Book");

        for (int i = 1; i < allInformation.size() - 2; i++) {
            Assert.assertEquals(expectedInformation.get(i), BrowserUtils.getText(allInformation.get(i)));
        }
    }

    public void deleteTheProduct() {
        deleteTheCreatedProduct.click();
        deleteButton.click();
        Assert.assertEquals(BrowserUtils.getText(listIsEmpty), "List is empty");
    }
}
