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
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Logging in using the username and password");
        assertEquals(loginPage.getWelcomeMessage().getText(), "Hi dino!");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Displayed welcome message for the user: " + loginPage.getWelcomeMessage().getText());
        loginPage.clickUsername();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Click on the welcome message");
        assertEquals(loginPage.getAccountSubheader().getText(), "Account");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Accessing the page: " + loginPage.getAccountSubheader().getText());

    }

    @Test(description = "Testing the Log Out functionality ")
    public void logoutTest() {
        loginPage.loginProcess();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Completing the login process");
        loginPage.clickWelcomeMessage();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Accessing the user's account page");
        loginPage.clickLogoutButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Click on logout button");
        assertEquals(loginPage.getGuestWelcomeMessage().getText(), "Hello guest!");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"New welcome message is displayed: " + loginPage.getGuestWelcomeMessage().getText());
    }

    @Test(description = "Testing the login functionality without filling the username mandatory field")
    public void testEmptyUsernameMandatoryField() {
        loginPage.clickLogin();
        loginPage.setPasswordField();
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Completing the login process without filling the username mandatory field");
        assertEquals(loginPage.getLoginErrorMessageMandatoryFields().getText(), "Please fill in the username!");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Received error message: " + loginPage.getLoginErrorMessageMandatoryFields().getText());
    }

    @Test(description = "Testing the login functionality without filling the password mandatory field")
    public void testEmptyPasswordMandatoryField() {
        loginPage.clickLogin();
        loginPage.setUsernameField();
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Completing the login process without filling the password mandatory field");
        assertEquals(loginPage.getLoginErrorMessageMandatoryFields().getText(), "Please fill in the password!");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Received error message: " + loginPage.getLoginErrorMessageMandatoryFields().getText());
    }

    @Test(description = "Testing the login functionality filling the username field with the wrong username")
    public void testWrongUsernameField() {
        loginPage.clickLogin();
        loginPage.setIncorrectUsername();
        loginPage.setPasswordField();
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Completing the login process using wrong username");
        assertEquals(loginPage.getLoginErrorMessageMandatoryFields().getText(), "Incorrect username or password!");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Received error message: " + loginPage.getLoginErrorMessageMandatoryFields().getText());
    }

    @Test(description = "Testing the login functionality filling the password field with the wrong password")
    public void testWrongPasswordField() {
        loginPage.clickLogin();
        loginPage.setUsernameField();
        loginPage.setIncorrectPassword();
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Completing the login process using wrong password");
        assertEquals(loginPage.getLoginErrorMessageMandatoryFields().getText(), "Incorrect username or password!");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Received error message: " + loginPage.getLoginErrorMessageMandatoryFields().getText());
    }

    @Test(description = "Testing the login functionality filling the username and password fields with the wrong data")
    public void testWrongUsernameAndPasswordFields() {
        loginPage.clickLogin();
        loginPage.setIncorrectUsername();
        loginPage.setIncorrectPassword();
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Completing the login process using wrong username and wrong password");
        assertEquals(loginPage.getLoginErrorMessageMandatoryFields().getText(), "Incorrect username or password!");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Received error message: " + loginPage.getLoginErrorMessageMandatoryFields().getText());
    }


}
