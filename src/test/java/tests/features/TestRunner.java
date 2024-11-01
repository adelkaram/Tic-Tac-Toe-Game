package tests.features;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/tests/features",
        glue = "tests",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}