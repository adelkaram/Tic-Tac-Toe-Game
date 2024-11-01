package tests.pages;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import tests.BaseTest;

public class Hooks {

    @Before
    public void setUp() {
        BaseTest.setUpDriver();
    }

    @After
    public void tearDown() {
        BaseTest.tearDownDriver();
    }
}