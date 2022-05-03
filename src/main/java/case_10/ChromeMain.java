package case_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;


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
       tagFilter.sendKeys("java");
       //chose the first related tag
        Thread.sleep(2000);
        WebElement firstTag = driver.findElement(By.xpath("//*[@id=\"tags-browser\"]/div[1]/div[1]/div/a"));
        firstTag.click();
        //filter questions
        WebElement questionFilter = driver.findElement(By.xpath("//*[@id=\"mainbar\"]/div[4]/div/div[2]/div/div[3]/button"));
        questionFilter.click();
        //reset tags
        WebElement tagEditor = driver.findElement(By.xpath("//*[@id=\"uql-form\"]/div/div/div[1]/div/div[3]/div/div/span[1]/span/a"));
        tagEditor.click();
        //apply filter
        WebElement filterApplyButton = driver.findElement(By.xpath("//*[@id=\"uql-form\"]/div/div/div[2]/div/div[1]/button"));
        filterApplyButton.click();

    }
}
