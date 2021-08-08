import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAccount {
    @Description("Validate test login was Successful")
    @Test
    public void Test_Login_Successful(){
        String username = "rballesterob@hotmail.com";
        String password = "020878Rbb";

        //String pathToDriver = Test.class.getResource("/chromedriver").getPath();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");
        //Time for page load * Better to use*
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Go to Login Page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.linkText("Login")).click();
        //Filling login form
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();
        //Finding Log out
        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());

        TakeScreenshot(driver);

        driver.close();
        driver.quit();
    }
    @Description("Validate test login is not working with Non Valid credentials")
    @Test
    public void Test_Login_Unsuccessful(){
        String username = "rballesterob@hotmail.com";
        String password = "020878Rbb1";
        String expectedMessage = "warning: no match for e-mail address and/or password.";
        //String pathToDriver = Test.class.getResource("/chromedriver").getPath();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Go To Login Page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.linkText("Login")).click();

        //Llenar formulario
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());

        TakeScreenshot(driver);

        driver.close();
        driver.quit();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] TakeScreenshot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
