package case_12.PO;

import case_12.Decorators.CustomFieldDecorator;
import case_12.Decorators.WebInput;
import case_12.Decorators.WebLink;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OLX_foundPO {

    @FindBy(xpath = "//*[@id=\"courier\"]")
    private WebInput radioButtonDelivery;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/form/div[3]/div[1]/div/div[2]/div/div[1]/div/div[1]/div/input")
    private WebInput priceFromInput;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/form/div[3]/div[1]/div/div[2]/div/div[2]/div/div[1]/div/input")
    private WebInput priceToInput;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/form/div[5]/div/div[2]/div[2]/a")
    private WebLink firstProduct;

    private WebDriver driver;
    private Actions actions;

    public OLX_foundPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(this.driver),this);
        actions = new Actions(driver);
    }

    public void radioButtonsCheck(){
        radioButtonDelivery.inputPress();
    }

    public void selectPrice(String priceFrom, String priceTo){
        priceFromInput.inputText(priceFrom);
        priceToInput.inputText(priceTo);
    }

    public void clickFirstProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement cookie = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[3]/button/span/span"));
        cookie.click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.GoogleActiveViewElement > div")));
        }
        catch (TimeoutException e){
        }
        WebElement firstElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/form/div[5]/div/div[2]/div[2]/a"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/form/div[5]/div/div[2]/div[2]/a")));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstElement);
        actions.perform();
        firstProduct.linkPress();
    }
}
