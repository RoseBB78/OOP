import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAccount extends BaseClass {

    @Description("Validate test login was Successful")
    @Test(description = "Test Login Success")
    public void Test_Login_Successful(){
        String username = "rballesterob@hotmail.com";
        String password = "020878Rbb";
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

    }

    @Description("Validate test login is not working with Non Valid credentials")
    @Test(description = "Test Login Not Success")
    public void Test_Login_Unsuccessful(){
        String username = "rballesterob@hotmail.com";
        String password = "020878Rbb1";
        String expectedMessage = "warning: no match for e-mail address and/or password.";
        //Go To Login Page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.linkText("Login")).click();
        //Llenar formulario
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());

    }

}

