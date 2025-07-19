package Order.Test;
import Order.TestComponents.BestTest;
import PageObjects.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BestTest {
    @Test(priority = 1,groups = "PurchaseOrderTest",dataProvider = "getdata")
    public static void submitOrdertest(HashMap<String,String> input) throws InterruptedException
    {
        ProductCatlogPage productcatlogpage = landingPage.login(input.get("email"), input.get("password"));
        List<WebElement> products=productcatlogpage.getProducts();
        CartPage cartpage=  productcatlogpage.addProductToCart(input.get("item"));
        boolean match= cartpage.cartProduct(input.get("item"));
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
    @DataProvider
    public Object[][] getdata() throws IOException {
        List<HashMap<String,String>> data = getjsonData(System.getProperty("user.dir") + "\\src\\main\\java\\Order\\DataComponents\\data.json");
        return new Object[][] { {data.get(0)}, {data.get(1)} };
    }

}