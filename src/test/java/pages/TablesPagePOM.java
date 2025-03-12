package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TablesPagePOM {
    private WebDriver driver;

    @FindBy(xpath = "//table[@id='table1']//th[contains(text(), 'Last Name')]")
    private WebElement lastNameHeader;

    @FindBy(xpath = "//table[@id='table1']//tbody//tr")
    private List<WebElement> rows;

    @FindBy(xpath = "//table[@id='table1']//td[contains(text(), 'Conway')]/following-sibling::td//a[contains(@class, 'btn-danger')]")
    private WebElement deleteButton;

    @FindBy(css = "#table1 th:nth-child(1)")
    private WebElement firstNameHeader;

    public TablesPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getColumnValues(String columnName) {
        List<WebElement> columnElements = driver.findElements(
                By.xpath("//table[@id='table1']//td[count(//table[@id='table1']//th[contains(text(), '" + columnName + "')]/preceding-sibling::th) + 1]")
        );
        List<String> columnValues = new ArrayList<>();
        for (WebElement element : columnElements) {
            columnValues.add(element.getText());
        }
        return columnValues;
    }

    public int getRowCount() {
        return rows.size();
    }

    public void deleteRow(String columnName, String value) {
        deleteButton.click();
    }

    public void sortColumnAscending(String columnName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstNameHeader);
        firstNameHeader.click();
    }

    public void sortColumnDescending(String columnName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstNameHeader);
        firstNameHeader.click();
        firstNameHeader.click();
    }
}
