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
        signInPage = new SignInPage(driver);
        wishlistPage = new WishlistPage(driver);
    }

    @Test(description = "User is able to create and update wishlist", groups = {"Smoke Test"})
    public void createAndUpdateWishlist() {
        String productName = "Faded Short Sleeve T-shirts";
        String wishlistName = String.valueOf(randomUUID()).substring(0, 8);

        signInPage.clickSignInLink();
        signInPage.signInWithCredentials(LOGIN, PASSWORD);
        // create wishlist test
        signInPage.openWishListPage();
        wishlistPage.createNewWishlist(wishlistName);
        assertTrue(wishlistPage.isWishlistPresent(wishlistName), "Specified Wishlist was not found");
        // update wishlist test
        itemPage.openItem(productName);
        itemPage.clickAddToWishlist();
        assertTrue(itemPage.isFancyBoxTextDisplayed(), "Added to your wishlist.");
    }
}


