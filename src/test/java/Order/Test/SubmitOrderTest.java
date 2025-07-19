package Order.Test;
import Order.TestComponents.BestTest;
import PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SubmitOrderTest extends BestTest {
    @Test(priority = 1,groups = "PurchaseOrderTest")
    public static void submitOrdertest() throws InterruptedException
    {
        ProductCatlogPage productcatlogpage = landingPage.login("dharanidhar220@gmail.com", "Ilovecricket@123");
        List<WebElement> products=productcatlogpage.getProducts();
        CartPage cartpage=  productcatlogpage.addProductToCart("ZARA COAT 3");
        boolean match= cartpage.cartProduct("ZARA COAT 3");
        Assert.assertTrue(match);
        PaymentPage paymentPage=cartpage.clickonCheckout();
        String confirmMsg=paymentPage.selectCountry_PlaceOrder();
        Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
    }
    @Test(priority = 2)
    public void OrderItemTest()
    {
        ProductCatlogPage productcatlogpage = landingPage.login("dharanidhar2211@gmail.com", "Ilovecricket@123");
        OrderPage orderpage=landingPage.clickonOrders();
        String orderName=orderpage.ValidateOrder();
        Assert.assertEquals(orderName, "ADIDAS ORIGINAL");
    }

}