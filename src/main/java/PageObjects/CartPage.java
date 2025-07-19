package PageObjects;

import AbstractData.AbstarctData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstarctData
{
    private WebDriver driver;

    public CartPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".cartSection h3")
    List<WebElement> cproductsList;

    @FindBy(css = "div h1")
    WebElement w3;


    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkoutButton;
    public boolean cartProduct(String item)
    {
        VisibilityofElement(w3);
        boolean match = cproductsList.stream().anyMatch(s -> s.getText().equalsIgnoreCase(item));
        return match;
    }
    public void clickonCheckout()
    {
        checkoutButton.click();
    }



}
