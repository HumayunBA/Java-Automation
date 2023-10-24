import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TitleVerification {

    private WebDriver driver;

    @BeforeTest
    public  void setup() {

        System.setProperty("web-driver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test

    public  void verifyTitle() {

        driver.get("https://automationexercise.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(actualTitle, expectedTitle);

    }


    @AfterTest
    public void tearDown() {

            driver.quit();

    }
}
