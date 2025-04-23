package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue ="stepDefinitions",
        dryRun = false,
        plugin = {"pretty",
                "pretty", "html:target/uiReport.html",   "rerun:target/uiFailedTests.txt" ,
                "json:target/cucumber-report/cucumber.json"},
       tags = "@regression"
)
public class Runner {
}
