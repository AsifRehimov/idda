package stepDefinitions.dynamicControls;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.DynamicControlsPage;

public class DynamicControlsSteps {
    private WebDriver driver;
    private DynamicControlsPage dynamicControlsPage;

    @Given("User is on the dynamic controls page")
    public void user_is_on_the_dynamic_controls_page() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://practice.expandtesting.com/dynamic-controls");
        dynamicControlsPage = new DynamicControlsPage(driver);
    }

    @When("User clicks on the {string} button")
    public void user_clicks_on_the_button(String buttonText) {
        if (buttonText.equals("Remove") || buttonText.equals("Add")) {
            dynamicControlsPage.clickRemoveAddButton();
        } else if (buttonText.equals("Enable") || buttonText.equals("Disable")) {
            dynamicControlsPage.clickEnableDisableButton();
        }
    }

    @Then("The checkbox should not be visible")
    public void the_checkbox_should_not_be_visible() {
        Assert.assertFalse(dynamicControlsPage.isCheckboxVisible());
    }

    @Then("The checkbox should be visible")
    public void the_checkbox_should_be_visible() {
        Assert.assertTrue(dynamicControlsPage.isCheckboxVisible());
    }

    @Then("The checkbox should be selected")
    public void the_checkbox_should_be_selected() {
        dynamicControlsPage.selectCheckbox();
        Assert.assertTrue(dynamicControlsPage.isCheckboxSelected());
    }

    @Then("The input field should be disabled")
    public void the_input_field_should_be_disabled() {
        Assert.assertFalse(dynamicControlsPage.isInputFieldEnabled());
    }

    @Then("The input field should be enabled")
    public void the_input_field_should_be_enabled() {
        Assert.assertTrue(dynamicControlsPage.isInputFieldEnabled());
    }

    @Then("The message {string} should be displayed")
    public void the_message_should_be_displayed(String expectedMessage) {
        String actualMessage = dynamicControlsPage.getMessageText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
