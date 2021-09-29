package tests;

import Log.Log;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.Site;
import utils.Constants;
import utils.Driver;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    public  WebDriver driver;
    Site site;
    Logger log = LogManager.getLogger();
    public Driver driverUtil ;

    @Parameters(value={"browserName"})
    @BeforeMethod
    public void setUp(String browserName) {
        log.info("Running Before Method");
        driverUtil =  new Driver();
        log.info("Instantiating Driver");
        driver = driverUtil.instantiateDriver(browserName);
        site = new Site(driver,log);
    }

    @AfterMethod()
    public void tearDown() {
        if (driver == null)
            return;
        log.info("Quitting driver");
        driver.quit();
    }


}
