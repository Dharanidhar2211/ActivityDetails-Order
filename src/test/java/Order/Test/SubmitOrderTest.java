package Order.Test;
import PageObjects.LandingPage;
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTO();
        landingPage.login("dharanidhar220@gmail.com", "Ilovecricket@123");

        ProductCatlogPage productcatlogpage = new ProductCatlogPage(driver);
        List<WebElement> products=productcatlogpage.getProducts();
        productcatlogpage.addProductToCart("ZARA COAT 3");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div h1")));
        List<WebElement> cproducts = driver.findElements(By.cssSelector(".cartSection h3"));
        boolean match = cproducts.stream().anyMatch(s -> s.getText().equalsIgnoreCase("ZARA COAT 3"));

        Assert.assertTrue(match);

        driver.findElement(By.xpath("//button[text()='Checkout']")).click();

        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')]) [2]")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".hero-primary"))));
        String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
        driver.close();
    }
}