import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Listeners(ExtentTestNGITestListener.class)

public class HomepageTest extends Hooks {

    public HomepagePage homepagePage;
    public WebDriverWait wait;


    @BeforeMethod
    public void SetupPageObject() {
        homepagePage = new HomepagePage(driver);
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
        // al 3-lea produs
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Three products were found.");
    }


    @Test(description = "Testing the sort functionality from the Homepage selecting from the dropdown menu 'Sort by name(A to Z)")
    public void testSortByNameAToZ() {
        homepagePage.clickSortDropdownMenu();
        homepagePage.selectSortByNameAToZ();

    }

    @Test(description = "Testing the sort functionality from the Homepage selecting from the dropdown menu 'Sort by name(Z to A)")
    public void testSortByNameZToA() {
        homepagePage.clickSortDropdownMenu();
        homepagePage.selectSortByNameZToA();

    }

    @Test(description = "Testing the sort functionality from the Homepage selecting from the dropdown menu 'Sort by price(low to high)")
    public void testSortByPriceLoToHi() {
        homepagePage.clickSortDropdownMenu();
        homepagePage.selectSortByPriceLoToHi();

    }

    @Test(description = "Testing the sort functionality from the Homepage selecting from the dropdown menu 'Sort by price(high to low)")
    public void testSortByPriceHiToLo() {
        homepagePage.clickSortDropdownMenu();
        homepagePage.selectSortByPriceHiToLo();

    }

    @Test(description = "Testing adding first product from the page to cart to see if the number on the top cart icon changes accordingly")
    public void testNumberOnCartIcon() throws InterruptedException {
        homepagePage.clickAddToCartFirstProduct();
        assertEquals(homepagePage.getShoppingCartBadge().getText(), homepagePage.getClicksOnAddToCart());
    }

}
