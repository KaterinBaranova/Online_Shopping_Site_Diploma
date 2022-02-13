package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;


public class CartHoverPage extends BasePage<CartHoverPage> {

    @FindBy(className = "shopping_cart")
    private WebElement cartHover;

    @FindBy(id = "button_order_cart")
    private WebElement checkOutButton;

    @FindBy(css = ".shopping_cart > a")
    private WebElement enableHoverElement;

    @FindBy(className ="remove_link")
    private WebElement removeFromHover;

    public CartHoverPage(WebDriver driver) {
        super(driver,"index.php?id_product=2&controller=product");
    }

    @Override
    protected void isLoaded() throws Error {

    }

    private WebElement getCartHoverItem(String productName) {
        List<WebElement> cartList = getCartItems();
        for (WebElement cartItem : cartList) {
            if (cartItem.findElement(By.cssSelector("[title]")).getAttribute("title").contains(productName)) {
                return cartItem;
            }
        }
        throw new NoSuchElementException("Unable to locate {" + productName + "} product in cart");
    }

    public int getCartHoverNumberInCart() {
        return getCartItems().size();
    }

    private List<WebElement> getCartItems() {
        return cartHover.findElements(By.cssSelector("dt[class*=\"item\"]"));
    }

    public boolean removeItemFromCart(String productName) {
        WebElement itemToRemove = getCartHoverItem(productName).findElement(By.className("remove_link"));
        getActions().hover().moveToElement(enableHoverElement).build().perform();
        getActions().click(itemToRemove);
        return getActions().isElementNotDisplayed(itemToRemove);
    }

    public void checkOut() {
        getActions().hover().moveToElement(enableHoverElement).build().perform();
        getActions().click(checkOutButton);
    }

    public void removeFromHover() {
        getActions().hover().moveToElement(enableHoverElement).build().perform();
        getActions().click(removeFromHover);
    }
}
