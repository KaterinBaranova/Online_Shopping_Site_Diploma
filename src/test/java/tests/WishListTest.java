package tests;

import org.testng.annotations.Test;
import pages.ItemPage;
import pages.SignInPage;
import pages.WishlistPage;

import static java.util.UUID.randomUUID;
import static org.testng.Assert.assertTrue;



public class WishListTest extends BaseTest {

    @Test
    public void createAndUpdateWishlist() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickSignInLink();
        signInPage.signInWithCredentials(LOGIN, PASSWORD);
        // create wishlist test
        WishlistPage wishlistPage = signInPage.openWishListPage();
        String wishlistName = String.valueOf(randomUUID()).substring(0, 8);
        wishlistPage.create(wishlistName);
        assertTrue(wishlistPage.isWishlistPresent(wishlistName), "Specified Wishlist was not found");
        // update wishlist test
        ItemPage itemPage = wishlistPage.openFirstTopSellingItem();
        itemPage.clickAddToWishlist();
        assertTrue(itemPage.getFancyBoxText(), "Added to your wishlist.");
    }
}


