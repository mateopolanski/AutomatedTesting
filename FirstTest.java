
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {


    @Test
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");
        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();
        WebElement emailInput = driver.findElement(By.id("email_create"));
        emailInput.sendKeys("mamacita");
        WebElement submitCreateButton = driver.findElement(By.id("SubmitCreate"));
        submitCreateButton.click();
        WebElement errorEmail = driver.findElement(By.id("create_account_error"));
        WebElement firstResult = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(errorEmail));
        // Print the first result
        System.out.println(firstResult.getText());
        Assertions.assertTrue(errorEmail.isDisplayed());
        Thread.sleep(5000);


//      driver.quit();

    }
}
