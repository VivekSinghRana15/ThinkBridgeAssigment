package ThinkBridge.Question2.StepDefinitions;

import io.cucumber.java.en.*;
import ThinkBridge.Question2.PageObjects.RegistrationPage;
import org.apache.log4j.*;
import org.junit.Assert;


public class JabaSearchStepDefs extends BaseClass {

    Logger logger;

    @Given("We open the Jaba Talks Website")
    public void open_jaba_talks_website() {
        logger = Logger.getLogger("ThinkBridgeAssignment");
        PropertyConfigurator.configure("log4j.properties");

        openChromeDriver();//launching Chrome driver
        driver.get(baseurl);//got this directly from BaseObject class- which in turn gets it frm readConf-which gets it from config.properties

        registrationPageObject = new RegistrationPage(driver);//instantiating Page Object
        Assert.assertEquals("Jabatalks",registrationPageObject.getTitle());//Validating that we are on correct page
        logger.info("The browser with JabaTalks website has opened up..");
    }


    @Given("We Validate the Dropdown Options")
    public void validate_dropdown_options() {
        registrationPageObject.clickLanguageDropdown();//clicking the dropdown see all languages available for us to select
        registrationPageObject.validateAvailableLanguages();//checking if English & Dutch are available in the dropdown of languages
        logger.info("The expected English & Dutch languages are present in the dropdown");
    }


    @Given("We fill the {string},{string} and {string}")
    public void fill_the_Fields(String name, String org, String email) {
        registrationPageObject.fillName(name);//entering Name
        registrationPageObject.fillOrganization(org);//entering Organization
        registrationPageObject.fillemailId(email);//entering email id
        logger.info("Entered all parameter values successfully");
    }


    @Given("Click on Agree to Terms Checkbox")
    public void click_agree_to_terms_checkbox() {
        registrationPageObject.clickCheckbox();//checked the "I agree to terms.." checkbox
        logger.info("Checkbox clicked");
    }


    @When("We click on GetStarted Button")
    public void click_get_started_button() {
        registrationPageObject.clickGetStartedButton();//clicked Registeration button
        logger.info("The Get Started button is clicked");
    }


    @Then("We should get a message that email has been sent")
    public void validate_email_sent() throws InterruptedException {
        registrationPageObject.checkEmailSent();//checking the email sent message
        logger.info("The email sent message has been received..");
        Thread.sleep(5000);

        driver.quit();//closed the browser
    }


}
