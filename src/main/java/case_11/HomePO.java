package case_11;

import org.openqa.selenium.WebDriver;

public class HomePO {
    private WebDriver driver;

    public HomePO(WebDriver driver){
        this.driver=driver;
    }
    public void homePage() {
        driver.get("https://www.facebook.com/");
    }
}
