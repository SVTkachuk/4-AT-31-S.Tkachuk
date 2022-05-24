package case_14;

import BrowserFactrory.BrowserFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class AllureTestListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        takeScreenshot();
        getDom();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        takeScreenshot();
        getDom();
    }

    private void takeScreenshot() {
        Allure.addAttachment("Page screenshot", new ByteArrayInputStream(((TakesScreenshot) BrowserFactory.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    public void getDom(){
        Allure.addAttachment("DOM Tree",BrowserFactory.getDriver().getPageSource());
    }
}
