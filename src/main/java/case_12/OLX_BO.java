package case_12;

import case_12.PO.OLX_HomePO;
import case_12.PO.OLX_ProductPO;
import case_12.PO.OLX_foundPO;
import org.openqa.selenium.WebDriver;

public class OLX_BO {
    private WebDriver driver;
    private OLX_HomePO olxHomePO;
    private OLX_foundPO olxFoundPO;
    private OLX_ProductPO olxProductPO;

    public OLX_BO(WebDriver driver){
        this.driver = driver;
    }

    public void homePage(){
        olxHomePO = new OLX_HomePO(driver);
        olxHomePO.homePage();
    }

    public void findProduct(String product){
        olxHomePO.findProduct(product);
    }

    public void radioButtonsCheck(){
        olxFoundPO = new OLX_foundPO(driver);
        olxFoundPO.radioButtonsCheck();
    }

    public void selectPrice(String priceFrom,String priceTo){
        olxFoundPO.selectPrice(priceFrom,priceTo);
    }

    public void clickFirstProduct(){
        olxFoundPO.clickFirstProduct();
    }

    public int getPrice(){
        olxProductPO = new OLX_ProductPO(driver);
       return olxProductPO.getValue();
    }
}