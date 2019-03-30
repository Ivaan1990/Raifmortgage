package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import util.DriverManager;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void startScenario(){
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get(properties.getProperty("app.url"));
    }

    @After
    public void afterScenario(){
        //DriverManager.quitDriver();
    }
}