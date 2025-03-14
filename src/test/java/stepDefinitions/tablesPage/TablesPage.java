package stepDefinitions.tablesPage;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.TablesPagePOM;

import java.util.List;

public class TablesPage {
    private WebDriver driver;
    private TablesPagePOM tablesPage;
    private String columnName;
    @Given("User is on the table page")
    public void user_is_on_the_table_page() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://practice.expandtesting.com/tables");
        tablesPage = new TablesPagePOM(driver);
    }

    @When("User extracts values from the {string} column")
    public void user_extracts_values_from_the_column(String columnName) {
        this.columnName = columnName;
        List<String> columnValues = tablesPage.getColumnValues(columnName);
    }

    @Then("User should see the following values:")
    public void user_should_see_the_following_values(List<String> expectedValues) {
        Assert.assertEquals(tablesPage.getColumnValues(columnName), expectedValues);
    }

    @Then("The table should have {int} rows")
    public void the_table_should_have_rows(int expectedRowCount) {
        Assert.assertEquals(tablesPage.getRowCount(), expectedRowCount);
    }

    @When("User deletes the row with {string} {string}")
    public void user_deletes_the_row_with(String columnName, String value) {
        tablesPage.deleteRow(columnName, value);
    }

    @When("User sorts the {string} column in ascending order")
    public void user_sorts_the_column_in_ascending_order(String columnName) {
        tablesPage.sortColumnAscending(columnName);
    }

    @When("User sorts the {string} column in descending order")
    public void user_sorts_the_column_in_descending_order(String columnName) {
        tablesPage.sortColumnDescending(columnName);
    }

    @Then("The {string} column should be sorted as:")
    public void the_column_should_be_sorted_as(String columnName, List<String> expectedValues) {
        Assert.assertEquals(tablesPage.getColumnValues(columnName), expectedValues);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


