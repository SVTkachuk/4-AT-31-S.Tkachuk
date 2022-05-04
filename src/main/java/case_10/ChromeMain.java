package case_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;


public class ChromeMain {
    public static void main(String[] args) throws InterruptedException {
        //String pathDriver = "Drivers/chromedriver.exe";
      //  System.setProperty("webdriver.chrome.driver",pathDriver);
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://stackoverflow.com/");

        //go to tags page
        WebElement burgerMenu =  driver.findElement(By.xpath("/html/body/header/div/a[1]"));
        burgerMenu.click();
        WebElement tags = driver.findElement(By.xpath("//*[@id=\"nav-tags\"]"));
        tags.click();
        //filter tags
       WebElement tagFilter = driver.findElement(By.xpath("//*[@id=\"tagfilter\"]"));
       String key = "java-threadssadasd";
       tagFilter.sendKeys(key);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement tag = null;
        try{
         tag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//a[text()='%s']",key ))));
        }
        catch (TimeoutException e){
            System.out.println("TimeOut");
        }
        tag.click();


    }
}
