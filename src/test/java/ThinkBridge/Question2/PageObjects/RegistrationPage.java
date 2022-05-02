package ThinkBridge.Question2.PageObjects;

import ThinkBridge.Question2.StepDefinitions.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseClass {
    WebDriver xDriver;

    public RegistrationPage(WebDriver rDriver){
        xDriver = rDriver;
        PageFactory.initElements(rDriver,this);
    }

    @FindBy(xpath = "//div[@placeholder='Choose Language']//i[@class='caret pull-right']")
    WebElement dropdownPullButton;

    @FindBy(xpath = "//div[contains(text(),'English')]")
    WebElement englishLanguageOption;

    @FindBy(xpath = "//div[contains(text(),'Dutch')]")
    WebElement dutchLanguageOption;

    @FindBy(xpath = "//input[@id='name']")
    WebElement nameField;

    @FindBy(xpath = "//input[@id='orgName']")
    WebElement orgNameField;

    @FindBy(xpath = "//input[@id='singUpEmail']")
    WebElement emailField;

    @FindBy(xpath = "//span[@class='black-color ng-binding']")
    WebElement checkBox;

    @FindBy(xpath = "//button[normalize-space()='Get Started']")
    WebElement registerButton;

    @FindBy(xpath = "//span[contains(text(),'A welcome email has been sent. Please check your email.')]")
    WebElement emailSentMessage;


    public String getTitle(){
        return xDriver.getTitle();
    }

    public void clickLanguageDropdown(){
        waitForElementToAppear(xDriver,dropdownPullButton,10);
        dropdownPullButton.click();
    }

    public  void validateAvailableLanguages(){
        Assert.assertEquals("English",englishLanguageOption.getText());
        Assert.assertEquals("Dutch",dutchLanguageOption.getText());
    }

    public void fillName(String name){
        nameField.sendKeys(name);
    }

    public void fillOrganization(String org){
        orgNameField.sendKeys(org);
    }

    public void fillemailId(String email){
        emailField.sendKeys(email);
    }

    public void clickCheckbox(){
        checkBox.click();
    }

    public void clickGetStartedButton(){
        registerButton.click();
    }

    public void checkEmailSent(){
        waitForElementToAppear(xDriver,emailSentMessage,10);
        Assert.assertEquals("A welcome email has been sent. Please check your email.",emailSentMessage.getText());
    }

}
