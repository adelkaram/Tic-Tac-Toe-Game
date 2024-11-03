package tests.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicTacToePage {

    WebDriver driver;
    private Map<Integer, String[]> boardHistory = new HashMap<>();
    private int moveIndex = 1;

    public TicTacToePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCell(int cellNumber) {
        return driver.findElement(By.id("square-" + cellNumber));
    }

    public void selectCell(int cellNumber) {
        getCell(cellNumber).click();
        captureBoardState();
        moveIndex++;

    }

    public void goToMove(int moveIndex){
        List<WebElement> goToMoveButtons = driver.findElements(By.id("go-to-move-btn"));

        String goToMoveText = "Go to move #" + moveIndex;

        if (moveIndex > 0 && moveIndex <= goToMoveButtons.size()) {
            goToMoveButtons.get(moveIndex - 1).click();
        } else {
            throw new IllegalStateException("The button text does not match the expected move: " + goToMoveText);
        }
    }


    public void captureBoardState() {
        String[] boardState = new String[9];
        for (int cellNumber = 1; cellNumber <= 9; cellNumber++) {
            WebElement cell = driver.findElement(By.id("square-" + (cellNumber -1) ));
            boardState[cellNumber - 1] = cell.getText();
        }

        boardHistory.put(moveIndex, boardState.clone());
    }

    public String[] getCurrentBoardState() {
        String[] currentState = new String[9];
        for (int cellNumber = 1; cellNumber <= 9; cellNumber++) {
            WebElement cell = driver.findElement(By.id("square-" + (cellNumber -1) ));
            currentState[cellNumber - 1] = cell.getText();
        }
        return currentState;
    }


    public Map<Integer, String[]> getBoardHistory() {
        return boardHistory;
    }


}
