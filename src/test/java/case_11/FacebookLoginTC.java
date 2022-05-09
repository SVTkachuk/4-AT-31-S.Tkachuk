package case_11;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookLoginTC {

    public WebDriver driver;

    @BeforeTest
    public void driverInit(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @DataProvider
    Object[][] loginProvider() {
        return new Object[][] {
                {"2312", "sdfsdg"},
                {"380986008680", "abuaaoka"}
        };
    }

    @Test(dataProvider = "loginProvider")
    public void loginTest(String login, String password){

    FacebookBO facebookBO = new FacebookBO(driver);

    facebookBO.homePage();

    facebookBO.verifyLoginForm();

    facebookBO.insertLogin(login,password);

   facebookBO.pressSignUp();

   facebookBO.isLogged();
    }

    @AfterTest
    void closeDriver(){
        driver.quit();
    }
}
