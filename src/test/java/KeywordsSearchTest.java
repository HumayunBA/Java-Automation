import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class KeywordsSearchTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "C:\\\\Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
        driver = new ChromeDriver();


        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void navigateToProducts() {
        // Navigate to the "products" page on the website
        driver.get("https://automationexercise.com/products");
    }

    @Test
    public void searchKeyword1() {
        performSearch("Blue Top");
    }


    @Test
    public void searchKeyword2() {
        performSearch("Winter Top");
    }

    private void performSearch(String keyword) {


        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));

        WebElement searchButton = driver.findElement(By.id("submit_search"));

        searchInput.clear();

        searchInput.sendKeys(keyword);

        searchButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Delay after the page has loaded
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

