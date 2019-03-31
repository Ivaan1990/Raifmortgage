package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public void delay(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isPresent(By locator){
        try {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            return DriverManager.getDriver().findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }finally {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
    }

}