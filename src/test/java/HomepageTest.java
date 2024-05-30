import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(ExtentTestNGITestListener.class)

public class HomepageTest extends Hooks {

    public HomepagePage homepagePage;
    public LoginPage loginPage;
    public WebDriverWait wait;


    @BeforeMethod
    public void SetupPageObject() {
        homepagePage = new HomepagePage(driver);
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Testing the searchbar using the keyword 'Practical'. Expecting to get three products.")
    public void searchbarTest() {
        homepagePage.inputSearchbar();
        homepagePage.clickSearchButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Search after 'Practical' keyword initiated.");
        assertEquals(homepagePage.getProductWoodenBacon1().getText(), "Practical Wooden Bacon");
        assertEquals(homepagePage.getProductWoodenBacon2().getText(), "Practical Wooden Bacon");
        assertEquals(homepagePage.getProductMetalMouse().getText(), "Practical Metal Mouse");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Three products were found.");
    }


    @Test(description = "Testing the sort functionality from the Homepage selecting from the dropdown menu 'Sort by name(A to Z)")
    public void testSortByNameAToZ() {
        homepagePage.clickSortDropdownMenu();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Click on sorting dropdown menu");
        homepagePage.selectSortByNameAToZ();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Selected sort products from A to Z");
        assertTrue(homepagePage.getFirstProduct() < homepagePage.getLastProduct());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "First product starts with the letter " + homepagePage.getFirstProduct());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Last product starts with the letter " + homepagePage.getLastProduct());
    }

    @Test(description = "Testing the sort functionality from the Homepage selecting from the dropdown menu 'Sort by name(Z to A)")
    public void testSortByNameZToA() {
        homepagePage.clickSortDropdownMenu();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Click on the sorting dropdown menu");
        homepagePage.selectSortByNameZToA();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Selected sort products from Z to A");
        assertTrue(homepagePage.getFirstProduct() > homepagePage.getLastProduct());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "First product starts with the letter " + homepagePage.getFirstProduct());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Last product starts with the letter " + homepagePage.getLastProduct());
    }

    @Test(description = "Testing the sort functionality from the Homepage selecting from the dropdown menu 'Sort by price(low to high)")
    public void testSortByPriceLoToHi() {
        homepagePage.clickSortDropdownMenu();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Click on the sorting dropdown menu");
        homepagePage.selectSortByPriceLoToHi();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Selected sort products by price from low to high");
        assertTrue(homepagePage.getFirstProductPrice() < homepagePage.getLastProductPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The price of the first product is: " + homepagePage.getFirstProductPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The price of the last product is: " + homepagePage.getLastProductPrice());
    }

    @Test(description = "Testing the sort functionality from the Homepage selecting from the dropdown menu 'Sort by price(high to low)")
    public void testSortByPriceHiToLo() {
        homepagePage.clickSortDropdownMenu();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Click on the sorting dropdown menu");
        homepagePage.selectSortByPriceHiToLo();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Selected sort products by price from high to low");
        assertTrue(homepagePage.getFirstProductPrice() > homepagePage.getLastProductPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The price of the first product is: " + homepagePage.getFirstProductPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The price of the last product is: " + homepagePage.getLastProductPrice());
    }

    @Test(description = "Testing that adding the first product on the page to the cart updates the cart icon's item count correctly.")
    public void testNumberOnCartIcon() {
        homepagePage.clickAddToCartFirstProduct();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Added a product to the cart");
        assertEquals(homepagePage.getShoppingCartBadge().getText(), homepagePage.getClicksOnAddToCart());
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Cart's badge number updated to: " + homepagePage.getShoppingCartBadge().getText());
    }

    @Test(description = "Ensure that clicking the logo on a product page navigates the user back to the homepage.")
    public void testGoToHomepage() {
        homepagePage.clickAwesomeGraniteChipsProduct();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Accessed product's page");
        homepagePage.clickLogoIcon();
        assertEquals(homepagePage.getSubheaderHomepage().getText(), "Products");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Successfully going to the Homepage using the Logo icon");
    }

    @Test(description = "Test that the application can be reset successfully after applying a sort operation on product prices in descending order.")
    public void testReset1() {
        homepagePage.clickSortDropdownMenu();
        homepagePage.selectSortByPriceHiToLo();
        assertEquals(homepagePage.getAwesomeSoftShirtProduct().getText(), "Awesome Soft Shirt");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Click on sort dropdown menu and selecting sort by price high to low");
        homepagePage.clickResetButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Click on the reset button and checking for the first product on the page");
        assertEquals(homepagePage.getAwesomeGraniteChipsProduct().getText(), "Awesome Granite Chips");
    }

    @Test(description = "Ensure the application’s reset functionality operates correctly after user login.")
    public void testReset2() {
        loginPage.clickLogin();
        loginPage.setUsernameField();
        loginPage.setPasswordField();
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Logging in using the username and password");
        assertEquals(loginPage.getWelcomeMessage().getText(), "Hi dino!");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Displayed welcome message for the user: " + loginPage.getWelcomeMessage().getText());
        wait.until(ExpectedConditions.elementToBeClickable(homepagePage.getResetButton()));
        homepagePage.clickResetButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Clicking the reset button");
        assertEquals(loginPage.getGuestWelcomeMessage().getText(), "Hello guest!");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Personalised welcome message is replaced by: " + loginPage.getGuestWelcomeMessage().getText());
    }


}
