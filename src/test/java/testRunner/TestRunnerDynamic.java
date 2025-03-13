package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/dynamic_controls.feature",
        glue = "stepDefinitions/dynamicControls",
        plugin = {"pretty", "html:target/dynamic-page.html"},
        monochrome = true
)
public class TestRunnerDynamic extends AbstractTestNGCucumberTests {
}
