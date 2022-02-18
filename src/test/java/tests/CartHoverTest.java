package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartHoverPage;
import pages.CatalogPage;
import pages.CheckOutPage;
import pages.ItemPage;

import static org.testng.Assert.assertEquals;

public class CartHoverTest extends BaseTest {

    private ItemPage itemPage;
    private CartHoverPage cartHoverPage;
    private CheckOutPage checkOutPage;
    private CatalogPage catalogPage;


    @BeforeMethod
    public void navigate() {
        itemPage = new ItemPage (driver);
        cartHoverPage = new CartHoverPage(driver);
        checkOutPage = new CheckOutPage(driver);
        catalogPage = new CatalogPage(driver);
    }

    @Test(description = "User is able to see the items quantity on Cart hover", groups = {"Regression Test"})
    public void checkCountInHoverTest() {
        assertEquals(cartHoverPage.getCartHoverNumberInCart(), 0, "The number of items in the cart for a new user is more than zero");
        catalogPage.openItem(PRODUCT_NAME);
        itemPage.clickAddToCart();
        assertEquals(cartHoverPage.getCartHoverNumberInCart(), 1, "The number of items in the cart is increased after adding an item to it");
    }

    @Test(description = "User is able to remove items from cart hover", groups = {"Regression Test"})
    public void removeItemFromHoverTest() {
        catalogPage.openItem(PRODUCT_NAME);
        itemPage.clickAddToCart();
        itemPage.closeCartFrame();
        cartHoverPage.clickRemoveFromHover();
        assertEquals(cartHoverPage.getCartHoverNumberInCart(), 1, "The number of items in the cart for a new user is more than zero");
    }

    @Test (description = "User is able to navigate to check out page from cart hover and see the items he selected", groups = {"Smoke Test"})
    public void checkOutFromHoverTest() {
        catalogPage.openItem(PRODUCT_NAME);
        itemPage.clickAddToCart();
        itemPage.closeCartFrame();
        cartHoverPage.clickCheckOutBtn();
        assertEquals(checkOutPage.getItemsInCart(), 1, "Incorrect number of items in the cart");
        // test failed there is a bug on the app, and it shows "Your shopping cart contains: 2 product" but actually there is only one
    }
}
