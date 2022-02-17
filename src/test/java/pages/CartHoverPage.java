package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CartHoverPage extends BasePage {

    @FindBy (css ="dt[class*=\"item\"]")
    public List<WebElement> cartItem;

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
        return cartItem.size();
    }

    public void clickCheckOutBtn() {
        getActions().hover().moveToElement(enableHoverElement).build().perform();
        getActions().click(checkOutButton);
    }

    public void clickRemoveFromHover() {
        getActions().hover().moveToElement(enableHoverElement).build().perform();
        getActions().click(removeFromHover);
    }
}
