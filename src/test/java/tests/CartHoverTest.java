package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartHoverPage;
import pages.CheckOutPage;
import pages.ItemPage;

import static org.testng.Assert.assertEquals;

public class CartHoverTest extends BaseTest {

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

    @Test(description = "User is able to check items quantity from cart hover", groups = {"Regression Test"})
    public void checkCountInHoverTest() {
        assertEquals(cartHoverPage.getCartHoverNumberInCart(), 0, "The number of items in the cart for a new user is more than zero");
        itemPage.clickAddToCart();
        assertEquals(cartHoverPage.getCartHoverNumberInCart(), 1, "The number of items in the cart is increased after adding an item to it");
    }

    @Test(description = "User is able to remove items from cart hover", groups = {"Regression Test"})
    public void removeItemFromHoverTest() {
        itemPage.clickAddToCart();
        itemPage.closeCartFrame();
        cartHoverPage.clickRemoveFromHover();
        assertEquals(cartHoverPage.getCartHoverNumberInCart(), 1, "The number of items in the cart for a new user is more than zero");
    }

    @Test (description = "User is able to check out from cart hover", groups = {"Smoke Test"})
    public void checkOutFromHoverTest() {
        itemPage.clickAddToCart();
        itemPage.closeCartFrame();
        cartHoverPage.clickCheckOutBtn();
        assertEquals(checkOutPage.getItemsInCart(),2);
    }
}
