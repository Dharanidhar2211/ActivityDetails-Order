package AbstractData;

import org.openqa.selenium.By;
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

    @FindBy(css = "[routerlink*='cart']")
    WebElement clickOnCart;
    public void VisibilityofElement(WebElement Wait1)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(Wait1));
    }
    public void InVisibilityofElement(WebElement Wait1) throws InterruptedException {
         //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.invisibilityOf(Wait1));
        Thread.sleep(1000);
    }
    public void clickOnCart() {

        clickOnCart.click();
    }



}
