package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartHoverPage;
import pages.CheckOutPage;
import pages.ItemPage;

import static org.testng.Assert.*;

public class CheckOutTest extends BaseTest {

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
        cartHoverPage.checkOut();
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
        cartHoverPage.checkOut();
        checkOutPage.pressDecreaseQuantity();
        // Note: there is a bug on the app
        assertTrue(checkOutPage.isCartEmpty(), "The cart was not empty");

    }

   @Test
   // Note user is not able to buy as there is an error on the app "No payment modules have been installed."
   public void purchaseItemsFromCartTest() {
        itemPage.clickAddToCart();
        CheckOutPage checkOutPage = itemPage.clickCheckout();
        assertFalse(checkOutPage.purchase(), "Order complete.");
    }
}
