package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MortgageCalcPage;
import util.DriverManager;

public class MortgageCalcSteps {

    MortgageCalcPage mortgageCalcPage = new MortgageCalcPage();
    WebDriver driver = DriverManager.getDriver();

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
        mortgageCalcPage.checkBox.click();
        //mortgageCalcPage.scrollPage("//span[contains(@class, 'checkbox-block__span')]");
    }

    @When("вид ипотечной программы \"(.*)\"")
    public void selectMortgageProgram(String program){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
//        WebElement element = DriverManager.getDriver().findElement(By.xpath("//select[@id='form_program'] "));
       // wait.until(ExpectedConditions.visibilityOf(element));
        DriverManager.getDriver().findElement(By.xpath("//select[@name='form[program]']")).click();
        //mortgageCalcPage.selectMenuItem(mortgageCalcPage.mortaggePrograms, program);
    }

}