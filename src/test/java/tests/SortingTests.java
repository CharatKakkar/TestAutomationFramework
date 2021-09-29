package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Pages;
import utils.SortType;
import utils.TestExecutionListener;

@Listeners(TestExecutionListener.class)
public class SortingTests extends BaseTest{

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Asc Sorting on apts / housing page")
    @Test
    public void TestAscSorting(){
        site.homePage.openPage(Pages.apt_sub);
        Assert.assertTrue(site.housingPage.validateSearchSortOptions(SortType.getPreSearchSortOptions()));
        site.housingPage.SelectSortType(SortType.Ascending);
        Assert.assertTrue(site.housingPage.checkPriceSorting (SortType.Ascending));
        site.housingPage.next_click();
        site.housingPage.SelectSortType(SortType.Ascending);
        Assert.assertTrue(site.housingPage.checkPriceSorting (SortType.Ascending));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Desc Sorting on apts / housing page")
    @Test
    public void TestDescSorting(){
        site.homePage.openPage(Pages.apt_sub);
        site.housingPage.SelectSortType(SortType.Descending);
        Assert.assertTrue(site.housingPage.checkPriceSorting (SortType.Descending));
        site.housingPage.next_click();
        site.housingPage.SelectSortType(SortType.Descending);
        Assert.assertTrue(site.housingPage.checkPriceSorting (SortType.Descending));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Default Sorting on apts / housing page")
    @Test
    public void testDefaultSorting() {
        site.homePage.openPage(Pages.apt_sub);
        Assert.assertTrue(site.housingPage.validateSearchSortOptions(SortType.getPreSearchSortOptions()));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Default Sorting on apts / housing page after search- invalid")
    @Test
    public void testAfterSearchSortOptionsInvalid() {
        log.info(Thread.currentThread().getId() + " testAfterSearchSortOptionsInvalid");
        site.homePage.openPage(Pages.apt_sub);
        site.housingPage.performSearch("abc");
        Assert.assertTrue(site.housingPage.validateSearchSortOptions(SortType.getPostSearchSortOptions()));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Default Sorting on apts / housing page After search-Valid")
    @Test
    public void testAfterSearchSortOptionsValid() {
        log.info(Thread.currentThread().getId() + " testAfterSearchSortOptionsValid");
        site.homePage.openPage(Pages.apt_sub);
        site.housingPage.performSearch("1 bed");
        Assert.assertTrue(site.housingPage.validateSearchSortOptions(SortType.getPostSearchSortOptions()));
    }

}