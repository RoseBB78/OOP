import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Main {
    public static void main(String[] args){
        String pathToDriver = Main.class.getResource("/chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        WebDriver driver = new ChromeDriver();

        /*driver.get("https://demo.opencart.com/index.php?route=account/login");
        //Access with email
        WebElement emailElement = driver.findElement(By.name("email"));
        emailElement.sendKeys("rballesterob@hotmail.com");
        //Password
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("020878Rbb");
        //Click on submit
        WebElement loginButton = driver.findElement(By.xpath("//input[@type = 'submit']"));
        loginButton.click();
        //Other way to click on Submit
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
        //Alert Message
        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));
        Assert.assertTrue(alertMessage.isDisplayed());
        driver.close();
        driver.quit();*/

        //Task #1 - Selenium First Steps
        //Access page
        driver.get("https://demo.opencart.com/");

        //Search MacBook
        driver.findElement(By.id("search")).sendKeys("Macbook");
        driver.findElement(By.xpath("//*[@id='search']/span/button")).click();
        //Adding to Cart
        driver.findElement(By.xpath("//*[@id='contains(@class, 'caption')]/h4/a[1]")).click();
        driver.findElement(By.id("button-cart"));

        driver.close();
        driver.quit();
    }
}
