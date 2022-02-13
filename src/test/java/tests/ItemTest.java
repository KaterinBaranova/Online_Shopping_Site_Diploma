package tests;

import org.testng.annotations.Test;
import pages.ItemPage;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class ItemTest extends BaseTest {

    @Test
    public void addItemToCartTest() {
        ItemPage itemPage = new ItemPage(driver);
        driver.get(ITEM_URL);
        itemPage.clickAddToCart();
        assertTrue(itemPage.isCheckoutFrameDisplayed(), "Checkout popup was not displayed");
    }

    @Test
    public void addSeveralItemsToCartTest() {
        ItemPage itemPage = new ItemPage(driver);
        driver.get(ITEM_URL);
        itemPage.setQuantity(3);
        itemPage.setSize("M");
        itemPage.setColor("Orange");
        itemPage.clickAddToCart();
        assertEquals(itemPage.getQuantityFromCartFrame(), 3, "Quantity doesn't match to values in the cart frame");
        assertEquals(itemPage.getSizeFromCartFrame(), "M", "Size doesn't match to values in the cart frame");
        assertEquals(itemPage.getColorFromCartFrame(), "Orange", "Color doesn't match to values in the cart frame");
    }

    @Test
    public void selectColorTest() {
        ItemPage itemPage = new ItemPage(driver);
        driver.get(ITEM_URL);
        itemPage.setColor("Blue");
        itemPage.clickAddToCart();
        assertEquals(itemPage.getColorFromCartFrame(), "Blue", "Color doesn't match to values in the cart frame");
    }
}
