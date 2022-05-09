package case_11;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FacebookBO {

    WebDriver driver ;
    private HomePO homePO;
    private SignUpPO signUpPO;

    public FacebookBO(WebDriver driver) {
        this.driver=driver;
    }

    public void homePage(){
        homePO = new HomePO(driver);
        homePO.homePage();
    }

    public void verifyLoginForm(){
        signUpPO = new SignUpPO(driver);
        Assert.assertTrue(signUpPO.isOpen());
    }

    public void insertLogin(String login, String password){
    signUpPO.insertLogin(login,password);
    }

    public void pressSignUp(){
        signUpPO.clickSignUp();
    }

    public void isLogged(){
        boolean isLogged = signUpPO.isLogged();
      Assert.assertTrue(isLogged,"is not logged");
    }
}
