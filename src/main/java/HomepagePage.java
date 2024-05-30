import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepagePage extends BasePage {

    public WebDriverWait wait;

    public HomepagePage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }


    //Searchbar homepage
    @FindBy(id = "input-search")
    private WebElement searchbarField;
    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButton;
    @FindBy(xpath = "(//div[@class='card'])[1]//a")
    private WebElement productWoodenBacon1;
    @FindBy(xpath = "(//div[@class='card'])[2]//a")
    private WebElement productWoodenBacon2;
    @FindBy(xpath = "(//div[@class='card'])[3]//a")
    private WebElement productMetalMouse;
    @FindBy(css = ".sort-products-select.form-control.form-control-sm")
    private WebElement sortDropdownMenu;
    @FindBy(xpath = "//option[@value=\'az\']")
    private WebElement sortByNameAToZ;
    @FindBy(xpath = "//option[@value=\'za\']")
    private WebElement sortByNameZToA;
    @FindBy(xpath = "//option[@value=\'lohi\']")
    private WebElement sortByPriceLoToHi;
    @FindBy(xpath = "//option[@value=\'hilo\']")
    private WebElement sortByPriceHiToLo;
    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-2x")
    private WebElement addToCartFirstProduct;
    @FindBy(css = ".fa-layers-counter.shopping_cart_badge")
    private WebElement shoppingCartBadge;
    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement awesomeGraniteChipsProduct;
    @FindBy(css = ".svg-inline--fa.fa-shopping-bag.fa-w-14.fa-3x.brand-logo")
    private WebElement logoIcon;
    @FindBy(css = ".subheader-container .text-muted")
    private WebElement subheaderHomepage;
    @FindBy(css = ".svg-inline--fa.fa-undo.fa-w-16")
    private WebElement resetButton;
    @FindBy(linkText = "Awesome Soft Shirt")
    private WebElement awesomeSoftShirtProduct;
    @FindBy(xpath = "(//div[@class= 'card'])[1]//a")
    private WebElement firstProduct;
    @FindBy(xpath = "(//div[@class= 'card'])[10]//a")
    private WebElement lastProduct;
    @FindBy(xpath = "(//div[@class= 'card'])[1]//span")
    private WebElement firstProductPrice;
    @FindBy(xpath = "(//div[@class= 'card'])[10]//span")
    private WebElement lastProductPrice;

    public char getFirstProduct() {
        String firstString = firstProduct.getText();
        return firstString.charAt(0);
    }

    public char getLastProduct() {
        String lastString = lastProduct.getText();
        return lastString.charAt(0);
    }

    public double getFirstProductPrice() {
        String firstProductValue = firstProductPrice.getText();
        return Double.parseDouble(firstProductValue);
    }

    public double getLastProductPrice() {
        String lastProductValue = lastProductPrice.getText();
        return Double.parseDouble(lastProductValue);
    }

    public void inputSearchbar() {
        searchbarField.sendKeys("Practical");
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public WebElement getProductWoodenBacon1() {
        return productWoodenBacon1;
    }
    public WebElement getProductWoodenBacon2() {
        return productWoodenBacon2;
    }

    public WebElement getProductMetalMouse() {
        return productMetalMouse;
    }

    public void clickSortDropdownMenu() {
        sortDropdownMenu.click();
    }

    public void selectSortByNameAToZ() {
        sortByNameAToZ.click();
    }

    public void selectSortByNameZToA() {
        sortByNameZToA.click();
    }

    public void selectSortByPriceLoToHi() {
        sortByPriceLoToHi.click();
    }

    public void selectSortByPriceHiToLo() {
        sortByPriceHiToLo.click();
    }

    public void clickAddToCartFirstProduct() {
        for (int i = 1; i <= 5; i++) {
            addToCartFirstProduct.click();
        }
    }

    public String getClicksOnAddToCart() {
        int expectedClicks = 5;
        return Integer.toString(expectedClicks);
    }

    public WebElement getShoppingCartBadge() {
        return shoppingCartBadge;
    }

    public void clickAwesomeGraniteChipsProduct() {
        awesomeGraniteChipsProduct.click();
    }

    public WebElement getAwesomeGraniteChipsProduct() {
        return awesomeGraniteChipsProduct;
    }

    public void clickLogoIcon() {
        logoIcon.click();
    }

    public WebElement getSubheaderHomepage() {
        return subheaderHomepage;
    }

    public void clickResetButton() {
        resetButton.click();
    }

    public WebElement getResetButton() {
        return resetButton;
    }

    public WebElement getAwesomeSoftShirtProduct() {
        return awesomeSoftShirtProduct;
    }

}


