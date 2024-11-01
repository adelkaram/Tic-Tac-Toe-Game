package tests.features;

import io.cucumber.java.en.*;
import tests.pages.TicTacToePage;
import tests.BaseTest;

public class TicTacToeSteps extends BaseTest {


    TicTacToePage ticTacToePage;

    @Given("the Tic Tac Toe game is open")
    public void theTicTacToeGameIsOpen() {
        setUpDriver(); // Initialize the ChromeDriver
        driver.get("https://testing-tictactoe-sxsi7kqutq-ew.a.run.app/");
        ticTacToePage = new TicTacToePage(driver);
    }

    @When("player X selects cell {int}")
    public void playerXSelectsCell(int cellNumber) {
        ticTacToePage.selectCell(cellNumber);
    }


}
