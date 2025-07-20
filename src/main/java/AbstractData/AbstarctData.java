package AbstractData;

import PageObjects.OrderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstarctData
{
    public WebDriver driver;

    public AbstarctData(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "button[routerlink*='myorders']")
    WebElement ordersButton;
    public OrderPage clickonOrders()
    {
        ordersButton.click();
        OrderPage orderpage=new OrderPage(driver);
        return orderpage;
    }

    @FindBy(css = "button[routerlink*='cart']")
    WebElement clickOnCart;

    public void VisibilityofElement(WebElement Wait1)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Wait1));
    }
    public void InVisibilityofElement(WebElement Wait1) throws InterruptedException {
         //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.invisibilityOf(Wait1));
        Thread.sleep(3000);
    }
    public void clickOnCart() {

        clickOnCart.click();
    }



}
