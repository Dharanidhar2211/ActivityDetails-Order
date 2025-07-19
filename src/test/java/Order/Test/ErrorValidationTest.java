package Order.Test;

import Order.TestComponents.BestTest;
import PageObjects.CartPage;
import PageObjects.ProductCatlogPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ErrorValidationTest extends BestTest {
    @Test
    public void LoginErrorTest() {
        ProductCatlogPage productcatlogpage = landingPage.login("dharanidhar220@gmail.com", "Ilovecricket@1231");
        String ErrorText = landingPage.ErrorPopUp();
        Assert.assertEquals(ErrorText, "Incorrect email or password.");
    }

    @Test
    public void OrderErrorTest() throws InterruptedException
    {
        ProductCatlogPage productcatlogpage = landingPage.login("dharanidhar220@gmail.com", "Ilovecricket@123");
        List<WebElement> products=productcatlogpage.getProducts();
        CartPage cartpage=  productcatlogpage.addProductToCart("ZARA COAT 3");
        boolean match= cartpage.cartProduct("ZARA COAT #");
        Assert.assertFalse(match);
    }
}

