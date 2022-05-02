package ThinkBridge.Question2.StepDefinitions;

import ThinkBridge.Question2.Utilities.ReadConf;
import ThinkBridge.Question2.PageObjects.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {

    ReadConf readConfObj = new ReadConf();
    RegistrationPage registrationPageObject;
    WebDriver driver;


    String baseurl = readConfObj.getApplicationURL();


    public void openChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public WebElement waitForElementToAppear(WebDriver driver, WebElement locatorOfElement, int timeToWait) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.visibilityOf(locatorOfElement));
        return locatorOfElement;
    }


}
