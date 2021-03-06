package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(className = "logout")
    private WebElement signOutLink;

    @FindBy(className = "login")
    private WebElement signInLink;

    @FindBy(className = "alert-danger")
    private WebElement errorMessage;

    @FindBy(className = "lnk_wishlist")
    private WebElement wishListButton;


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void signInWithCredentials(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        getActions().click(signInButton);
    }


    public void signOut() {
        getActions().click(signOutLink);

    }

    public void clickSignInLink() {
        getActions().click(signInLink);

    }

    public boolean isSignInLinkDisplayed() {
        return getActions().isElementDisplayed(signInButton);
    }

    public boolean isSignOutLinkDisplayed() {
        return getActions().isElementDisplayed(signOutLink);
    }

    public boolean isErrorMessageDisplayed() {
        return getActions().isElementDisplayed(errorMessage);
    }

    public WishlistPage openWishListPage() {
        getActions().click(wishListButton);
        return new WishlistPage(driver);
    }
}