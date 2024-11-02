package tests;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import static tests.Utility.ExtentManager.extent;

public class Hooks {

    @Before
    public void setUp() {
        BaseTest.setUpDriver();
    }

    @After
    public void tearDown() {
        BaseTest.tearDownDriver();
        extent.flush();
    }
}