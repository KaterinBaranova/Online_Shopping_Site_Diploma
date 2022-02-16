package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ItemPage;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class ItemTest extends BaseTest {

    private ItemPage itemPage;


    @BeforeMethod
    public void navigate() {
        itemPage = new ItemPage (driver);

    }

    @Test (description = "User is able to check out from cart hover", groups = {"Smoke Test"})
    public void addItemToCartTest() {
        itemPage.openItem(PRODUCT_NAME);
        itemPage.clickAddToCart();
        assertTrue(itemPage.isCheckoutFrameDisplayed(), "Checkout popup was not displayed");
    }

    @Test(description = "User is able to add several items to cart", groups = {"Regression Test"})
    public void addSeveralItemsToCartTest() {
        itemPage.openItem(PRODUCT_NAME);
        itemPage.setQuantity(3);
        itemPage.setSize("M");
        itemPage.setColor("Orange");
        itemPage.clickAddToCart();
        assertEquals(itemPage.getQuantityFromCartFrame(), 3, "Quantity doesn't match to values in the cart frame");
        assertEquals(itemPage.getSizeFromCartFrame(), "M", "Size doesn't match to values in the cart frame");
        assertEquals(itemPage.getColorFromCartFrame(), "Orange", "Color doesn't match to values in the cart frame");
    }

    @Test(description = "User is able to select item color", groups = {"Regression Test"})
    public void selectColorTest() {
        itemPage.openItem(PRODUCT_NAME);
        itemPage.setColor("Blue");
        itemPage.clickAddToCart();
        assertEquals(itemPage.getColorFromCartFrame(), "Blue", "Color doesn't match to values in the cart frame");
    }
}
