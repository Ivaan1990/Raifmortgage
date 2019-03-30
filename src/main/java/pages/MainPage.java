package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(xpath = "//*[contains(text(), 'Да')]")
    public WebElement acceptRegion;

    @FindBy(xpath = "//ul[@class='main-menu']//li")
    public List<WebElement> mainMenu;

    @FindBy(xpath = "//*[contains(@class, 'menu-link main-menu__link')][starts-with(@href, '/retail/mortgageloans/')]")
    public List<WebElement> subMenu;

}