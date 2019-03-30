package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import pages.BasePage;
import pages.MortgageCalcPage;
import util.DriverManager;

import java.util.concurrent.TimeUnit;

import static pages.BasePage.isPresent;

public class MortgageCalcSteps {

    MortgageCalcPage mortgageCalcPage = new MortgageCalcPage();
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);


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
        wait.ignoring(NoSuchElementException.class).until((ExpectedCondition<Boolean>) driver ->
                !isPresent( By.xpath("//*[@class='helpers-params loading']")));
        wait.until(ExpectedConditions.elementToBeClickable(
                DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'Вид ипотечной программы')]/../..")))).click();
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//ul[@id='form_program-menu']//li/div[text()='" + program + "']")))).click();
    }

    @When("кем является клиент \"(.*)\"")
    public void clientStatus(String status){
        wait.ignoring(NoSuchElementException.class).until((ExpectedCondition<Boolean>) driver ->
                !isPresent( By.xpath("//*[@class='helpers-params loading']")));
        wait.until(ExpectedConditions.elementToBeClickable(
                DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'Я являюсь')]/..")))).click();
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//ul[@id='form_category-menu']//li/div[text()='" + status + "']")))).click();
    }

    @When("форма подтверждения доходов \"(.*)\"")
    public void formType(String type){
        wait.ignoring(NoSuchElementException.class).until((ExpectedCondition<Boolean>) driver ->
                !isPresent( By.xpath("//*[@class='helpers-params loading']")));
        wait.until(ExpectedConditions.elementToBeClickable(
                DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'Уровень')]/..")))).click();
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//ul[@id='form_documents-menu']//li/div[text()='" + type + "']")))).click();
    }

    @When("возьму в банке \"(.*)\"")
    public void inputAmount(String amount){
        wait.ignoring(NoSuchElementException.class).until((ExpectedCondition<Boolean>) driver ->
                !isPresent( By.xpath("//*[@class='helpers-params loading']")));
        mortgageCalcPage.creditAmount.click();
        mortgageCalcPage.creditAmount.clear();
        mortgageCalcPage.creditAmount.sendKeys(amount);
        amount = null;
    }

    @When("первоначальный взнос \"(.*)\"")
    public void inputFirstPayment(String value){
        mortgageCalcPage.firstPayment.click();
        mortgageCalcPage.firstPayment.clear();
        mortgageCalcPage.firstPayment.sendKeys(value);

    }

}