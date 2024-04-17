import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Listeners(ExtentTestNGITestListener.class)

public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Test the checkout process")
    public void checkout() throws InterruptedException {
        checkoutPage.addProductToCart();
        checkoutPage.completeMandatoryFields();
        checkoutPage.placeTheOrder();
        assertEquals(checkoutPage.getOrderSuccessMessage().getText(), "Thank you for your order!");

    }

//    @Test(description = "Increasing the quantity of the product in the checkout cart.")
//    public void increaseProductQuantityInCheckout() throws InterruptedException {
//        checkoutPage.addProductToCart();
//        checkoutPage.clickIncreaseQuantityOfProduct();
//        assertEquals(checkoutPage.getProductsAmount().getText(), "$31.98");
//    }

    @Test(description = "Calculating the total amount of the cart after updating the quantity of product to 2.")
    public void increaseQuantityOfTheProduct() {
        checkoutPage.clickGraniteChipsProduct();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickShowCart();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is: " + checkoutPage.productPrice());
        double expectedTotalAmount = checkoutPage.productPrice() * 2;
        checkoutPage.clickIncreaseQuantityOfProduct();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product after updating the quantity to 2 is: " + checkoutPage.productPrice());
        assertEquals(checkoutPage.productPrice(),expectedTotalAmount);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price after updating the quantity is correct.");
    }

    @Test(description = "Calculating the total price with taxes")
    public void totalAmountWithTaxesTest() {
        checkoutPage.clickGraniteChipsProduct();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickShowCart();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is: " + checkoutPage.productPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the tax is: " + checkoutPage.taxPrice());
        double expectedTotal = checkoutPage.productPrice() + checkoutPage.taxPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The total price should be: " + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The total price is: " + checkoutPage.finalAmount());
        assertEquals(checkoutPage.finalAmount(), expectedTotal);
    }

    @Test(description = "Fill all the mandatory fields for the checkout except first name")
    public void testEmptyFirstNameMandatoryField() throws InterruptedException {
        checkoutPage.addProductToCart();
        checkoutPage.clickCheckoutButton();
        checkoutPage.setLastName();
        checkoutPage.setAddressField();
        checkoutPage.clickContinueCheckoutButton();
        assertEquals(checkoutPage.getErrorMessageMandatoryFields().getText(), "First Name is required");
    }

    @Test(description = "Fill all the mandatory fields for the checkout except last name")
    public void testEmptyLastNameMandatoryField() throws InterruptedException {
        checkoutPage.addProductToCart();
        checkoutPage.clickCheckoutButton();
        checkoutPage.setFirstName();
        checkoutPage.setAddressField();
        checkoutPage.clickContinueCheckoutButton();
        assertEquals(checkoutPage.getErrorMessageMandatoryFields().getText(), "Last Name is required");
    }

    @Test(description = "Fill all the mandatory fields for the checkout except address field")
    public void testEmptyAddressMandatoryField() throws InterruptedException {
        checkoutPage.addProductToCart();
        checkoutPage.clickCheckoutButton();
        checkoutPage.setFirstName();
        checkoutPage.setLastName();
        checkoutPage.clickContinueCheckoutButton();
        assertEquals(checkoutPage.getErrorMessageMandatoryFields().getText(), "Address is required");
    }


}
