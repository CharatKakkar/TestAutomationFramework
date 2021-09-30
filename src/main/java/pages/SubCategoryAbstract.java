package pages;

import base.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Helper;
import utils.Log;

import java.util.List;

public abstract class SubCategoryAbstract extends Base {

    public final static String DataSelectionAttribute= "data-selection";

    public SubCategoryAbstract(WebDriver driver){
        super(driver);
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

    @Step("Selecting Sort type {0}")
    public void SelectSortType(String type){
        sortOption_click();
        for (WebElement sortSelectOption : sortSelectOptions) {
            if (sortSelectOption.getAttribute(DataSelectionAttribute).equals(type)) {
                sortSelectOption.click();
                break;
            }
        }
    }

    public void sortOption_click(){
        sortSelect.click();
    }


    @Step("Click Next")
    public void next_click(){
        if(next.isDisplayed()){
            next.click();
        }
    }

    public void searchButton_click(){
        searchButton.click();
    }

    @Step("Perform search for - {0}")
    public void performSearch(String keys){
        Log.info("Searching:" + keys);
        searchField.sendKeys(keys);
        searchButton_click();
    }

    @Step("Verify results are sorted by: {0}")
    public boolean checkPriceSorting(String sortType){
        return Helper.verifyPriceSorting(sortType,results,resultPriceLocator());
    }

    @Step("Validate Search Sort Options: {0}")
    public List<String> validateSearchSortOptions(List<String> optionsToValidate){
        return Helper.validateSearchSortOptions(optionsToValidate,sortSelectOptions);
    }

    private By resultPriceLocator(){
        return elemUtil.getBy("xpath","//div[@class='result-info']//span[@class='result-price']");
    }

}
