package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "C:\\Selenium_Workspace\\Cucumber_BDD\\src\\main\\java\\features\\testPhase.feature",
		glue= {"testPhasePKG"},
		format = {"pretty", "html:test-output", "junit:test-output/junit/output.xml", "json:test-output/json/output.json"},
		dryRun= false,
		monochrome = true,
		strict  = true,
		tags= {"@sanity"}
		)

public class TestRunner {
	
	

}
