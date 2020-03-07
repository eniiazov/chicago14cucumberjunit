package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utilities.ExtentReport;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-reports",
        features = "src/test/resources/features/",
        glue = "step_definitions",
        dryRun = false,
        tags = "@miniRegression"
)

public class CukesRunner {

    @AfterClass
    public static void tearDown(){
        ExtentReport.endReport();
    }

}
