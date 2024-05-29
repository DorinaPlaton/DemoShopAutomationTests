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


    @Test(description = "Testing adding a product to the Wishlist functionality")
    public void addProductToWishlist() {
        wishlistPage.clickGorgeousSoftPizzaProduct();
        wishlistPage.clickAddToWishlist();
        wishlistPage.clickShowWishlist();
        assertEquals( wishlistPage.getProductInWishlist().getText(), "Gorgeous Soft Pizza");

    }

    @Test(description = "Testing deleting a product from the Wishlist after adding two products to the Wishlist")
    public void deleteProductFromWishlist() throws InterruptedException {
        addProductToWishlist();
        wishlistPage.clickBrandLogo();
        wishlistPage.clickAwesomeMetalChair();
        wishlistPage.clickAddToWishlist();
        wishlistPage.clickShowWishlist();
        assertEquals(wishlistPage.getShoppingCartBadge().getText(), "2");
        wishlistPage.clickDeleteFirstProductFromWishlist();
        assertEquals(wishlistPage.getShoppingCartBadge().getText(), "1");
    }

    @Test(description = "Testing adding a product to the cart from the Wishlist")
    public void addProductToCartFromWishlist() {
        addProductToWishlist();
        wishlistPage.clickAddToCartButton();
        assertEquals(wishlistPage.getCartBadge().getText(), "1");
    }


}
