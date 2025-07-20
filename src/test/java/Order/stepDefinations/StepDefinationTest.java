
package Order.stepDefinations;

import Order.TestComponents.BestTest;
import PageObjects.CartPage;
import PageObjects.LandingPage;
import PageObjects.PaymentPage;
import PageObjects.ProductCatlogPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class StepDefinationTest extends BestTest
{
    public LandingPage landingPage;
    public ProductCatlogPage productcatlogpage;
    public CartPage cartpage;
    public PaymentPage paymentPage;

    @Given("Open the browser")
    public void openBrowser() throws IOException
    {
        driver = launchBrowser();
    }

    @Given("Login with  valid {string} and {string}")
    public void loginWithValidCredentials(String email, String password)
    {
        landingPage = new LandingPage(driver);
        productcatlogpage = landingPage.login(email, password);
    }

    @When("I add product to the cart {string}")
    public void addProductToCart(String item) throws InterruptedException {
        List<WebElement> products = productcatlogpage.getProducts();
        cartpage = productcatlogpage.addProductToCart(item);
        boolean match = cartpage.cartProduct(item);
        Assert.assertTrue(match);
    }

    @And("Checkout the item {string} and submit the order")
    public void checkoutAndSubmitOrder(String item)
    {
        paymentPage = cartpage.clickonCheckout();
    }

    @Then("{string} should be displayed")
    public void verifyOrderConfirmation(String expectedMessage)
    {
        String confirmMsg = paymentPage.selectCountry_PlaceOrder();
        Assert.assertTrue(confirmMsg.equalsIgnoreCase(expectedMessage));
    }

    @And("Close the browser")
    public void closeBrowser()
    {
        driver.close();
    }
}