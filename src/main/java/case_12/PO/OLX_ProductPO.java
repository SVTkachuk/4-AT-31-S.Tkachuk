package case_12.PO;

import case_12.Decorators.CustomFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OLX_ProductPO {
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[3]/div[3]/div[1]/div[2]/div[3]/h3")
    private WebElement productPrice;

    private WebDriver driver;
    private Actions actions;

    public OLX_ProductPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(this.driver),this);
        actions = new Actions(driver);
    }

    public int getValue(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/img")));
        }
        catch (TimeoutException e){
        }
        String price = productPrice.getText();
        price = price.replace(" грн.","");
        System.out.println(price);
        return Integer.parseInt(price);
    }

}
