package case_12.PO;

import case_12.Decorators.CustomFieldDecorator;
import case_12.Decorators.WebInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class OLX_HomePO {

    @FindBy(xpath = "//*[@id=\"headerSearch\"]")
    private WebInput inputSearch;
    @FindBy(xpath = "//*[@id=\"submit-searchmain\"]")
    private WebInput inputSubmit;

    private WebDriver driver;


    public OLX_HomePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(this.driver),this);
    }

    public void homePage(){
        driver.manage().window().maximize();
        driver.get("https://www.olx.ua/");
    }



    public void findProduct(String product){
        inputSearch.inputText(product);
        inputSubmit.inputPress();
    }


}
