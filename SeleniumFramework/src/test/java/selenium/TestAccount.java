package selenium;

import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import Pojo.UserAccount;
import dataProviders.UsersProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAccount extends BaseClass {
    public static final String ERROR_EMAIL_AND_PASSWORD_INVALID_MESSAGE = "warning: no match for e-mail address and/or password.";
    //Elements
    public By logOutButtonLocator = By.linkText("Logout");
    public By alertMessageLocator = By.xpath("//div[contains(@class, 'alert-danger')]");


    @Description("Validate test login was Successful")
    @Test(description = "Test Login Success")
    public void Test_Login_Successful(){
        String username = "rballesterob@hotmail.com";
        String password = "020878Rbb";
        //Go To Login Page
        headerPage().clickOnMyAccount();
        headerPage().clickOnLoginButton();
        /*
        EJEMPLO DE LISTAS Y WEBELEMENTS SOLOS
        WebElement WishList = driver.findElement(By.linkText("Wish List"));
        ArrayList<> WishListList = driver.findElements(By.linkText("Wish List"));
        */
        //Llenar formulario
        loginPage().EnterEmail(username);
        loginPage().EnterPassword(password);
        loginPage().ClickSubmitButton();
        WebElement logOutButton = driver.findElement(logOutButtonLocator);
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
        //LoginPage loginPage = new LoginPage(driver);
        String username = "rballesterob@hotmail.com";
        String password = "020878Rbb1";
        String expectedMessage = "warning: no match for e-mail address and/or password.";
        //Go To Login Page
        loginPage().GoTo();
        loginPage().login(username, password);
        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());
    }
    @Test (dataProvider = "getUsersData", dataProviderClass = UsersProvider.class)
    public void Test_Login_With_Data(UserAccount testUser){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.GoTo();
        loginPage.login(testUser.getEmail(), testUser.getPassword());
        if(testUser.isValidAccount())
            Assert.assertTrue(driver.findElement(logOutButtonLocator).isDisplayed());
        else
            Assert.assertEquals(ERROR_EMAIL_AND_PASSWORD_INVALID_MESSAGE.toLowerCase(), driver.findElement(alertMessageLocator).getText().toLowerCase().trim());
    }

    @Test
    public void Test_Create_New_Account(){
        //SETUP
        String firstName = "Rose";
        String lastName = "Ballestero";
        String email = "rballesterob@hotnail.com";
        String telephone = "89692227";
        String password = "asdf";
        String expectedMessage = "Warning: E-Mail Address is already registered!";
        RegisterPage registerPage = new RegisterPage(driver);
        //RUN
        registerPage().GoTo();
        registerPage().FillForm(firstName, lastName, email, telephone, password);
        //VALIDATION
        Assert.assertEquals(registerPage().GetConfirmationMessage(), expectedMessage);
    }

    @Description("Test Case #1: Validate that duplicate email check validation is performed at Register Page")
    @Test
    public void Test_Create_Random_Email_Generation(){
        //Setup
        String firstName = "Rossy";
        String lastName = "Barquero";
        String email = registerPage().generateRandomEmail() + "@hotmail.com";
        String telephone = "22290857";
        String password = "1234Te$t";
        String expectedMessage = "Your Account Has Been Created!";
        String expectedAccountLogoutMessage = "Account Logout";
        RegisterPage registerPage = new RegisterPage(driver);

        //Run
        registerPage.GoTo();
        registerPage.FillForm(firstName,lastName,email,telephone,password);
        //Validate Account Registered
        Assert.assertEquals(registerPage.GetConfirmationMessage(),expectedMessage);
        //Validate User is logged in
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
        //selenium wait
        driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[13]")).click();
        String AccountLogoutMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
        Assert.assertEquals(AccountLogoutMessage, expectedAccountLogoutMessage);
    }
}

