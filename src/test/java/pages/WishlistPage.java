package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WishlistPage extends BasePage{

    @FindBy(id = "name")
    private WebElement newWishlistNameField;

    @FindBy(id = "submitWishlist")
    private WebElement submitNewWishlistButton;

    @FindBy(className = "table")
    private WebElement wishlistTable;

    @FindBy(className ="icon-remove")
    private WebElement deleteWishlistItem;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public void createNewWishlist(String wishlistName) {
        getActions().type(newWishlistNameField, wishlistName);
        getActions().click(submitNewWishlistButton);
    }
}
