package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Base{

  public Base(){
    WebDriver driver = new ChromeDriver();
    System.out.print("In Base..");
  }
}