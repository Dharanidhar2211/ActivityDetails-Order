package Order.Test;
import PageObjects.CartPage;
import PageObjects.LandingPage;
import PageObjects.PaymentPage;
import PageObjects.ProductCatlogPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SubmitOrderTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTO();
        landingPage.login("dharanidhar220@gmail.com", "Ilovecricket@123");
        ProductCatlogPage productcatlogpage = new ProductCatlogPage(driver);
        List<WebElement> products=productcatlogpage.getProducts();
        productcatlogpage.addProductToCart("ZARA COAT 3");
        CartPage cartpage= new CartPage(driver);
        boolean match= cartpage.cartProduct("ZARA COAT 3");
        Assert.assertTrue(match);
        cartpage.clickonCheckout();
        PaymentPage paymentPage = new PaymentPage(driver);
        String confirmMsg=paymentPage.selectCountry_PlaceOrder();
        Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
        driver.close();
    }
}