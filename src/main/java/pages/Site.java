package pages;

import base.Base;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

public class Site extends Base {

    WebDriver driver;
    public Home homePage;
    public Housing housingPage;


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

}
