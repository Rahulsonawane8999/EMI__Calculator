package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = {
			    "src/main/resources/features/EMI_AValidation.feature",
			    "src/main/resources/features/EMI_BFunctional.feature",
			    "src/main/resources/features/EMI_CReport.feature"
			},
		glue = "stepsdefinitions",
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/cucumber-report.html"
			}

)

public class TestRunner extends AbstractTestNGCucumberTests {
}