package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Random;

public class RegisterPage extends BasePage{
    private WebDriver driver;

    //Elements
    private By NameLocator = By.name("firstname");
    private By LastNameLocator = By.name("lastname");
    private By EmailLocator = By.name("email");
    private By TelephoneLocator = By.name("telephone");
    private By PasswordLocator = By.name("password");
    private By ConfirmLocator = By.name("confirm");
    private By ConfirmRegisterMessageLocator = By.xpath("//div[@id='content']/h1");
    private By TermsCheckBoxLocator = By.name("agree");
    private By ContinueButtonLocator = By.xpath("//input[@value='Continue']");
    private By DuplicateEmailWarningMessageLocator = By.xpath("//*[@id=\"account-register\"]/div[1]");

    public RegisterPage(WebDriver _driver){
        super(_driver);
    }
    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnMyAccount();
        headerPage.clickOnRegisterButton();
    }
    public void FillForm(String firstName, String lastName, String email, String telephone, String password){
        driver.findElement(NameLocator).sendKeys(firstName);
        driver.findElement(LastNameLocator).sendKeys(lastName);
        driver.findElement(EmailLocator).sendKeys(email);
        driver.findElement(TelephoneLocator).sendKeys(telephone);
        driver.findElement(PasswordLocator).sendKeys(password);
        driver.findElement(ConfirmLocator).sendKeys(password);
        driver.findElement(TermsCheckBoxLocator).click();
        driver.findElement(ContinueButtonLocator).click();
    }
    public String GetConfirmationMessage(){

        return driver.findElement(ConfirmRegisterMessageLocator).getText();
    }
    public String GetDuplicateEmailWarningMessage(){
        return driver.findElement(DuplicateEmailWarningMessageLocator).getText();
    }
    public String generateRandomEmail(){
        String saltCharacters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * saltCharacters.length());
            salt.append(saltCharacters.charAt(index));
        }
        String saltStrs = salt.toString();
        return saltStrs;
    }
}
