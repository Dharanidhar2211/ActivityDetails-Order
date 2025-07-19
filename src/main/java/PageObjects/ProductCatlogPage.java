package PageObjects;

import AbstractData.AbstarctData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatlogPage extends AbstarctData
{
    public WebDriver driver;

    public ProductCatlogPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".mb-3")
    WebElement w1;


    @FindBy(css = ".mb-3")
    List<WebElement> products;


    @FindBy(css = ".ng-animating")
    WebElement w3;



    @FindBy(xpath = "//div[text()=' Product Added To Cart ']")
    WebElement w2;


    public List<WebElement> getProducts()
    {
        VisibilityofElement(w1);
        return products;
    }
    public WebElement getProductByName(String productName)
    {
        WebElement prod = getProducts().stream().filter(s -> s.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }
    public CartPage addProductToCart(String productName) throws InterruptedException {
        WebElement prod=getProductByName(productName).findElement(By.cssSelector(".card-body button:last-of-type"));
        prod.click();
        VisibilityofElement(w2);
        InVisibilityofElement(w3);
        clickOnCart();
        CartPage cartpage= new CartPage(driver);
        return cartpage;
    }


}
