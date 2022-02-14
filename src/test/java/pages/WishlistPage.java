package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import enums.ColumnNumber;

import java.util.List;


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

    public void create(String wishlistName) {
        getActions().type(newWishlistNameField, wishlistName);
        getActions().click(submitNewWishlistButton);
    }

    public boolean isWishlistPresent(String wishlistName) {
        getActions().isElementDisplayed(wishlistTable);
        return getCell(wishlistName) != null;
    }

    private WebElement getCell(String wishlistName) {
        List<WebElement> allRows = wishlistTable.findElements(By.xpath("//*[contains(@class,\"table\")]/tbody/tr[*]/td[1]"));
        int rowNumberCounter = 1;
        for (WebElement row : allRows) {
            if (row.getText().equals(wishlistName)) {
                return wishlistTable.findElement(By.xpath("//*[contains(@class,\"table\")]/tbody/tr[" + rowNumberCounter + "]/td[" + ColumnNumber.NAME.columnNumber + "]"));
            } else {
                rowNumberCounter++;
            }
        }
        throw new NoSuchElementException("Unable to locate {" + wishlistName + "} wishlist");
    }
}
