package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ExcelDataProvider;
import utils.Pages;
import utils.SortType;
import utils.TestExecutionListener;

@Listeners(TestExecutionListener.class)
public class SortingTests extends BaseTest{

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Desc Sorting on apts / housing page")
    @Test(dataProvider="SortTestData" , dataProviderClass = ExcelDataProvider.class , groups = {"Eng", "Fr"})
    public void testDescSorting(String sortType){
        site.homePage.navigateToPage(prop.getProperty("apt_housing"));
        site.housingPage.SelectSortType(sortType);
        Assert.assertTrue(site.housingPage.checkPriceSorting (sortType));
        site.housingPage.next_click();
        site.housingPage.SelectSortType(sortType);
        Assert.assertTrue(site.housingPage.checkPriceSorting (sortType));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Default Sorting on apts / housing page after search- invalid")
    @Test(dataProvider="SearchTestData" , dataProviderClass = ExcelDataProvider.class,groups = {"Eng","Fr"})
    public void testAfterSearchSortOptions(String SearchKey) {
        site.homePage.navigateToPage(prop.getProperty("apt_housing"));
        site.housingPage.performSearch(SearchKey);
        Assert.assertTrue(site.housingPage.validateSearchSortOptions(SortType.getPostSearchSortOptions()));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Default Sorting on apts / housing page")
    @Test(groups = {"Eng","Fr"})
    public void testDefaultSorting() {
        site.homePage.navigateToPage(prop.getProperty("apt_housing"));
        Assert.assertTrue(site.housingPage.validateSearchSortOptions(SortType.getPreSearchSortOptions()));
    }


}