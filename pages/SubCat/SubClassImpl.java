package pages.SubCat;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;
import utils.Helper;
import utils.SortType;

import java.util.LinkedList;
import java.util.List;

public class SubClassImpl extends Base implements ISubCategory {

    public SubClassImpl(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='search-sort']//ul//li//a")
    List<WebElement> sortSelectOptions;

    @FindBy(xpath = "//div[@class='search-sort']//ul")
    WebElement sortSelect;

    @FindBy(xpath = "//ul[@id='search-results']//li")
    List<WebElement> results;

    @FindBy(xpath= "(//span[@class='button next'])[1]")
    WebElement next;

    @FindBy(id="query")
    WebElement searchField;

    @FindBy(xpath="//button[contains(@class,'searchbtn')]")
    WebElement searchButton;

    By resultPriceLocator = By.xpath("//div[@class='result-info']//span[@class='result-price']");



/*    public WebElement getSortLink(WebElement elm, String  sortType){
        return  elm.findElement(By.xpath("//a[@data-selection='" + sortType + "']"));
    }*/

    public void SelectSortType(String type){
        sortOption_click();
        for (WebElement sortSelectOption : sortSelectOptions) {
            if (sortSelectOption.getAttribute(Constants.DataSelectionAttribute).equals(type)) {
                sortSelectOption.click();
                break;
            }
        }
    }

    public void sortOption_click(){
        sortSelect.click();
    }

    public boolean checkPriceSorting(String sortType){

        return verifyPriceSorting(sortType,results);
    }

    public boolean verifyPriceSorting(String sortType, List<WebElement> results ){

        List<Integer> priceList = new LinkedList<>();

        results.forEach(webElement -> {
           String txt =  webElement.findElement(resultPriceLocator).getText();
           priceList.add(Helper.getPriceFromText(txt));
        });

       return  Helper.isListSorted(sortType,priceList);
    }

    public void next_click(){
        if(next.isDisplayed()){
            next.click();
        }
    }

    public boolean validatePreSearchSortOptions(){
        List<String> list =  SortType.getPreSearchSortOptions();
        List<String> optionsLocated = new LinkedList<>();
            sortSelectOptions.forEach(elm -> {
                optionsLocated.add(elm.getAttribute(Constants.DataSelectionAttribute));
            });

        if(!optionsLocated.containsAll(list)){
            list.removeAll(optionsLocated);
            list.forEach(s -> {
                System.out.println(s);
            });
            return false;
        }
        return true;
    }


    public boolean validateSearchSortOptions(List<String> optionsToValidate){
        List<String> list =  optionsToValidate;
        List<String> optionsLocated = new LinkedList<>();
        sortSelectOptions.forEach(elm -> {
            optionsLocated.add(elm.getAttribute(Constants.DataSelectionAttribute));
        });

        if(!optionsLocated.containsAll(list)){
            list.removeAll(optionsLocated);
            list.forEach(s -> {
                System.out.println(s);
            });
            return false;
        }
        return true;
    }



    public void searchButton_click(){
        searchButton.click();
    }

    public void performSearch(String keys){
        searchField.sendKeys(keys);
        searchButton_click();

    }

}
