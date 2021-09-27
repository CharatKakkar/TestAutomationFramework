package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private Driver(){

    }

    private static WebDriver Driver_instance;

    public static WebDriver getDriver_instance(String driver){
        if(Driver_instance == null){
            Driver_instance = getDriver(driver);
        }

        return Driver_instance;
    }


    private static WebDriver getDriver(String driver){

        switch(driver){

            case "Chrome":
            {
                Driver_instance = new ChromeDriver();
                return Driver_instance;
            }
            case "Firefox":
            {
                Driver_instance = new FirefoxDriver();
                return Driver_instance;
            }
            default:
            {
                //src Exception(src IllegalArgumentException());
                return null;
            }

        }


    }

}
