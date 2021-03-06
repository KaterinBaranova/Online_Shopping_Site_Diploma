package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
        return Integer.parseInt(quantityInCartFrame.getText());
    }

    public void setSize(String size) {
        Select selectList = new Select(sizesDropdown);
        selectList.selectByVisibleText(size);
    }

    public String getSizeFromCartFrame() {
        return sizeAndColorInCartFrame.getText().substring(sizeAndColorInCartFrame.getText().length() - 1);
    }

    public void setColor(String color) {
        driver.findElement(By.xpath(String.format("//*[@id='color_to_pick_list']/li/a[@title='%s']", color))).click();

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
}