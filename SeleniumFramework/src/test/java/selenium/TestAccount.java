package selenium;

import PageObjects.BaseClass;
import PageObjects.HeaderPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAccount extends BaseClass {

    @Description("Validate test login was Successful")
    @Test(description = "Test Login Success")
    public void Test_Login_Successful(){
        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String username = "rballesterob@hotmail.com";
        String password = "020878Rbb";
        //Go to Login Page
        headerPage.clickOnMyAccount();
        headerPage.clickOnLoginButton();
        //driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        //driver.findElement(By.linkText("Login")).click();
        //Filling login form
        /*driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();*/
        loginPage.EnterEmail(username);
        loginPage.EnterPassword(password);
        loginPage.ClickSubmitButton();
        //Finding Log out
        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());

    }

    @Description("Validate test login is not working with Non Valid credentials")
    @Test(description = "Test Login Not Success")
    public void Test_Login_Unsuccessful() {
        /*Test Driven Development
         * AS A USER I want to be able to login properly
         *
         * GIVEN I am at login page
         * AND I log in with rballesterob@hotmail.com and 020878Rbb
         * WHEN The user is at dashboard page
         * THEN logout button is displayed
         * */
        LoginPage loginPage = new LoginPage(driver);
        String username = "rballesterob@hotmail.com";
        String password = "020878Rbb1";
        String expectedMessage = "warning: no match for e-mail address and/or password.";
        //Go To Login Page
        /*driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.linkText("Login")).click();*/
        loginPage.GoTo();
        loginPage.login(username, password);

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());
    }

        //Llenar formulario
       /*driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());*/
        @Test
        public void Test_Create_New_Account(){
            //SETUP
            String firstName = "Rose";
            String lastName = "Ballestero";
            String email = "rballesterob@hotnail.com";
            String telephone = "89692227";
            String password = "asdf";
            String expectedMessage = "Your Account Has Been Created!";
            RegisterPage registerPage = new RegisterPage(driver);

            //RUN
            registerPage.GoTo();
            registerPage.FillForm(firstName, lastName, email, telephone, password);

            //VALIDATION
            Assert.assertEquals(registerPage.GetConfirmationMessage(), expectedMessage);
        }

}

