package case_14;

import BrowserFactrory.BrowserFactory;
import case_11.FacebookBO;
import case_13.CustomSuiteListener;
import case_13.CustomTestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({
        CustomSuiteListener.class,
        CustomTestListener.class,
        AllureTestListener.class
})

public class FacebookAllureTC {
    public WebDriver driver;

    @BeforeTest
    public void driverInit(){
        driver = BrowserFactory.getDriver();
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
        BrowserFactory.getDriver().close();
        BrowserFactory.getDriver().quit();
    }
}
