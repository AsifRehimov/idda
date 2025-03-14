package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormValidationPage {
    private WebDriver driver;

    @FindBy(name = "ContactName")
    private WebElement contactNameField;

    @FindBy(name = "contactnumber")
    private WebElement contactNumberField;

    @FindBy(name = "pickupdate")
    private WebElement pickupDateField;

    @FindBy(name = "payment")
    private WebElement paymentMethodDropdown;

    @FindBy(className = "btn-primary")
    private WebElement registerButton;

    @FindBy(className = "alert-info")
    private WebElement successMessage;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    private WebElement errorMessage1;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[2]")
    private WebElement errorMessage2;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[3]")
    private WebElement errorMessage3;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[4]")
    private WebElement errorMessage4;

    public FormValidationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterContactName(String contactName) {
        contactNameField.sendKeys(contactName);
    }

    public void enterContactNumber(String contactNumber) {
        contactNumberField.sendKeys(contactNumber);
    }

    public void enterPickupDate(String pickupDate) {
        pickupDateField.sendKeys(pickupDate);
    }

    public void selectPaymentMethod(String paymentMethod) {
        paymentMethodDropdown.sendKeys(paymentMethod);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public String getErrorMessage(int position) {
        switch (position) {
            case 1:
                return errorMessage1.getText();
            case 2:
                return errorMessage2.getText();
            case 3:
                return errorMessage3.getText();
            case 4:
                return errorMessage4.getText();
            default:
                throw new IllegalArgumentException("Invalid error message position: " + position);
        }
    }
}