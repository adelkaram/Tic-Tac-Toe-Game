package tests.features;

import io.cucumber.java.en.*;
import org.junit.Assert;
import tests.pages.TicTacToePage;
import tests.BaseTest;

public class TicTacToeSteps extends BaseTest {


    TicTacToePage ticTacToePage;

    @Given("the Tic Tac Toe game is open")
    public void theTicTacToeGameIsOpen() {
        driver.get("https://testing-tictactoe-sxsi7kqutq-ew.a.run.app/");
        ticTacToePage = new TicTacToePage(driver);
    }

    @When("player X selects cell {int}")
    public void playerXSelectsCell(int cellNumber) {
        ticTacToePage.selectCell(cellNumber);
    }

    @Then("cell {int} should display {string}")
    public void cellShouldDisplay(int cellNumber, String expectedValue) {
        Assert.assertEquals(ticTacToePage.getCell(cellNumber).getText(), expectedValue);
    }

    @When("player O attempts to select cell {int}")
    public void playerOAttemptsToSelectCell(int cellNumber) {
        ticTacToePage.selectCell(cellNumber);
    }

    @Then("cell {int} should still display {string} and should not be overridden")
    public void cellShouldNotBeOverridden(int cellNumber, String expectedValue) {
        Assert.assertEquals(ticTacToePage.getCell(cellNumber).getText(), expectedValue);
    }

    @And("player O selects cell {int}")
    public void playerOSelectsCell(int cellNumber) {
        ticTacToePage.selectCell(cellNumber);
    }

    @When("the player goes back to move {int}")
    public void goToMove(int moveIndex) {
        ticTacToePage.goToMove(moveIndex);
    }

    @Then("cell {int} should be empty")
    public void cellShouldBeEmpty(int cellNumber) {
        Assert.assertTrue(ticTacToePage.getCell(cellNumber).getText().isEmpty());
    }

}
