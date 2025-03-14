package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/tables_page.feature",
        glue = "stepDefinitions/tablesPage",
        plugin = {"pretty", "html:target/tables-page.html"},
        monochrome = false
)
public class TestRunnerTable extends AbstractTestNGCucumberTests {
}
