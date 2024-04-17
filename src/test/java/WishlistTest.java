import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Listeners(ExtentTestNGITestListener.class)


public class WishlistTest extends Hooks {

    public WishlistPage wishlistPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        wishlistPage = new WishlistPage(driver);
        wait = new WebDriverWait(driver, 10);
    }


    @Test
    public void addProductToWishlist() throws InterruptedException {
        wishlistPage.clickGorgeousSoftPizzaProduct();
        wishlistPage.clickAddToWishlist();
        wishlistPage.clickShowWishlist();
        assertEquals( wishlistPage.getProductInWishlist().getText(), "Gorgeous Soft Pizza");

    }

    @Test
    public void deleteProductFromWishlist() throws InterruptedException {
        addProductToWishlist();
        wishlistPage.clickDeleteProductFromWishlist();

    }


}
