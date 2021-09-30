package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class TestExecutionListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).driverUtil.getDriver_instance();
        TestHelper.saveScreenshot("saveImage", webDriver);
        TestHelper.getPageSource(webDriver);
    }

}
