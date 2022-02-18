package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.ItemPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ItemTest extends BaseTest {

    private ItemPage itemPage;
    private CatalogPage catalogPage;

    public final static String ORANGE= "Orange";
    public final static String BLUE = "Blue";


    @BeforeMethod
    public void navigate() {
        itemPage = new ItemPage (driver);
        catalogPage = new CatalogPage(driver);

    }

    @Test (description = "User is able to check out from cart hover", groups = {"Smoke Test"})
    public void addItemToCartTest() {
        catalogPage.openItem(PRODUCT_NAME);
        itemPage.clickAddToCart();
        assertTrue(itemPage.isCheckoutFrameDisplayed(), "Checkout popup was not displayed");
    }

    @Test(description = "User is able to add several items to cart", groups = {"Regression Test"})
    public void addSeveralItemsToCartTest() {
        catalogPage.openItem(PRODUCT_NAME);
        itemPage.setQuantity(3);
        itemPage.setSize("M");
        itemPage.setColor(ORANGE);
        itemPage.clickAddToCart();
        assertEquals(itemPage.getColorFromCartFrame(), "Orange", "Color doesn't match to values in the cart frame");
        assertEquals(itemPage.getQuantityFromCartFrame(), 3, "Quantity doesn't match to values in the cart frame");
        assertEquals(itemPage.getSizeFromCartFrame(), "M", "Size doesn't match to values in the cart frame");

    }

    @Test(description = "User is able to select item color", groups = {"Regression Test"})
    public void selectColorTest() {
        catalogPage.openItem(PRODUCT_NAME);
        itemPage.setColor(BLUE);
        itemPage.clickAddToCart();
        assertEquals(itemPage.getColorFromCartFrame(), "Blue", "Color doesn't match to values in the cart frame");
    }
}
