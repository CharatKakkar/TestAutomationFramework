package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class TestExecutionListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        //WebDriver webDriver = ((BaseTest) currentClass).driverUtil.getDriver_instance();
        WebDriver webDriver = ((BaseTest) currentClass).driverUtil.getDriver_instance();
        saveScreenshot("name",webDriver);
        //TestHelper.saveScreenshot("save", webDriver);
    }


    @Attachment(type = "image/png")
    public static byte[] saveScreenshot(String name, WebDriver driver) {
        return (byte[]) ((TakesScreenshot)  driver).getScreenshotAs(OutputType.BYTES);
    }

}
