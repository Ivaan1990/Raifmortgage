package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverManager;

import java.util.List;

public abstract class BasePage {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 60);

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void selectMenuItem(List<WebElement> items, String itemName){
        for(WebElement element : items){
            if (element.getText().equalsIgnoreCase(itemName)){
                element.click();
                return;
            }
        }
        Assert.fail("Не найден элемент коллекции " + itemName);
    }
    public void scrollPage(String xPath){
        ((JavascriptExecutor)DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView();", DriverManager.getDriver()
                        .findElement(By.xpath(xPath)));
    }
}