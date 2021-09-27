package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home extends Base{

    public Home(){
        PageFactory.initElements(driver,this);
    }

    public By getMainCategoryLocator(String category){
        return By.xpath("//div[@class='" + category + "']");
    }

    public WebElement getCategories(String category){

        return driver.findElement(getMainCategoryLocator(category));
    }

    public List<WebElement> getAllSubCategories(String mainCat, String subCategory){
       return  getCategories(mainCat).findElements(By.xpath("//div[@class='"+ mainCat + "']//span[text()" +
                "='" + subCategory + "']/ancestor::h3/following-sibling::div//li"));
    }

    public void clickSubCategory(String mainCat, String subCategory, String open){

      List<WebElement> list =  getAllSubCategories(mainCat,subCategory);
      for( WebElement item : list){
          if(item.getText().equals(open)){
              item.findElement(By.linkText(open)).click();
              return;
          }

      }

    }


}
