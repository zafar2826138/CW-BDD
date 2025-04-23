package pages.pages.expenses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpensesSellersPage {

        public ExpensesSellersPage(WebDriver driver) {
            PageFactory.initElements(driver, this);}

        @FindBy(xpath = "//li[contains(text(), 'Expenses')]")
        WebElement expenses;

        @FindBy(xpath = "//a[contains(text(), 'Sellers')]")
        WebElement sellers;

        @FindBy(xpath = "//button[contains(text(), 'Add seller')]")
        WebElement addSeller;

        @FindBy(css = "#company_name_input_text")
        WebElement title;

        @FindBy(css = "#seller_name_input_text")
        WebElement fullName;

        @FindBy(css = "#email_input_text")
        WebElement email;

        @FindBy(css = "#phone_number_input_text")
        WebElement number;

        @FindBy(css = "#address_input_text")
        WebElement address;

        @FindBy(xpath = "//button[contains(text(), 'Save')]")
        WebElement saveButton;

        public void addSellerButtonClick() throws InterruptedException {
            expenses.click();
            sellers.click();
            addSeller.click();
            Thread.sleep(2000);
        }

        public void addSellerSendInfo(String title, String fullName, String email,
                                      String number, String address){

            this.title.sendKeys(title);
            this.fullName.sendKeys(fullName);
            this.email.sendKeys(email);
            this.number.sendKeys(number);
            this.address.sendKeys(address);
            saveButton.click();

        }

}
