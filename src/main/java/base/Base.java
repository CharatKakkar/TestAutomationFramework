package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtil;

public class Base {

  public WebDriver driver;
  public ElementUtil elemUtil;

  public Base(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver,this);
    elemUtil = new ElementUtil(driver);
  }

}