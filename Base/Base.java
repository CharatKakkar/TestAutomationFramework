package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constants;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class Base{

  public WebDriver driver;

  public Base(){
    System.setProperty("webdriver.chrome.driver", Constants.ChromeDriverLocation);
    driver =  Driver.getDriver_instance("Chrome");
    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    System.out.print("In Base..");
  }

  public void getURl(String url){

    driver.get(url);
  }
}