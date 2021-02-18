import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    WebDriver driver;


    @BeforeEach
    public void start(){

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationpractice.com");

//        driver.navigate().back();
    }

//    @AfterEach
//    public void stop(){
//        driver.quit();
//    }


    @Test
    public void registerForm(){

//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://automationpractice.com");
        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();
        WebElement emailInput = driver.findElement(By.id("email_create"));
        emailInput.click();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        emailInput.sendKeys("usernamem"+ randomInt +"@gmail.com");
        WebElement submitCreateButton = driver.findElement(By.id("SubmitCreate"));
        submitCreateButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Adrian");
        driver.findElement(By.id("customer_lastname")).sendKeys("Porebski-Lach");
        driver.findElement(By.id("passwd")).sendKeys("pass123");
        driver.findElement (By.id("newsletter")).click();
        driver.findElement (By.id("firstname")).sendKeys("Matto");
        driver.findElement(By.id("lastname")).sendKeys("Pokorak");
        driver.findElement(By.id("company")).sendKeys("BUDIMEX");
        driver.findElement(By.id("address1")).sendKeys("Street 34 PO 40");
        driver.findElement(By.id("city")).sendKeys("New York");
        WebElement state1 = driver.findElement(By.id("id_state"));
        state1.sendKeys("Arizona");
        driver.findElement(By.id("postcode")).sendKeys("45200");
        driver.findElement(By.id("id_country")).sendKeys("United States");
        driver.findElement(By.id("phone_mobile")).sendKeys("07004568890");
        driver.findElement(By.id("alias")).sendKeys("My adress");
        driver.findElement(By.id("submitAccount")).click();

        String expectedMessage = "The Registration is complete!";
        String message = driver.findElement(By.id("my-account")).getText();
        Assert.assertFalse("Confirmation", message.contains(expectedMessage));
        System.out.println(expectedMessage);
////////////////////////////////////////////////////////
//        driver.quit();







        ///////////////////////////////////////////////////////////////
//        driver.findElement(By.id("id_gender1")).click();
//        WebElement checkGender = driver.findElement(By.cssSelector("#id_gender1"));
//        checkGender.click();
//        checkGender.isSelected();
    }
}
