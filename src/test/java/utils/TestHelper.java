package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.nio.charset.StandardCharsets;

public class TestHelper {

    @Attachment(type = "image/png")
    public static byte[] saveScreenshot(String name, WebDriver driver) {
        return (byte[]) ((TakesScreenshot)  driver).getScreenshotAs(OutputType.BYTES);
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Html source", type = "text/html", fileExtension = ".html")
    public static byte[] getPageSource(WebDriver driver) {
        return driver.getPageSource().getBytes(StandardCharsets.UTF_8);

    }

    public static void checkIsOpen(String currentTitle, String prop){
        Assert.assertTrue(currentTitle.replaceAll("[^a-zA-Z]+","").contains(prop.replaceAll("[^a-zA-Z]+","")),"Actual: " + currentTitle + "Expected: " + prop);
    }

}
