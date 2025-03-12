package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/form_validation.feature",
        glue = "stepDefinitions/formValidation",
        plugin = {"pretty", "html:target/form-validation.html"},
        monochrome = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
