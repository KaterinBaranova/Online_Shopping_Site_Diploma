package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CheckOutPage extends BasePage {

    @FindBy(partialLinkText = "Proceed to checkout")
    private WebElement checkOutBtn;

    @FindBy(id = "uniform-cgv")
    private WebElement termsOfServiceCheckbox;

    @FindBy(css = "[name='processCarrier']")
    private WebElement completeOrder;

    @FindBy(css = "[class='alert alert-warning']")
    private WebElement paymentBlock;

    @FindBy(id = "summary_products_quantity")
    private WebElement itemsInCart;

    @FindBy(id = "cart_summary")
    private WebElement cartTable;

    @FindBy(css = "[class*='alert-warning']")
    private WebElement emptyCart;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(id = "firstname")
    private WebElement firstNameFiled;

    @FindBy(id = "lastname")
    private WebElement lastNameFiled;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "phone_mobile")
    private WebElement phone_mobile;

    @FindBy(id = "alias")
    private WebElement other;

    @FindBy(id = "submitAddress")
    private WebElement saveBtn;

    @FindBy(name = "processAddress")
    private WebElement proceedToCheckOutBtn;

    @FindBy(className ="icon-plus")
    private WebElement plusQuantity;

    @FindBy(className ="icon-minus")
    private WebElement minusQuantity;

    @FindBy(id ="id_state")
    private WebElement state;


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public int getItemsInCart() {
        return Integer.parseInt(String.valueOf(itemsInCart.getText().charAt(0)));
    }

    public boolean isCartEmptyMessageDisplayed() {
        return getActions().isElementDisplayed(emptyCart);
    }

    public void pressIncreaseQuantity() {
        getActions().click(plusQuantity);
    }

    public void pressDecreaseQuantity() {
        getActions().click(minusQuantity);
    }

    public void clickCheckOutBtn() {
        getActions().click(checkOutBtn);
    }

    public void fillEmailField( String login) {
        emailField.sendKeys(login);
    }

    public void fillPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        getActions().click(signInButton);
    }


    public void fillFirstName(String firstName) {
        firstNameFiled.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameFiled.sendKeys(lastName);
    }

    public void fillAddress(String address) {
        address1.sendKeys(address);
    }
    public void fillCity(String cityName) {
        city.sendKeys(cityName);
    }
    public void fillPostcode(String postcodeNumber) {
        postcode.sendKeys(postcodeNumber);
    }
    public void fillPhone(String phoneNumber) {
        phone.sendKeys(phoneNumber);
    }
    public void fillMobilePhone(String phoneMobile) {
        phone_mobile.sendKeys(phoneMobile);
    }

    public void selectState(String stateName) {
        Select stateField = new Select(state);
        stateField.selectByVisibleText(stateName);
    }

    public void fillAddressTitle(String Other) {
        other.sendKeys(Other);
    }

    public void clickSaveBtn() {
        getActions().click(saveBtn);
    }
    public void clickProceedToCheckOutBtn() {
        getActions().click(proceedToCheckOutBtn);

    }
    public void clickTermsOfServiceCheckbox() {
        getActions().click(termsOfServiceCheckbox);
    }
    public void clickCompleteOrder() {
        getActions().click(completeOrder);
    }

    public boolean isPaymentBlockMessageDisplayed() {
        return paymentBlock.isDisplayed();
    }
}
