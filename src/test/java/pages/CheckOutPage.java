package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import enums.ColumnName;

import java.util.List;

import static tests.BaseTest.*;


public class CheckOutPage extends BasePage {

    @FindBy(partialLinkText = "Proceed to checkout")
    private WebElement checkOutBtn;

    @FindBy(id = "uniform-cgv")
    private WebElement termsOfServiceCheckbox;

    @FindBy(css = "[name='processCarrier']")
    private WebElement completeOrder;

    @FindBy(id = "HOOK_TOP_PAYMENT")
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


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public int getItemsInCart() {
        getActions().isElementDisplayed(itemsInCart);
        return Integer.parseInt(String.valueOf(itemsInCart.getText().charAt(0)));
    }

    private WebElement getItem(String itemName) {
        List<WebElement> allRows = cartTable.findElements(By.cssSelector("[class*='cart_item'"));
        for (WebElement row : allRows) {
            if (row.findElement(By.cssSelector("td.cart_description > p > a")).getText().contains(itemName)) {
                return row.findElement(By.className(ColumnName.QTY.columnName));
            }
        }
        throw new NoSuchElementException("Unable to locate {" + itemName + "} wishlist");
    }


    public void pressIncreaseQuantity(String itemName) {
        String originalText = itemsInCart.getText();
        WebElement quantity = getItem(itemName);
        getActions().click(quantity.findElement(By.className("icon-plus")));
        getActions().isElementTextChanged(itemsInCart, originalText);
    }


    public void pressDecreaseQuantity(String itemName) {
        String originalText = itemsInCart.getText();
        WebElement quantity = getItem(itemName);
        int originalQuantity = Integer.parseInt(quantity.findElement(By.tagName("input")).getAttribute("value"));
        getActions().click(quantity.findElement(By.className("icon-minus")));
        if (originalQuantity != 1) {
            getActions().isElementTextChanged(itemsInCart, originalText);
        }
    }

    public boolean isCartEmpty() {
        return getActions().isElementDisplayed(emptyCart);
    }

    public boolean purchase() {
        checkOutBtn.click();
        emailField.sendKeys(LOGIN);
        passwordField.sendKeys(PASSWORD);
        signInButton.click();
        firstName.sendKeys(FIRSTNAME);
        lastname.sendKeys(LASTNAME);
        address1.sendKeys(ADDRESS1);
        city.sendKeys(CITY);
        postcode.sendKeys(POSTCODE);
        phone.sendKeys(PHONE);
        phone_mobile.sendKeys(PHONEMOBILE);
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByIndex(1);
        other.sendKeys(OTHER);
        saveBtn.click();
        proceedToCheckOutBtn.click();
        termsOfServiceCheckbox.click();
        completeOrder.click();
        return paymentBlock.getText().contains("No payment modules have been installed"); //seems bug on the app
    }
}
