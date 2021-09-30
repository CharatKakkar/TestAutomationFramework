package pages;

import base.Base;
import org.openqa.selenium.WebDriver;

public class Site extends Base {

    WebDriver driver;
    public Home homePage;
    public Housing housingPage;


    public Site(WebDriver  driver ){
        super(driver);
        this.driver=driver;
        setHomePage();
        setHousingPage();

    }

    public void setHomePage() {
        homePage = new Home(driver);
    }

    public void setHousingPage() {
        housingPage = new Housing(driver);
    }

}
