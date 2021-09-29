package pages;

import base.Base;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
public class Site extends Base {

    WebDriver driver;
    public Home homePage;
    public Housing housingPage;
    private String pageTitle;

    public Site(WebDriver  driver, Logger log ){
        super(driver,log);
        this.driver=driver;
        setHomePage();
        setHousingPage();
    }

    public void setHomePage() {
        homePage = new Home(driver,log);
    }

    public void setHousingPage() {
        housingPage = new Housing(driver,log);
    }

    public String getPageTitle() {
        return this.pageTitle;
    }

}
