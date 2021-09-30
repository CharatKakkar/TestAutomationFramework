package base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtil;

public class Base {

  public WebDriver driver;
  public Logger log;
  public ElementUtil elemUtil;

  public Base(WebDriver driver, Logger log){
    this.driver = driver;
    this.log = log;
    PageFactory.initElements(driver,this);
    elemUtil = new ElementUtil(driver);
  }

}