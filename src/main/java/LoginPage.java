import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }


    //login
    @FindBy(css = ".svg-inline--fa.fa-sign-in-alt.fa-w-16")
    private WebElement login;
    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(css = ".btn.btn-primary")
    private WebElement loginButton;
    @FindBy(linkText = "dino")
    private WebElement welcomeMessage;
    @FindBy(css = ".login_wrapper .error")
    private WebElement loginErrorMessageMandatoryFields;
    @FindBy(css = ".svg-inline--fa.fa-sign-out-alt.fa-w-16")
    private WebElement logoutButton;
    @FindBy(css = ".navbar-nav .navbar-text")
    private WebElement guestWelcomeMessage;

    public void clickLogin() {
        login.click();
    }

    public void setUsernameField() {
        usernameField.sendKeys("dino");
    }

    public void setIncorrectUsername() {
        usernameField.sendKeys("didi");
    }

    public void setPasswordField() {
        passwordField.sendKeys("choochoo");
    }

    public void setIncorrectPassword() {
        passwordField.sendKeys("123321");
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public WebElement getWelcomeMessage() {
        return welcomeMessage;
    }

    public void clickWelcomeMessage() {
        welcomeMessage.click();
    }

    public WebElement getLoginErrorMessageMandatoryFields() {
        return loginErrorMessageMandatoryFields;
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public WebElement getGuestWelcomeMessage() {
        return guestWelcomeMessage;
    }

    public void loginProcess() {
        clickLogin();
        setUsernameField();
        setPasswordField();
        clickLoginButton();
    }

}
