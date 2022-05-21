package case_12.Decorators;

import org.openqa.selenium.WebElement;

public class WebLink extends Element {

    public WebLink(WebElement webElement) {
        super(webElement);
        this.webElement = webElement;
    }

    public void linkPress(){
        webElement.click();
    }
}
