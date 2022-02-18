package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import setup.Action;

public abstract class BasePage {
    private final Action action;
    public WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Action(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    Action getActions() {
        return action;
    }
}

