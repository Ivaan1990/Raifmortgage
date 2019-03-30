package steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import util.DriverManager;

public class MainSteps {
    MainPage mainPage = new MainPage();

    @When("подтвержден регион")
    public void acceptRegion(){
        mainPage.acceptRegion.click();
    }

    @When("выбран пункт меню \"(.*)\"")
    public void selectMainMenu(String itemName){
        mainPage.selectMenuItem(mainPage.mainMenu, itemName);
    }

    @When("выбран подпункт меню ипотека \"(.*)\"")
    public void selectSubMenu(String itemName){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
        mainPage.selectMenuItem(mainPage.subMenu, itemName);
    }

}