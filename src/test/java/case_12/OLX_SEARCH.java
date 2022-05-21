package case_12;

import BrowserFactrory.BrowserFactory;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class OLX_SEARCH {
    public WebDriver driver;

    @BeforeTest
    public void driverInit(){
        driver = BrowserFactory.getDriver();
    }

    @Test
    public void OLX_SearchTest(){
        int priceFrom = 100;
        int priceTo = 1000;
        String product = "Nike";

        OLX_BO olx_bo =new OLX_BO(driver);

        olx_bo.homePage();

        olx_bo.findProduct(product);

        olx_bo.radioButtonsCheck();

        olx_bo.selectPrice(Integer.toString(priceFrom),Integer.toString(priceTo));

        olx_bo.clickFirstProduct();

        Assert.assertTrue(olx_bo.getPrice()>100,"Lower");
        Assert.assertTrue(olx_bo.getPrice()<1000,"Higher");

    }

    @AfterTest
    void closeDriver(){
        BrowserFactory.getDriver().close();
        BrowserFactory.getDriver().quit();
    }
}
