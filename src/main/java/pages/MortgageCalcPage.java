package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MortgageCalcPage extends BasePage {

    @FindBy(xpath = "//h1[@class='e-title e-title--h2']")
    public WebElement mortgageCalcTitle;

    @FindBy(xpath = "//ul[@aria-labelledby=\"form_city-button\"]//li")
    public List<WebElement> regionsList;

    @FindBy(xpath = "//span[contains(@class, 'checkbox-block__span')]")
    public WebElement checkBox;

    @FindBy(xpath = "//*[@id='form_category']")
    public WebElement clientStatus;

    @FindBy(xpath = "//*[@id=\"form_credit_amount\"]")
    public WebElement creditAmount;

    @FindBy(xpath = "//*[@id=\"form_initial\"]")
    public WebElement firstPayment;

}