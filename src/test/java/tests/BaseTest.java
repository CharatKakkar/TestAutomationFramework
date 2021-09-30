package tests;

import configReader.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.Site;
import utils.Driver;

import java.util.Properties;

public class BaseTest {

    public  WebDriver driver;
    Site site;
    Logger log = LogManager.getLogger();
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
        log.info("Running Before Method");
        driverUtil =  new Driver();
        log.info("Instantiating Driver");
        driver = driverUtil.instantiateDriver(browserName);
        driverUtil.getURl(prop.getProperty("url"));
        site = new Site(driver,log);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver == null)
            return;
        log.info("Quitting driver");
        driver.quit();
    }



}
