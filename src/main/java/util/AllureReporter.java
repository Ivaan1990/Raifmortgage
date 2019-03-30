package util;

import io.qameta.allure.Attachment;
import io.qameta.allure.cucumberjvm.AllureCucumberJvm;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureReporter extends AllureCucumberJvm {

    @Override
    public void result(gherkin.formatter.model.Result result) {
        if(!result.getStatus().equals("pased") && (!result.getStatus().equals("sipped"))){
            takescreenchot();
        }
        super.result(result);
    }

    @Attachment(type="image/png", value="Скриншот при ошибке")
    public static byte[] takescreenchot(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
