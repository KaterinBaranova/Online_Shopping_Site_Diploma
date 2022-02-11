package tests;

import org.testng.annotations.Test;
import pages.CartHoverPage;
import pages.CheckOutPage;
import pages.ItemPage;

import static org.testng.Assert.assertEquals;
import static pages.ItemPage.ITEM_URL;

public class CartHoverTest extends BaseTest {
    @Test
    public void checkCountInHoverTest() {
        ItemPage itemPage = new ItemPage(driver);
        driver.get(ITEM_URL);
        CartHoverPage cartHoverPage = new CartHoverPage(driver);
        assertEquals(cartHoverPage.getCartHoverNumberInCart(), 0, "The number of items in the cart for a new user is more than zero");
        itemPage.clickAddToCart();
        assertEquals(cartHoverPage.getCartHoverNumberInCart(), 1, "The number of items in the cart is increased after adding an item to it");
    }

    @Test
    public void removeItemFromHoverTest() {
        driver.get(ITEM_URL);
        ItemPage itemPage = new ItemPage(driver);
        itemPage.clickAddToCart();
        itemPage.closeCartFrame();
        CartHoverPage cartHoverPage = new CartHoverPage(driver);
        cartHoverPage.removeFromHover();
        assertEquals(cartHoverPage.getCartHoverNumberInCart(), 0, "The number of items in the cart for a new user is more than zero");
    }

    @Test
    public void checkOutFromHoverTest() {
        driver.get(ITEM_URL);
        ItemPage itemPage = new ItemPage(driver);
        itemPage.clickAddToCart();
        itemPage.closeCartFrame();
        CartHoverPage cartHoverPage = new CartHoverPage(driver);
        cartHoverPage.checkOut();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        assertEquals(checkOutPage.getItemsInCart(),2);
    }
}
