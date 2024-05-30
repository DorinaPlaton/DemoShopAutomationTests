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
    @FindBy(css = ".fa-layers-counter.shopping_cart_badge")
    private WebElement wishlistBadge;
    @FindBy(css = ".svg-inline--fa.fa-heart-broken.fa-w-16.fa-2x")
    private WebElement deleteFromWishlistButton;
    @FindBy(css = ".svg-inline--fa.fa-shopping-bag.fa-w-14.fa-3x.brand-logo")
    private WebElement brandLogo;
    @FindBy(linkText = "Awesome Metal Chair")
    private WebElement awesomeMetalChairProduct;
    @FindBy(xpath = "//div[@class='row row-cols-xl-4 row-cols-lg-3 row-cols-md-2 row-cols-sm-2 row-cols-1']/div[1]//button[2]")
    private WebElement firstProductDeleteFromWishlist;
    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-2x")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='navbar-collapse collapse']//span/a[1]/span")
    private WebElement cartBadge;
    @FindBy(xpath = "//div[@class='row row-cols-xl-4 row-cols-lg-3 row-cols-md-2 row-cols-sm-2 row-cols-1']//div[5]//button[2]")
    private WebElement incredibleConcreteHatWishlistButton;
    @FindBy(xpath = "//div[@class='row row-cols-xl-4 row-cols-lg-3 row-cols-md-2 row-cols-sm-2 row-cols-1']//div[9]//button[2]")
    private WebElement practicalWoodenBaconWishlistButton;


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

    public void clickDeleteProductFromWishlist() {
        deleteFromWishlistButton.click();
    }

    public WebElement getWishlistBadge() {
        return wishlistBadge;
    }

    public void clickBrandLogo() {
        brandLogo.click();
    }

    public void clickAwesomeMetalChair() {
        awesomeMetalChairProduct.click();
    }

    public void clickDeleteFirstProductFromWishlist() {
        firstProductDeleteFromWishlist.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public WebElement getCartBadge() {
        return cartBadge;
    }

    public void clickWishlistButtonIncredibleConcreteHat() {
        incredibleConcreteHatWishlistButton.click();
    }

    public void clickWishlistButtonPracticalWoodenBacon() {
        practicalWoodenBaconWishlistButton.click();
    }
}
