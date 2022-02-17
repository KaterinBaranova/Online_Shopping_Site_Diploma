package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ItemPage extends BasePage {

    @FindBy(id = "layer_cart")
    private WebElement cartFrame;

    @FindBy(name = "Submit")
    private WebElement addToCartButton;

    @FindBy(css = "a[title='Proceed to checkout']")
    private WebElement clickOnCheckoutButton;

    @FindBy(name = "qty")
    private WebElement quantityField;

    @FindBy(id = "group_1")
    private WebElement sizesDropdown;

    @FindBy(id = "color_to_pick_list")
    private WebElement colorOptions;

    @FindBy(id = "layer_cart_product_quantity")
    private WebElement quantityInCartFrame;

    @FindBy(id = "layer_cart_product_attributes")
    private WebElement sizeAndColorInCartFrame;

    @FindBy(id = "wishlist_button")
    private WebElement addToWishlist;

    @FindBy(className = "fancybox-error")
    private WebElement fancyBox;

    @FindBy(className = "cross")
    private WebElement closeCartFrame;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        getActions().click(addToCartButton);
    }

    public void clickAddToWishlist() {
        getActions().click(addToWishlist);
    }


    public boolean isCheckoutFrameDisplayed() {
        return getActions().isElementDisplayed(cartFrame);
    }


    public void setQuantity(int count) {
        quantityField.clear();
        getActions().type(quantityField, String.valueOf(count));
    }

    public int getQuantityFromCartFrame() {
        getActions().isElementDisplayed(cartFrame);
        return Integer.parseInt(quantityInCartFrame.getText());
    }

    public void setSize(String size) {
        Select selectList = new Select(sizesDropdown);
        selectList.selectByVisibleText(size);
    }

    public String getSizeFromCartFrame() {
        getActions().isElementDisplayed(cartFrame);
        return sizeAndColorInCartFrame.getText().substring(sizeAndColorInCartFrame.getText().length() - 1);
    }

    public void setColor(String color) {
        List<WebElement> colors = colorOptions.findElements(By.xpath(".//*"));
        for (WebElement colorType : colors) {
            if (colorType.getAttribute("title").equals(color)) {
                getActions().click(colorType);
            }
        }
    }

    public String getColorFromCartFrame() {
        getActions().isElementDisplayed(cartFrame);
        return sizeAndColorInCartFrame.getText().substring(0, sizeAndColorInCartFrame.getText().length() - 3);
    }

    public boolean isFancyBoxTextDisplayed() {
        return getActions().isElementDisplayed(fancyBox);
    }

    public void closeCartFrame() {
        getActions().click(closeCartFrame);
    }

    public void clickOnCheckoutButton() {
        getActions().click(clickOnCheckoutButton);
    }

    public void openItem(String productName) {
        driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]")).click();
    }
}