//package stepDefinitions.formValidation;
//
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;
//import pages.FormValidationPage;
//
//import java.time.Duration;
//
//public class FormValidationSteps {
//    private WebDriver driver;
//    private FormValidationPage formValidationPage;
//
//    @Given("User is on the form validation page")
//    public void user_is_on_the_form_validation_page() {
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);
//        driver.get("https://practice.expandtesting.com/form-validation");
//        formValidationPage = new FormValidationPage(driver);
//    }
//
//    @When("User enters {string} as Contact Name")
//    public void user_enters_as_contact_name(String contactName) {
//        formValidationPage.enterContactName(contactName);
//    }
//
//    @When("User enters {string} as Contact Number")
//    public void user_enters_as_contact_number(String contactNumber) {
//        formValidationPage.enterContactNumber(contactNumber);
//    }
//
//    @When("User selects {string} as PickUp Date")
//    public void user_selects_as_pickup_date(String pickupDate) {
//        formValidationPage.enterPickupDate(pickupDate);
//    }
//
//    @When("User selects {string} as Payment Method")
//    public void user_selects_as_payment_method(String paymentMethod) {
//        formValidationPage.selectPaymentMethod(paymentMethod);
//    }
//
//    @When("User clicks on Register button")
//    public void user_clicks_on_register_button() {
//        formValidationPage.clickRegisterButton();
//    }
//
//    @Then("Form should be registered successfully")
//    public void form_should_be_registered_successfully() {
//        Assert.assertTrue(formValidationPage.isSuccessMessageDisplayed());
//        driver.quit();
//    }
//
//    @Then("User should see error message {string} in position {int}")
//    public void form_should_be_error_message(String errorMessage, int position) {
//        String actualErrorMessage = formValidationPage.getErrorMessage(position);
//        Assert.assertEquals(actualErrorMessage, errorMessage);
//        if (position == 4) {
//            driver.quit();
//        }
//    }
//}

package stepDefinitions.formValidation;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.FormValidationPage;
import utils.CSVReader;

import java.util.List;

public class FormValidationSteps {
    private WebDriver driver;
    private FormValidationPage formValidationPage;
    private List<String[]> testData;

    @Given("User is on the form validation page")
    public void user_is_on_the_form_validation_page() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://practice.expandtesting.com/form-validation");
        formValidationPage = new FormValidationPage(driver);

        // Read test data from CSV
        testData = CSVReader.readCSV("src/test/resources/test_data/form_validation_data.csv");
    }

    @When("User enters {string} as Contact Name")
    public void user_enters_as_contact_name(String scenario) {
        String contactName = getTestData(scenario, "ContactName");
        formValidationPage.enterContactName(contactName);
    }

    @When("User enters {string} as Contact Number")
    public void user_enters_as_contact_number(String scenario) {
        String contactNumber = getTestData(scenario, "ContactNumber");
        formValidationPage.enterContactNumber(contactNumber);
    }

    @When("User selects {string} as PickUp Date")
    public void user_selects_as_pickup_date(String scenario) {
        String pickupDate = getTestData(scenario, "PickUpDate");
        formValidationPage.enterPickupDate(pickupDate);
    }

    @When("User selects {string} as Payment Method")
    public void user_selects_as_payment_method(String scenario) {
        String paymentMethod = getTestData(scenario, "PaymentMethod");
        formValidationPage.selectPaymentMethod(paymentMethod);
    }

    @When("User clicks on Register button")
    public void user_clicks_on_register_button() {
        formValidationPage.clickRegisterButton();
    }

    @Then("Form should be registered successfully")
    public void form_should_be_registered_successfully() {
        Assert.assertTrue(formValidationPage.isSuccessMessageDisplayed());
        driver.quit();
    }

    @Then("User should see error message {string} in position {int}")
    public void user_should_see_error_message(String expectedErrorMessage, int position) {
        String actualErrorMessage = formValidationPage.getErrorMessage(position);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        if (position == 4) {
            driver.quit();
        }
    }

    private String getTestData(String scenario, String columnName) {
        for (String[] row : testData) {
            if (row[0].equals(scenario)) {
                switch (columnName) {
                    case "ContactName":
                        return row[1];
                    case "ContactNumber":
                        return row[2];
                    case "PickUpDate":
                        return row[3];
                    case "PaymentMethod":
                        return row[4];
                    case "ExpectedErrorMessage1":
                        return row[5];
                    case "ExpectedErrorMessage2":
                        return row[6];
                    case "ExpectedErrorMessage3":
                        return row[7];
                    case "ExpectedErrorMessage4":
                        return row[8];
                    default:
                        throw new IllegalArgumentException("Invalid column name: " + columnName);
                }
            }
        }
        throw new IllegalArgumentException("Scenario not found: " + scenario);
    }
}