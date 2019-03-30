package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.MortgageCalcPage;
import util.DriverManager;

public class MortgageCalcSteps {

    MortgageCalcPage mortgageCalcPage = new MortgageCalcPage();

    @Then("проверить, что на странице есть заголовок Ипотечный калькулятор")
    public void ckeckTitle(){
        Assert.assertEquals("Ипотечный калькулятор", mortgageCalcPage.mortgageCalcTitle.getText());
    }

    @When("выбираем город объекта недвижимости \"(.*)\"")
    public void selectRegionMortgage(String region){
        DriverManager.getDriver().findElement(By.xpath("//span[@id='form_city-button']")).click();
        Select select = new Select(DriverManager.getDriver().findElement(By.xpath("//span[@id='form_city-button']")));
        select.selectByVisibleText(region);
    }

}