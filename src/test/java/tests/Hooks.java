package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import tests.Utility.ExtentManager;

import static tests.Utility.ExtentManager.extent;

public class Hooks {
    private ExtentReports extent = ExtentManager.getExtent();
    private static ExtentTest test;

    @Before ()
    public void setUp() {
        BaseTest.setUpDriver();
    }
    @Before (order = 1)
    public void beforeScenario(Scenario scenario) {
        // Create a new test in the Extent Report for the current scenario
        test = extent.createTest(scenario.getName());
    }

    @After ()
    public void tearDown() {
        BaseTest.tearDownDriver();
        extent.flush();
    }

    @After (order = 1)
    public void afterScenario(Scenario scenario) {
        // Log the result of the scenario
        if (scenario.isFailed()) {
            test.fail("Scenario failed");
        } else {
            test.pass("Scenario passed");
        }

        // Flush the report after each scenario
        extent.flush();
    }

    // Getter for ExtentTest to use in other parts of the code
    public static ExtentTest getTest() {
        return test;
    }
}