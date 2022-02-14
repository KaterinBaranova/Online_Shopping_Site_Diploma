package setup;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Action {

    private final WebDriver driver;

    public Action(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }
    public org.openqa.selenium.interactions.Actions hover() {
        return new org.openqa.selenium.interactions.Actions(driver);
    }

    boolean isElementDisplayed(WebElement element, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    void type(WebElement element, String text, Integer timeout) {
        isElementDisplayed(element, timeout);
        element.sendKeys(text);
    }

    public void type(WebElement element, String text) {
        type(element, text, 5);
    }


    public boolean isElementDisplayed(WebElement element) {
        return isElementDisplayed(element ,5);
    }
    }

