package case_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class UI_TEST{
@Test
   void StackOverFlow(){
    String key = "java";
    ChromeDriverManager.getInstance().setup();
    WebDriver driver = new ChromeDriver();
    //go to the site
    driver.get("https://stackoverflow.com/");
    //go to tags page
    WebElement burgerMenu =  driver.findElement(By.xpath("/html/body/header/div/a[1]"));
    burgerMenu.click();
    WebElement tags = driver.findElement(By.xpath("//*[@id=\"nav-tags\"]"));
    tags.click();
    //filter tags
    WebElement tagFilter = driver.findElement(By.xpath("//*[@id=\"tagfilter\"]"));
    tagFilter.sendKeys(key);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    WebElement tag = null;
    try{
        tag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//a[text()='%s']",key ))));
    }
    catch (TimeoutException e){
        System.out.println("TimeOut");
        driver.quit();
    }
    tag.click();
    //Verify if the tag key is equal to tag title
    WebElement tagTitle =driver.findElement(By.xpath("//*[@id=\"mainbar\"]/div[1]/div[1]/h1"));
    Assert.assertEquals(String.format("Questions tagged [%s]",key),tagTitle.getText(),"wrong tag");
    driver.quit();
    }
}
