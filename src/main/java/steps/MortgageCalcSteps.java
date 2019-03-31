package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import pages.BasePage;
import pages.MortgageCalcPage;
import util.DriverManager;
import java.util.concurrent.TimeUnit;

public class MortgageCalcSteps {

    MortgageCalcPage mortgageCalcPage = new MortgageCalcPage();
    WebDriver driver = DriverManager.getDriver();
    static WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);

    @Then("проверить, что на странице есть заголовок Ипотечный калькулятор")
    public void ckeckTitle(){
        Assert.assertEquals("Ипотечный калькулятор", mortgageCalcPage.mortgageCalcTitle.getText());
    }

    @When("выбираем город объекта недвижимости \"(.*)\"")
    public void selectRegionMortgage(String region){
        driver.findElement(By.xpath("//span[@id='form_city-button']/parent::div")).click();
        mortgageCalcPage.selectMenuItem(mortgageCalcPage.regionsList, region);
    }

    @When("ставим чекбокс Знаю свою ипотечную программу")
    public void iNowMyMortgageProg(){
        mortgageCalcPage.checkBox.click();
        mortgageCalcPage.scrollPage("//span[contains(@class, 'checkbox-block__span')]");
    }

    @When("вид ипотечной программы \"(.*)\"")
    public void selectMortgageProgram(String program){
        mortgageCalcPage.waitRaifHelper();
        wait.until(ExpectedConditions.elementToBeClickable(
                DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'Вид ипотечной программы')]/../..")))).click();
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//ul[@id='form_program-menu']//li/div[text()='" + program + "']")))).click();
    }

    @When("кем является клиент \"(.*)\"")
    public void clientStatus(String status){
        mortgageCalcPage.waitRaifHelper();
        wait.until(ExpectedConditions.elementToBeClickable(
                DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'Я являюсь')]/..")))).click();
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//ul[@id='form_category-menu']//li/div[text()='" + status + "']")))).click();
    }

    @When("форма подтверждения доходов \"(.*)\"")
    public void formType(String type){
        mortgageCalcPage.waitRaifHelper();
        wait.until(ExpectedConditions.elementToBeClickable(
                DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'Уровень')]/..")))).click();
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//ul[@id='form_documents-menu']//li/div[text()='" + type + "']")))).click();
    }

    @When("возьму в банке \"(.*)\"")
    public void inputAmount(String amount){
        mortgageCalcPage.waitRaifHelper();
        mortgageCalcPage.creditAmount.click();
        mortgageCalcPage.creditAmount.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        mortgageCalcPage.creditAmount.clear();
        mortgageCalcPage.creditAmount.sendKeys(amount);
    }

    @When("первоначальный взнос \"(.*)\"")
    public void inputFirstPayment(String value){
        mortgageCalcPage.waitRaifHelper();
        mortgageCalcPage.firstPayment.click();
        mortgageCalcPage.creditAmount.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        mortgageCalcPage.firstPayment.clear();
        mortgageCalcPage.firstPayment.sendKeys(value);
    }

    @When("срок кредита \"(.*)\"")
    public void inputCreditTerm(String term){
        mortgageCalcPage.waitRaifHelper();
        mortgageCalcPage.creditTerm.click();
        mortgageCalcPage.creditAmount.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        mortgageCalcPage.creditTerm.clear();
        mortgageCalcPage.creditTerm.sendKeys(term);
        mortgageCalcPage.scrollPage("//*[contains(text(),'Я являюсь')]");
    }

    @Then("нажать на Рассчитать")
    public void pushCalculate(){
        mortgageCalcPage.calc.click();
    }

    /**
     * @see #correct(String)
     */
    @Then("проверить значения Ежемесячный платеж, Общая сумма выплат, Cумма выплат по процентам, Процентная ставка")
    public void checkTheFields(){

        String expectedMontlyPayment = "40656.67";
        String totalSumPayment = "4838438.93";
        String sumOfPaymentPercent = "1838438.93";
        String interestRate = "10.49";

        mortgageCalcPage.waitRaifHelper();

        Assert.assertEquals("Сумма ежемесячного платежа не совпадает с требуемой ",
                expectedMontlyPayment, correct(mortgageCalcPage.actualMontlyPayment.getText()));

        Assert.assertEquals("Общая сумма выплат не совпадает с требуемой",
                totalSumPayment, correct(mortgageCalcPage.actualTotalPay.getText()));

        Assert.assertEquals("Cумма выплат по процентам не совпадает с требуемой",
                sumOfPaymentPercent, correct(mortgageCalcPage.actualSumOfPaymentPercent.getText()));

        Assert.assertEquals("Процентная ставка не совпадает с требуемой",
                interestRate, correct(mortgageCalcPage.actualInterestRate.getText()));
    }

    /**
     *
     * @param line строка в которой хотим оставить только цифры и точку
     * @return красивая цифра
     */
    public String correct(String line){
        char[] a = line.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < a.length - 1; i++){
            if(Character.isDigit(a[i]) || a[i] == '.'){
                builder.append(a[i]);
            }
        }
        return builder.toString();
    }


}