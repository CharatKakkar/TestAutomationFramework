package tests;

import utils.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Listeners(TestExecutionListener.class)
public class SortingTests extends BaseTest{

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Default Sorting works on apts / housing page")
    @Test(dataProvider="SortTestData" , dataProviderClass = ExcelDataProvider.class , groups = {"Eng", "Fr"})
    public void validateDefaultSorting(String sortType){
        driverUtil.getURl(prop.getProperty("url"));
        TestHelper.checkIsOpen(driver.getTitle(),prop.getProperty("home_title"));
        site.homePage.navigateToPage(prop.getProperty("apt_housing"));
        TestHelper.checkIsOpen(driver.getTitle(),prop.getProperty("apt_housing_title"));
        site.housingPage.SelectSortType(sortType);
        Log.error(driver.getTitle());
        Assert.assertTrue(site.housingPage.checkPriceSorting (sortType));
        site.housingPage.next_click();
        site.housingPage.SelectSortType(sortType);
        Assert.assertTrue(site.housingPage.checkPriceSorting (sortType));
    }


    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Default Sorting is available on apts / housing page after search")
    @Test(dataProvider="SearchTestData" , dataProviderClass = ExcelDataProvider.class,groups = {"Eng","Fr"})
    public void validateAfterSearchSortOptions(String SearchKey) {
        driverUtil.getURl(prop.getProperty("url"));
        TestHelper.checkIsOpen(driver.getTitle(),prop.getProperty("home_title"));
        site.homePage.navigateToPage(prop.getProperty("apt_housing"));
        TestHelper.checkIsOpen(driver.getTitle(),prop.getProperty("apt_housing_title"));
        site.housingPage.performSearch(SearchKey);
        List<String> validationResult = site.housingPage.validateSearchSortOptions(SortType.getPostSearchSortOptions());
        Assert.assertTrue( validationResult.size() == 0, "Sorting options are absent: " + Arrays.toString(validationResult.toArray()));

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Default Sorting possibilities are available on apts / housing page")
    @Test(groups = {"Eng","Fr"})
    public void validateDefaultSorting() {
        driverUtil.getURl(prop.getProperty("url"));
        TestHelper.checkIsOpen(driver.getTitle(),prop.getProperty("home_title"));
        site.homePage.navigateToPage(prop.getProperty("apt_housing"));
        TestHelper.checkIsOpen(driver.getTitle(),prop.getProperty("apt_housing_title"));
        List<String> validationResult = site.housingPage.validateSearchSortOptions(SortType.getPreSearchSortOptions());
        Assert.assertTrue( validationResult.size() == 0, "Sorting options are absent: " + Arrays.toString(validationResult.toArray()));

    }

}