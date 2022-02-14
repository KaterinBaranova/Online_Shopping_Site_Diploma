package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CartHoverPage extends BasePage {

    @FindBy(className = "shopping_cart")
    private WebElement cartHover;

    @FindBy(id = "button_order_cart")
    private WebElement checkOutButton;

    @FindBy(css = ".shopping_cart > a")
    private WebElement enableHoverElement;

    @FindBy(className ="remove_link")
    private WebElement removeFromHover;

    public CartHoverPage(WebDriver driver) {
        super(driver);
    }

    public int getCartHoverNumberInCart() {
        return getCartItems().size();
    }

    private List<WebElement> getCartItems() {
        return cartHover.findElements(By.cssSelector("dt[class*=\"item\"]"));
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
