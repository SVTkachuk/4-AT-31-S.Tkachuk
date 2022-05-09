package case_11;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignUpPO {
    private WebDriver driver;


    public SignUpPO(WebDriver driver){
        this.driver=driver;
    }

    public boolean isOpen() {
        return driver.findElement(By.cssSelector("button._42ft._4jy0._6lth._4jy6._4jy1.selected._51sy")).isDisplayed();
    }

    public SignUpPO insertLogin(String login,String pass) {
        driver.findElement(By.cssSelector("input.inputtext._55r1._6luy")).sendKeys(login);
        driver.findElement(By.cssSelector("input.inputtext._55r1._6luy._9npi")).sendKeys(pass);
        return this;
    }

    public void clickSignUp() {
        driver.findElement(By.cssSelector("button._42ft._4jy0._6lth._4jy6._4jy1.selected._51sy")).click();
    }

    public boolean isLogged(){
        String elementClass = "a oajrlxb2 g5ia77u1 qu0x051f esr5mh6w e9989ue4 r7d6kgcz rq0escxv nhd2j8a9 p7hjln8o kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x jb3vyjys rz4wbd8a qt6c0cv9 a8nywdso i1ao9s8h esuyzwwr f1sip0of n00je7tq arfg74bv qs9ysxi8 k77z8yql abiwlrkh p8dawk7l lzcic4wl bp9cbjyn j83agx80 cbu4d94t datstx6m taijpn5t l9j0dhe7 k4urcfbm";
        elementClass = elementClass.replace(" ",".");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementClass)));
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

}