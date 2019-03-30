package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MortgageCalcPage extends BasePage {

    @FindBy(xpath = "//h1[@class='e-title e-title--h2']")
    public WebElement mortgageCalcTitle;

    @FindBy(xpath = "//select[@id='form_city']/option")
    public List<WebElement> regionsList;
}