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
    public void checkoutTest() {
        checkoutPage.addProductToCart();
        checkoutPage.completeMandatoryFields();
        checkoutPage.placeTheOrder();
        assertEquals(checkoutPage.getOrderSuccessMessage().getText(), "Thank you for your order!");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The order was placed successfully receiving the message 'Thank you for your order!'");

    }

    @Test(description = "Calculating the total amount of the cart after updating the quantity of product to 2.")
    public void increaseQuantityOfTheProduct() {
        checkoutPage.clickGraniteChipsProduct();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickShowCart();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is: " + checkoutPage.productPrice());
        double expectedTotalAmount = checkoutPage.productPrice() * 2;
        checkoutPage.clickIncreaseQuantityOfProduct();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product after updating the quantity to 2 is: " + checkoutPage.productPrice());
        assertEquals(checkoutPage.productPrice(), expectedTotalAmount);
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
    public void testEmptyFirstNameMandatoryField() {
        checkoutPage.addProductToCart();
        checkoutPage.clickCheckoutButton();
        checkoutPage.setLastName();
        checkoutPage.setAddressField();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Completed all the mandatory fields except the First Name field");
        checkoutPage.clickContinueCheckoutButton();
        assertEquals(checkoutPage.getErrorMessageMandatoryFields().getText(), "First Name is required");
    }

    @Test(description = "Fill all the mandatory fields for the checkout except last name")
    public void testEmptyLastNameMandatoryField() {
        checkoutPage.addProductToCart();
        checkoutPage.clickCheckoutButton();
        checkoutPage.setFirstName();
        checkoutPage.setAddressField();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Completed all the mandatory fields except the Last Name field");
        checkoutPage.clickContinueCheckoutButton();
        assertEquals(checkoutPage.getErrorMessageMandatoryFields().getText(), "Last Name is required");
    }

    @Test(description = "Fill all the mandatory fields for the checkout except address field")
    public void testEmptyAddressMandatoryField() {
        checkoutPage.addProductToCart();
        checkoutPage.clickCheckoutButton();
        checkoutPage.setFirstName();
        checkoutPage.setLastName();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Completed all the mandatory fields except Address field");
        checkoutPage.clickContinueCheckoutButton();
        assertEquals(checkoutPage.getErrorMessageMandatoryFields().getText(), "Address is required");
    }

    @Test(description = "Testing if the checkout page shows the right price amount after adding 2 different products to the cart")
    public void testSumOf2Products() {
        checkoutPage.clickIncredibleConcreteHatCartButton();
        checkoutPage.clickPracticalWoodenBaconCartButton();
        checkoutPage.clickShowCart();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the first product is " + checkoutPage.productPrice1());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the second product is " + checkoutPage.productPrice2());
        double expectedProductsSum = checkoutPage.productPrice1() + checkoutPage.productPrice2();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The total price of the products should be: " + expectedProductsSum);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The total price of the products is: " + checkoutPage.totalValue());
        assertEquals(checkoutPage.totalValue(), expectedProductsSum);
    }

    @Test(description = "Testing adding the same product to the cart twice and deleting one by decreasing the number of the product in the cart.")
    public void testDecreasingNrOfTheProduct() {
        checkoutPage.clickIncredibleConcreteHatCartButton();
        checkoutPage.clickIncredibleConcreteHatCartButton();
        checkoutPage.clickShowCart();
        assertEquals(checkoutPage.getProductQuantityNr().getText(), "2");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The number of the products in the cart is: " + checkoutPage.getProductQuantityNr().getText());
        checkoutPage.clickDecreaseProductButton();
        assertEquals(checkoutPage.getProductQuantityNr().getText(),"1");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The number of the products in the cart after decreasing it by one is: " + checkoutPage.getProductQuantityNr().getText());
    }

    @Test(description = "Testing deleting product from the cart using the trashcan button")
    public void testDeleteWithTrashcan() {
        checkoutPage.clickIncredibleConcreteHatCartButton();
        checkoutPage.clickShowCart();
        checkoutPage.clickTrashcanButton();
        assertEquals(checkoutPage.getEmptyCartMessage().getText(), "How about adding some products in your cart?");
    }
}
