package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static tests.BaseTest.*;


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
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastname;

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


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public int getItemsInCart() {
        getActions().isElementDisplayed(itemsInCart);
        return Integer.parseInt(String.valueOf(itemsInCart.getText().charAt(0)));
    }

    public void pressIncreaseQuantity() {
        getActions().click(plusQuantity);
    }

    public void pressDecreaseQuantity() {
        getActions().click(minusQuantity);
    }

    public boolean isCartEmpty() {
        return getActions().isElementDisplayed(emptyCart);
    }

    public void clickCheckOutBtn() {
        getActions().click(checkOutBtn);
    }

    public void fillEmailField() {
        emailField.sendKeys(LOGIN);
    }

    public void fillPasswordField() {
        passwordField.sendKeys(PASSWORD);
    }

    public void clickSignInButton() {
        getActions().click(signInButton);
    }


    public void fillFirstName() {
        firstName.sendKeys(FIRSTNAME);
    }

    public void fillLastName() {
        lastname.sendKeys(LASTNAME);
    }

    public void fillAddress() {
        address1.sendKeys(ADDRESS1);
    }
    public void fillCity() {
        city.sendKeys(CITY);
    }
    public void fillPostcode() {
        postcode.sendKeys(POSTCODE);
    }
    public void fillPhone() {
        phone.sendKeys(PHONE);
    }
    public void fillMobilePhone() {
        phone_mobile.sendKeys(PHONEMOBILE);
    }

    public void selectState() {
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByIndex(1);
    }

    public void fillAddressTitle() {
        other.sendKeys(OTHER);
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

    public boolean purchase() {
        return paymentBlock.getText().contains("No payment modules have been installed"); //seems bug on the app
    }
}
