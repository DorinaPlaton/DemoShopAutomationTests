import com.aventstack.extentreports.Status;
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


    @Test(description = "Testing the functionality of adding a product to the Wishlist from the product page")
    public void addProductToWishlist() {
        wishlistPage.clickGorgeousSoftPizzaProduct();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Accessing the product page");
        wishlistPage.clickAddToWishlist();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Adding the product to the Wishlist");
        wishlistPage.clickShowWishlist();
        assertEquals( wishlistPage.getProductInWishlist().getText(), "Gorgeous Soft Pizza");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Checking the presence of the product on the Wishlist page");

    }

    @Test(description = "Testing deleting a product from the Wishlist after adding two products to the Wishlist")
    public void deleteProductFromWishlist() throws InterruptedException {
        addProductToWishlist();
        wishlistPage.clickBrandLogo();
        wishlistPage.clickAwesomeMetalChair();
        wishlistPage.clickAddToWishlist();
        wishlistPage.clickShowWishlist();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Adding 2 products to the Wishlist");
        assertEquals(wishlistPage.getWishlistBadge().getText(), "2");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The index number of the Wishlist badge changed to: " + wishlistPage.getWishlistBadge().getText());
        wishlistPage.clickDeleteFirstProductFromWishlist();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Delete the first product from the Wishlist");
        assertEquals(wishlistPage.getWishlistBadge().getText(), "1");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The index number of the Wishlist badge updated to: " + wishlistPage.getWishlistBadge().getText());
    }

    @Test(description = "Testing adding a product to the cart from the Wishlist")
    public void addProductToCartFromWishlist() {
        addProductToWishlist();
        wishlistPage.clickAddToCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Adding the product from Wishlist to the Cart");
        assertEquals(wishlistPage.getCartBadge().getText(), "1");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The index number of the Cart badge has been updated to: " + wishlistPage.getCartBadge().getText());
    }

    @Test(description = "Testing adding products to Wishlist from the Homepage")
    public void addProductsToWishlistFromHomepage() {
        wishlistPage.clickWishlistButtonIncredibleConcreteHat();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Adding 'Incredible Concrete Hat' to the Wishlist from the Homepage");
        wishlistPage.clickWishlistButtonPracticalWoodenBacon();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Adding 'Practical Wooden Bacon' to the Wishlist from the Homepage");
        assertEquals(wishlistPage.getWishlistBadge().getText(), "2");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The index number of the Wishlist badge has been updated to: " + wishlistPage.getWishlistBadge().getText());
    }

    @Test(description = "Testing deleting a product from the Wishlist using the Homepage")
    public void  deleteProductWishlistFromHomepage() {
        addProductsToWishlistFromHomepage();
        wishlistPage.clickWishlistButtonIncredibleConcreteHat();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Remove one of the products from the Wishlist");
        assertEquals(wishlistPage.getWishlistBadge().getText(), "1");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The index number of the Wishlist badge has been updated to: " + wishlistPage.getWishlistBadge().getText());
    }


}
