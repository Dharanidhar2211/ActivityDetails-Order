package PageObjects;

import AbstractData.AbstarctData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends AbstarctData {

    private WebDriver driver;

    public PaymentPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".ta-results")
    WebElement w5;

    @FindBy(css = "[placeholder='Select Country']")
    WebElement con;

    @FindBy(xpath = "(//button[contains(@class,'ta-item')]) [2]")
    WebElement India;

    @FindBy(css = ".action__submit")
    WebElement placeOrder;


    @FindBy(css = ".hero-primary")
    WebElement w6;

    @FindBy(css = ".hero-primary")
    WebElement confirmMessage;
    public String selectCountry_PlaceOrder()
    {
        Actions a = new Actions(driver);
        a.sendKeys(con, "India").build().perform();
        VisibilityofElement(w5);
        India.click();
        placeOrder.click();
        VisibilityofElement(w6);
        String confirmMsg = confirmMessage.getText();
        return confirmMsg;
    }
}
