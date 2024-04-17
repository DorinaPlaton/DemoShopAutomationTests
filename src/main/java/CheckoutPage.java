import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

    public WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement graniteChipsProduct;
    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x ")
    private WebElement addToCartButton;
    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18 ")
    private WebElement showCartButton;
    @FindBy(css = ".btn.btn-success")
    private WebElement checkoutButton;
    @FindBy(id = "first-name")
    private WebElement firstNameField;
    @FindBy(id = "last-name")
    private WebElement lastNameField;
    @FindBy(id = "address")
    private WebElement addressField;
    @FindBy(css = ".btn.btn-success")
    private WebElement continueCheckoutButton;
    @FindBy(css = ".btn.btn-success")
    private WebElement completeYourOrderButton;
    @FindBy(css = ".text-center")
    private WebElement orderSuccessMessage;
    @FindBy(css = ".amount")
    private WebElement productsAmount;
    @FindBy(css = ".error")
    private WebElement errorMessageMandatoryFields;
    @FindBy(xpath = "(//td[@class='amount'])[1]")
    private WebElement itemsTotal;
    public WebElement getItemsTotal() {
        return itemsTotal;
    }
    public double productPrice() {
        String amountValue = itemsTotal.getText();
        String cleanAmountValue = amountValue.replace("$","");
        double doubleAmountValue = Double.parseDouble(cleanAmountValue);
        return doubleAmountValue;
        // return Double.parseDouble(cleanAmountValue);
    }

    @FindBy(xpath = "(//td[@class='amount'])[2]")
    private WebElement itemsTaxAmount;
    public double taxPrice() {
        String taxValue = itemsTaxAmount.getText();
        String cleanTaxValue = taxValue.replace("$","");
        return Double.parseDouble(cleanTaxValue);
    }

    @FindBy(xpath = "(//td[@class='amount'])[3]")
    private WebElement itemsFinalAmount;
    public double finalAmount() {
        String finalAmountValue = itemsFinalAmount.getText();
        String cleanFinalAmount = finalAmountValue.replace("$","");
        return Double.parseDouble(cleanFinalAmount);
    }


    public void clickGraniteChipsProduct() {
        graniteChipsProduct.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickShowCart() {
        showCartButton.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public void setFirstName() {
        firstNameField.sendKeys("Prenume");
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public void setLastName() {
        lastNameField.sendKeys("Nume");
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public void setAddressField() {
        addressField.sendKeys("Strada Principala 77");
    }

    public WebElement getAddressField() {
        return addressField;
    }

    public void clickContinueCheckoutButton() {
        continueCheckoutButton.click();
    }

    public void clickCompleteYourOrder() {
        completeYourOrderButton.click();
    }

    public WebElement getOrderSuccessMessage() {
        return orderSuccessMessage;
    }

    public WebElement getProductsAmount() {
        return productsAmount;
    }

    public WebElement getErrorMessageMandatoryFields() {
        return errorMessageMandatoryFields;
    }

    public void addProductToCart() {
        clickGraniteChipsProduct();
        clickAddToCartButton();
        clickShowCart();
    }

    public void completeMandatoryFields() {
        clickCheckoutButton();
        setFirstName();
        setLastName();
        setAddressField();
    }

    public void placeTheOrder() {
        clickContinueCheckoutButton();
        clickCompleteYourOrder();
    }

    //Increase number of product
    @FindBy(css = ".svg-inline--fa.fa-plus-circle.fa-w-16")
    private WebElement increaseQuantityOfProduct;

    public void clickIncreaseQuantityOfProduct() {
        increaseQuantityOfProduct.click();
    }


}
