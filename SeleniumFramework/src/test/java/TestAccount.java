import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAccount {
    @Test
    public void Test_Login_Successful(){
        String username = "rballesterob@hotmail.com";
        String password = "020878Rbb";
        String pathToDriver = Test.class.getResource("/chromedriver").getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        //Time for page load * Better to use*
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Time to load the second script
        //driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        
        //Go to Login Page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.linkText("Login")).click();

        /* Example Array and WebElements
        WebElement WishList = driver.findElement(By.linkText(" Wish List"));
        ArrayList<> WishList = driver.findElements(By.linkText("Wish List"));*/

        //Filling login form
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();

        //Finding Log out
        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());

        driver.close();
        driver.quit();
    }
}
