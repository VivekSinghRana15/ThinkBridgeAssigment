package ThinkBridge.Question2.RunnerFile;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/Features/JabaTalksRegistrationScenario.feature",
        glue = "src/test/java/org/ThinkBridge/Question2/StepDefinitions/JabaSearchStepDefs.java",
        dryRun = false,
        plugin = {"pretty","html:src/Reports/CucumberReport.html"},
        tags = "@Vivek"
)


public class TestRunner {
}
