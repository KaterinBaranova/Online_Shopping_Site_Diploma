package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartHoverPage;
import pages.CheckOutPage;
import pages.ItemPage;

import static org.testng.Assert.*;

public class CheckOutTest extends BaseTest {

    public final static String FIRSTNAME = "Kate";
    public final static String LASTNAME = "Sh";
    public final static String ADDRESS1 ="123 Melrose street";
    public final static String CITY = "New York";
    public final static String POSTCODE = "12345";
    public final static String PHONE = "1234567";
    public final static String PHONEMOBILE = "1234567";
    public final static String OTHER= "some other text";

    private ItemPage itemPage;
    private CartHoverPage cartHoverPage;
    private CheckOutPage checkOutPage;

    @BeforeMethod
    public void navigate() {
        itemPage = new ItemPage (driver);
        itemPage.open();
        cartHoverPage = new CartHoverPage(driver);
        checkOutPage = new CheckOutPage(driver);
    }

    @Test
    public void changeQuantityInCartTest() {
        itemPage.clickAddToCart();
        itemPage.closeCartFrame();
        cartHoverPage.clickCheckOutBtn();
        checkOutPage.pressIncreaseQuantity();
        checkOutPage.pressIncreaseQuantity();
        checkOutPage.pressDecreaseQuantity();
        checkOutPage.getItemsInCart();
        assertEquals(checkOutPage.getItemsInCart(), 2, "Incorrect number of items in cart");
    }

    @Test
    public void removeLastItemFromCartTest() {
        itemPage.clickAddToCart();
        itemPage.closeCartFrame();
        cartHoverPage.clickCheckOutBtn();
        checkOutPage.pressDecreaseQuantity();
        // Note: there is a bug on the app
        assertTrue(checkOutPage.isCartEmptyMessageDisplayed(), "The cart was not empty");

    }

   @Test
   // Note user is not able to buy as there is an error on the app "No payment modules have been installed."
   public void purchaseItemsFromCartForNotAuthorizedUserTest() {
       String expected_message = "No payment modules have been installed.";
        itemPage.clickAddToCart();
        itemPage.proceedToCheckoutButton();
        checkOutPage.clickCheckOutBtn();
        checkOutPage.fillEmailField(LOGIN);
        checkOutPage.fillPasswordField(PASSWORD);
        checkOutPage.clickSignInButton();
        checkOutPage.fillFirstName(FIRSTNAME);
        checkOutPage.fillLastName(LASTNAME);
        checkOutPage.fillAddress(ADDRESS1);
        checkOutPage.fillCity(CITY);
        checkOutPage.fillPostcode(POSTCODE);
        checkOutPage.fillPhone(PHONE);
        checkOutPage.fillMobilePhone(PHONEMOBILE);
        checkOutPage.selectState();
        checkOutPage.fillAddressTitle(OTHER);
        checkOutPage.clickSaveBtn();
        checkOutPage.clickProceedToCheckOutBtn();
        checkOutPage.clickTermsOfServiceCheckbox();
        checkOutPage.clickCompleteOrder();
        assertTrue(checkOutPage.isPaymentBlockMessageDisplayed(),expected_message);
    }
}
