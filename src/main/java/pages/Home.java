package pages;

import base.Base;
import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Home extends Base{

    public Home(WebDriver driver, Logger log){
        super(driver,log);
    }

    @Step("Open Page - {0} ")
    public void openPage(String cat){
        driver.findElement(By.linkText(cat)).click();
    }
}
