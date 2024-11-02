package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import tests.Utility.ExtentManager;

public class BaseTest {

    public static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;


    public static void setUpDriver() {

        extent = ExtentManager.getExtent();
        test = ExtentManager.createTest("Tic Tac Toe Tests");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }


    public static void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
