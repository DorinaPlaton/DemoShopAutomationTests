import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(ExtentTestNGITestListener.class)

public class LoginTest extends Hooks {

    public LoginPage loginPage;
    public WebDriverWait wait;


    @BeforeMethod
    public void SetupPageObject() {
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Testing the Login functionality using the given username and password")
    public void loginTest() {
        loginPage.clickLogin();
        loginPage.setUsernameField();
        loginPage.setPasswordField();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getWelcomeMessage().getText(), "dino");
        loginPage.clickWelcomeMessage();

    }

    @Test(description = "Testing the Log Out functionality ")
    public void logoutTest() throws InterruptedException {
        loginPage.loginProcess();
        loginPage.clickWelcomeMessage();
        loginPage.clickLogoutButton();
        assertEquals(loginPage.getGuestWelcomeMessage().getText(), "Hello guest!");
    }

    @Test(description = "Testing the login functionality without filling the username mandatory field")
    public void testEmptyUsernameMandatoryField() {
        loginPage.clickLogin();
        loginPage.setPasswordField();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginErrorMessageMandatoryFields().getText(), "Please fill in the username!");
    }

    @Test(description = "Testing the login functionality without filling the password mandatory field")
    public void testEmptyPasswordMandatoryField() {
        loginPage.clickLogin();
        loginPage.setUsernameField();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginErrorMessageMandatoryFields().getText(), "Please fill in the password!");
    }

    @Test(description = "Testing the login functionality filling the username field with the wrong username")
    public void testWrongUsernameField() throws InterruptedException {
        loginPage.clickLogin();
        loginPage.setIncorrectUsername();
        loginPage.setPasswordField();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginErrorMessageMandatoryFields().getText(), "Incorrect username or password!");
    }

    @Test(description = "Testing the login functionality filling the password field with the wrong password")
    public void testWrongPasswordField() throws InterruptedException {
        loginPage.clickLogin();
        loginPage.setUsernameField();
        loginPage.setIncorrectPassword();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginErrorMessageMandatoryFields().getText(), "Incorrect username or password!");
    }

    @Test(description = "Testing the login functionality filling the username and password fields with the wrong data")
    public void testWrongUsernameAndPasswordFields() throws InterruptedException {
        loginPage.clickLogin();
        loginPage.setIncorrectUsername();
        loginPage.setIncorrectPassword();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginErrorMessageMandatoryFields().getText(), "Incorrect username or password!");
    }


}
