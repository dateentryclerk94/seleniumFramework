package runner;

import cucumber.api.CucumberOptions;
import tests.TestBase;

// maybe change slash in the path
@CucumberOptions(features = {"src/test/java/feature"} 
, glue = {"steps"} 
, plugin = {"pretty" , "html:target/cucumber-html-report"})
public class TestRunner extends TestBase{

}
