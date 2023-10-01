package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		// This is the feature file path
		// features = ".//FeaturesFile/LoginFeature.feature",
		// I'm running the entire feature files in the feature folder
		features = ".//FeaturesFile/",

		// If I want to run only 2 features
		// features = { ".//FeaturesFiles/LoginFeature.feature",
		// ".//FeaturesFile/Customers.feature" },
		// features = ".//FeaturesFile/Customers.feature",
		// this is the StepDefinition path
		glue = "StepDefinition",

		// true open will be checking the compatibility of the FeatureFile and
		// StepDefinition
		dryRun = false,

		// output readable
		monochrome = true,

		// to do
		plugin = { "pretty", "html:target/cucumber-reports/reports_html.html" }

)

public class TestRunnerClass {

}
