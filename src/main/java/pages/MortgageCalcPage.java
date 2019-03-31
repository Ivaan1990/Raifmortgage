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

    @FindBy(xpath = "//*[@id=\"form_period\"]")
    public WebElement creditTerm;

    @FindBy(xpath = "//*[@value='Рассчитать']")
    public WebElement calc;


    /** Актуальные значения по параметрам предлагаемой ипотеки */

    @FindBy(xpath = "//*[@class=\"monthly-payment\"]")
    public WebElement actualMontlyPayment;

    @FindBy(xpath = "//*[@class=\"b-calc-result__text--right total-payment\"]")
    public WebElement actualTotalPay;

    @FindBy(xpath = "//*[contains(@class, 'percent-sum')]")
    public WebElement actualSumOfPaymentPercent;

    @FindBy(xpath = "//*[contains(@class, 'interest-rate')]")
    public WebElement actualInterestRate;
}