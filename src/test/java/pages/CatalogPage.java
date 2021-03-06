package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends BasePage{


    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public void openItem(String productName) {
        driver.findElement(By.xpath(String.format("//a[contains(text (), '%s' )]", productName))).click();
    }

}
