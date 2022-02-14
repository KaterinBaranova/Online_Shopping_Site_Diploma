package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static java.util.UUID.randomUUID;
import static org.testng.Assert.assertTrue;



public class WishListTest extends BaseTest {

    private ItemPage itemPage;
    private SignInPage signInPage;
    private WishlistPage wishlistPage;


    @BeforeMethod
    public void navigate() {
        itemPage = new ItemPage (driver);
        itemPage.open();
        signInPage = new SignInPage(driver);
        wishlistPage = new WishlistPage(driver);
    }

    @Test
    public void createAndUpdateWishlist() {
        signInPage.clickSignInLink();
        signInPage.signInWithCredentials(LOGIN, PASSWORD);
        // create wishlist test
        signInPage.openWishListPage();
        String wishlistName = String.valueOf(randomUUID()).substring(0, 8);
        wishlistPage.create(wishlistName);
        assertTrue(wishlistPage.isWishlistPresent(wishlistName), "Specified Wishlist was not found");
        // update wishlist test
        wishlistPage.openFirstTopSellingItem();
        itemPage.clickAddToWishlist();
        assertTrue(itemPage.isFancyBoxTextDisplayed(), "Added to your wishlist.");
    }
}


