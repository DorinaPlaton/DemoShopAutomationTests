import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

    //searchbar
    @Test(description = "Testing the searchbar using the keyword 'Practical'. Expecting to get three products.")
    public void searchbarTest() {
        homepagePage.inputSearchbar();
        homepagePage.clickSearchButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Search after 'Practical' keyword initiated.");
        assertEquals(homepagePage.getProductWoodenBacon().getText(), "Practical Wooden Bacon");
        assertEquals(homepagePage.getProductMetalMouse().getText(), "Practical Metal Mouse");

        ExtentTestNGITestListener.getTest().log(Status.INFO, "Three products were found.");
    }


    @Test(description = "Testing the sort functionality from the Homepage selecting from the dropdown menu 'Sort by name(A to Z)")
    public void testSortByNameAToZ() {
        homepagePage.clickSortDropdownMenu();
        homepagePage.selectSortByNameAToZ();
        assertTrue(homepagePage.getFirstProduct() < homepagePage.getLastProduct());
    }

    @Test(description = "Testing the sort functionality from the Homepage selecting from the dropdown menu 'Sort by name(Z to A)")
    public void testSortByNameZToA() {
        homepagePage.clickSortDropdownMenu();
        homepagePage.selectSortByNameZToA();
        assertTrue(homepagePage.getFirstProduct() > homepagePage.getLastProduct());
    }

    @Test(description = "Testing the sort functionality from the Homepage selecting from the dropdown menu 'Sort by price(low to high)")
    public void testSortByPriceLoToHi() {
        homepagePage.clickSortDropdownMenu();
        homepagePage.selectSortByPriceLoToHi();
        assertTrue(homepagePage.getFirstProductPrice() < homepagePage.getLastProductPrice());

    }

    @Test(description = "Testing the sort functionality from the Homepage selecting from the dropdown menu 'Sort by price(high to low)")
    public void testSortByPriceHiToLo() {
        homepagePage.clickSortDropdownMenu();
        homepagePage.selectSortByPriceHiToLo();
        assertTrue(homepagePage.getFirstProductPrice() > homepagePage.getLastProductPrice());
    }

    @Test(description = "Testing adding to cart first product from the page to see if the number on the cart icon at the top of the page changes accordingly")
    public void testNumberOnCartIcon() {
        homepagePage.clickAddToCartFirstProduct();
        assertEquals(homepagePage.getShoppingCartBadge().getText(), homepagePage.getClicksOnAddToCart());
    }

    @Test(description = "Testing going to Homepage from a product page using the Logo")
    public void testGoToHomepage() {
        homepagePage.clickAwesomeGraniteChipsProduct();
        homepagePage.clickLogoIcon();
        assertEquals(homepagePage.getSubheaderHomepage().getText(), "Products");
    }

    @Test(description = "Testing Reset the application functionality after sorting the products from high to low price")
    public void testReset1() {
        homepagePage.clickSortDropdownMenu();
        homepagePage.selectSortByPriceHiToLo();
        assertEquals(homepagePage.getAwesomeSoftShirtProduct().getText(), "Awesome Soft Shirt");
        homepagePage.clickResetButton();
        assertEquals(homepagePage.getAwesomeGraniteChipsProduct().getText(), "Awesome Granite Chips");
    }

    @Test(description = "Testing Reset the application after login")
    public void testReset2() {
        loginPage.clickLogin();
        loginPage.setUsernameField();
        loginPage.setPasswordField();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getWelcomeMessage().getText(), "dino");
        wait.until(ExpectedConditions.elementToBeClickable(homepagePage.getResetButton()));
        homepagePage.clickResetButton();
        assertEquals(loginPage.getGuestWelcomeMessage().getText(), "Hello guest!");
    }


}
