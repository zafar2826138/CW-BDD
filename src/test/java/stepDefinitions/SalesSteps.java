package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.pages.sales.SalesClientPage;
import pages.pages.sales.SalesInvoicePage;
import pages.pages.sales.SalesPSPage;
import utils.DriverHelper;


public class SalesSteps {
    WebDriver driver = DriverHelper.getDriver();
    SalesClientPage salesClientPage = new SalesClientPage(driver);
    SalesPSPage salesPSPage = new SalesPSPage(driver);
    SalesInvoicePage salesInvoicePage = new SalesInvoicePage(driver);

    @Then("User clicks Sales Tab")
    public void user_clicks_sales_tab() {
        salesClientPage.clickSalesTab();
    }

    @Then("User click add client button")
    public void user_click_add_client_button() throws InterruptedException {
        salesClientPage.clickAddClientButton();
    }

    @Then("User fills Add client form and clicks Save button")
    public void user_fills_add_client_form_and_clicks_save_button() {
        salesClientPage.fillAddClientForm(driver);
    }

    @Then("User verifies client added and appears in Clients list")
    public void user_verifies_client_added_and_appears_in_clients_list() {
        salesClientPage.validateAddedClient();
    }

    @Then("User clicks edit icon on first client")
    public void user_clicks_edit_icon_on_first_client() {
        salesClientPage.clickEditClientIcon();
    }

    @Then("User makes changes in Edit form and clicks Save button")
    public void user_makes_changes_in_edit_form_and_clicks_save_button() {
        salesClientPage.fillEditForm();

    }

    @Then("User validates changes of first client")
    public void user_validates_changes_of_first_client() {
        salesClientPage.validateChangesEditFormClient();
    }

    @Then("User clicks archive icon on random client")
    public void user_clicks_archive_icon_on_random_client() {
        salesClientPage.clickClientArchiveButton();
    }

    @Then("User validates archived client from Archived tab list")
    public void user_validates_archived_client_from_archived_tab_list() {
        salesClientPage.validateFromClientArchiedList();
    }

    @Then("User fills Add client form with existing client and clicks Save button")
    public void user_fills_add_client_form_with_existing_client_and_clicks_save_button() {
        salesClientPage.fillAddClientDublicateForm(driver);

    }

    @Then("User validates duplicate client cannot be created")
    public void user_validates_duplicate_client_cannot_be_created() {
        salesClientPage.validateDuplicateClient();
    }

    @Then("User clicks Product and Services Tab Sales")
    public void user_clicks_product_and_services_tab_sales() {
        salesPSPage.clickPSTab();

    }

    @Then("User clicks Add Product and service button")
    public void user_clicks_add_product_and_service_button() {
        salesPSPage.clickAddPSBUtton();

    }

    @Then("User fills Add product and service form and clicks Save button")
    public void user_fills_add_product_and_service_form_and_clicks_save_button() throws InterruptedException {
        salesPSPage.fillPSForm(driver);
    }

    @Then("User validates added product from list")
    public void user_validates_added_product_from_list() {
        salesPSPage.validatePSFromList();
    }

    @Then("User fills Add product and service form with negative price and clicks Save button")
    public void user_fills_add_product_and_service_form_with_negative_price_and_clicks_save_button() throws InterruptedException {
        salesPSPage.fillPSFormNegativePrice(driver);
    }

    @Then("User validates that product cannot be added")
    public void user_validates_that_product_cannot_be_added() {
        salesPSPage.validateNegativePriceCannotBeAdded(driver);
    }

    @Then("User clicks edit icon on first product")
    public void user_clicks_edit_icon_on_first_product() {
        salesPSPage.clickEditIconPS();
    }

    @Then("User changes Edit product or service form and clicks Save button")
    public void user_changes_edit_product_or_service_form_and_clicks_save_button() throws InterruptedException {
        salesPSPage.fillEditFormPS(driver);
    }

    @Then("User validates changes of product from list")
    public void user_validates_changes_of_product_from_list() {
        salesPSPage.validateEditedPS(driver);
    }

    @Then("User clicks delete icon on first product")
    public void user_clicks_delete_icon_on_first_product() {
        salesPSPage.clickDeleteIconPS();
    }

    @Then("User validates deleted product from list")
    public void user_validates_deleted_product_from_list() {
        salesPSPage.validateDeletionPS(driver);
    }

    @Then("User fills Add product and service form with existing product and clicks Save button")
    public void user_fills_add_product_and_service_form_with_existing_product_and_clicks_save_button() throws InterruptedException {
        salesPSPage.fillPSFormDuplicateName(driver);
    }

    @Then("User validates duplicate product are not allowed")
    public void user_validates_duplicate_product_are_not_allowed() {
        salesPSPage.validateDuplicatePS();
    }

    @Then("User clicks Invoice Tab")
    public void user_clicks_invoice_tab() {
        salesInvoicePage.clickInvoiceTab();
    }

    @Then("User clicks Create invoice button")
    public void user_clicks_create_invoice_button() {
        salesInvoicePage.clickCreateInvoiceButton();

    }

    @Then("User fills Create invoice form")
    public void user_fills_create_invoice_form() throws InterruptedException {
        salesInvoicePage.fillCreateInvoiceForm(driver);

    }

    @Then("User validates new invoice created")
    public void user_validates_new_invoice_created() {
        salesInvoicePage.validateNewInvoiceCreated(driver);
    }

    @Then("User selects existing client from Whom dropdown")
    public void user_selects_existing_client_from_whom_dropdown() throws InterruptedException {
        salesInvoicePage.selectExistingClient(driver);
    }

    @Then("User validates auto-fill details")
    public void user_validates_auto_fill_details() {
        salesInvoicePage.validateAutofill();
    }

    @Then("User adds multiple products and services")
    public void user_adds_multiple_products_and_services() throws InterruptedException {
        salesInvoicePage.addMultiplePS(driver);
    }

    @Then("User validates valid entry")
    public void user_validates_valid_entry() {
        salesInvoicePage.validateValidEntry();
    }

    @Then("User validates amount updates correctly")
    public void user_validates_amount_updates_correctly() {
        salesInvoicePage.validateAmountUpdates();
    }

    @Then("User clicks edit icon from first invoice")
    public void user_clicks_edit_icon_from_first_invoice() {
        salesInvoicePage.clickEditIconInvoice();

    }

    @Then("User fills Edit invoice form and clicks Save button")
    public void user_fills_edit_invoice_form_and_clicks_save_button() throws InterruptedException {
        salesInvoicePage.fillEditInvoiceFrom(driver);
    }

    @Then("User validates changes saved")
    public void user_validates_changes_saved() {
        salesInvoicePage.validateChangesInvoice();
    }

    @Then("User clicks Show PDF version icon from first invoice")
    public void user_clicks_show_pdf_version_icon_from_first_invoice() {
        salesInvoicePage.clickPDFVersion();
    }

    @Then("User clicks Download PDF button")
    public void user_clicks_download_pdf_button() {
        salesInvoicePage.clickDownloadPDFButton();
    }

    @Then("User validates invoice downloaded to local machine")
    public void user_validates_invoice_downloaded_to_local_machine() {
        salesInvoicePage.validateDownloadSuccessful(driver);
    }

}