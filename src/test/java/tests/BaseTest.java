package tests;

import configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.Site;
import utils.Driver;
import utils.Log;

import java.util.Properties;

public class BaseTest {

    public  WebDriver driver;
    Site site;
    public Driver driverUtil ;
    ConfigReader cp;
    Properties prop;

    @BeforeClass(alwaysRun = true)
    @Parameters(value={"lang"})
    public void BeforeClass(String lang){
        cp = new ConfigReader();
        prop = cp.initLangProp(lang);
    }

    @Parameters(value={"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browserName) {
        Log.info("Running Before Method");
        driverUtil =  new Driver();
        Log.info("Instantiating Driver");
        driver = driverUtil.instantiateDriver(browserName);
        site = new Site(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver == null)
            return;
        Log.info("Quitting driver");
        driver.quit();
    }


}
