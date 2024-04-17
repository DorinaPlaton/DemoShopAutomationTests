import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage extends BasePage {

    public WebDriverWait wait;

    public WishlistPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }
    @FindBy(linkText = "Gorgeous Soft Pizza")
    private WebElement gorgeousSoftPizzaProduct;
    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16.fa-3x ")
    private WebElement addToWishlist;
    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16 ")
    private WebElement showWishlist;
    @FindBy(css = ".card-link")
    private WebElement productInWishlist;

    public void clickGorgeousSoftPizzaProduct() {
        gorgeousSoftPizzaProduct.click();
    }
    public void clickAddToWishlist() {
        addToWishlist.click();
    }
    public void clickShowWishlist() {
        showWishlist.click();
    }
    public WebElement getProductInWishlist() {
        return productInWishlist;
    }


    //delete from wishlist
    @FindBy(css = ".svg-inline--fa.fa-heart-broken.fa-w-16.fa-2x")
    private WebElement deleteFromWishlistButton;

    public void clickDeleteProductFromWishlist() {
        deleteFromWishlistButton.click();
    }
}
