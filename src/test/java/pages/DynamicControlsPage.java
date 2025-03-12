package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage {
    private WebDriver driver;

    @FindBy(xpath = "//form[@id='checkbox-example']//input[@type='checkbox']")
    private WebElement checkbox;

    @FindBy(xpath = "//form[@id='checkbox-example']//button")
    private WebElement removeAddButton;

    @FindBy(xpath = "//form[@id='input-example']//input[@type='text']")
    private WebElement inputField;

    @FindBy(xpath = "//form[@id='input-example']//button")
    private WebElement enableDisableButton;

    @FindBy(id = "message")
    private WebElement message;

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCheckboxVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(checkbox));
            return checkbox.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectCheckbox() {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public boolean isCheckboxSelected() {
        return checkbox.isSelected();
    }

    public void clickRemoveAddButton() {
        removeAddButton.click();
        waitForMessage();
    }

    public boolean isInputFieldEnabled() {
        return inputField.isEnabled();
    }

    public void clickEnableDisableButton() {
        enableDisableButton.click();
        waitForMessage();
    }

    public String getMessageText() {
        return message.getText();
    }

    private void waitForMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(message));
    }
}
