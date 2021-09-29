package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class Driver {

    public Driver(){

    }

    private WebDriver Driver_instance;

    public WebDriver getDriver_instance(){
        return Driver_instance;
    }


    private WebDriver getDriver(String driver){

        switch(driver){

            case "Chrome":
            {
                System.setProperty("webdriver.chrome.driver", Constants.ChromeDriverLocation);
                Driver_instance = new ChromeDriver();
                break;

            }
            case "Firefox":
            {
                System.setProperty("webdriver.gecko.driver", Constants.FFDriverLocation);
                Driver_instance = new FirefoxDriver();
                break;
            }
            default:
            {
                System.setProperty("webdriver.chrome.driver", Constants.ChromeDriverLocation);
                Driver_instance = new ChromeDriver();
                break;
            }

        }
        return Driver_instance;

    }

    public WebDriver  instantiateDriver(String browserDriverName){
        Driver_instance =  getDriver(browserDriverName);
        Driver_instance.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        Driver_instance.manage().window().maximize();
        getURl(Constants.URL);
        return Driver_instance;

    }

    public void getURl(String url){
        Driver_instance.get(url);
    }



}
