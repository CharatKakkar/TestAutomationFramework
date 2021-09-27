package Tests;

import base.Base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;
import pages.SubCat.SubClassImpl;
import utils.Constants;
import utils.SortType;

import java.util.List;

public class HomeTest extends  Base{
    Home home;
    SubClassImpl subClass;

    @BeforeMethod
    public void setUp() {
        home =new Home();
        subClass = new SubClassImpl();
        home.getURl(Constants.URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testWebDriver(){
        home.getURl(Constants.URL);
        WebElement cat  = home.getCategories("housing");
        List<WebElement> list  =  home.getAllSubCategories("housing","housing");
        System.out.println(list.size());
         home.clickSubCategory("housing","housing","apts / housing");
    }

    @Test
    public void testWebDriver_2(){
        home.getURl(Constants.URL);
        home.clickSubCategory("community","services","cycle");
    }

    @Test
    public void testWebDriver_WithSorting(){

        WebElement cat  = home.getCategories("housing");
        List<WebElement> list  =  home.getAllSubCategories("housing","housing");
        System.out.println(list.size());
        home.clickSubCategory("housing","housing","apts / housing");
        subClass.SelectSortType(SortType.Ascending);

    }

    @Test
    public void testWebDriver_2_sorting() {
        home.getURl(Constants.URL);
        home.clickSubCategory("housing","for sale","tools");
        Assert.assertTrue(subClass.validatePreSearchSortOptions());
        subClass.SelectSortType(SortType.Ascending);
        Assert.assertTrue(subClass.checkPriceSorting (SortType.Ascending));
        subClass.next_click();
        subClass.SelectSortType(SortType.Descending);
        Assert.assertTrue(subClass.checkPriceSorting (SortType.Descending));
    }

    @Test
    public void testWebDriver_2_search() {
        home.getURl(Constants.URL);
        home.clickSubCategory("housing","housing","apts / housing");
        subClass.performSearch("abc");
        Assert.assertTrue(subClass.validateSearchSortOptions(SortType.getPostSearchSortOptions()));

    }

}