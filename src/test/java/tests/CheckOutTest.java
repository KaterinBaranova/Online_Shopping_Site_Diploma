package tests;

import org.testng.annotations.Test;
import pages.CartHoverPage;
import pages.CheckOutPage;
import pages.ItemPage;


import static org.testng.Assert.*;

public class CheckOutTest extends BaseTest {
    @Test
    public void changeQuantityInCartTest() {
        driver.get("http://prestashop.qatestlab.com.ua/en/blouses/2-blouse.html#/size-s/color-black");
        ItemPage itemPage = new ItemPage(driver);
        itemPage.clickAddToCart();
        itemPage.closeCartFrame();
        CartHoverPage cartHoverPage = new CartHoverPage(driver);
        cartHoverPage.checkOut();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.pressIncreaseQuantity("Blouse");
        checkOutPage.pressIncreaseQuantity("Blouse");
        checkOutPage.pressDecreaseQuantity("Blouse");
        assertEquals(checkOutPage.getItemsInCart(), 2, "Incorrect number of items in cart");
    }

    @Test
    public void removeLastItemFromCartTest() {
        driver.get("http://prestashop.qatestlab.com.ua/en/blouses/2-blouse.html#/size-s/color-black");
        ItemPage itemPage = new ItemPage(driver);
        itemPage.clickAddToCart();
        itemPage.closeCartFrame();
        CartHoverPage cartHoverPage = new CartHoverPage(driver);
        cartHoverPage.checkOut();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.pressDecreaseQuantity("Blouse");
        // Note: there is a bug on the app
        assertTrue(checkOutPage.isCartEmpty(), "The cart was not empty");

    }

   @Test
   // Note user is not able to buy as there is an error on the app "No payment modules have been installed."
   public void buyItemsFromCartTest() {
        ItemPage itemPage = new ItemPage(driver);
        driver.get(ITEM_URL);
        itemPage.clickAddToCart();
        CheckOutPage checkOutPage = itemPage.clickCheckout();
        assertFalse(checkOutPage.purchase(), "Order complete.");
    }
}
