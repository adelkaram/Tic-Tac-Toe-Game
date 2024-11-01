package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TicTacToePage {
    WebDriver driver;

    public TicTacToePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCell(int cellNumber) {
        return driver.findElement(By.id("square-" + cellNumber));
    }

    public void selectCell(int cellNumber) {
        getCell(cellNumber).click();
    }

}
