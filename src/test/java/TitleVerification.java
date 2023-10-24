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

    public void clickListItem() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Navigate to Google
        driver.get("https://www.google.com");



        // Perform the search
        WebElement searchInput = driver.findElement(By.name("twotabsearchtextbox"));
        searchInput.sendKeys("TestNG");
        searchInput.sendKeys(Keys.RETURN);

    }

    @Test

    public  void verifyTitle() {

        driver.get("https://www.guru99.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualTitle = driver.getTitle();
        String expectedTitle = "Meet Guru99 – Free Training Tutorials & Video for IT Courses";
        Assert.assertEquals(actualTitle, expectedTitle);

    }


    @AfterTest
    public void tearDown() {

            driver.quit();

    }
}
