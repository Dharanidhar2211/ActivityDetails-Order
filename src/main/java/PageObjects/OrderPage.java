package PageObjects;

import AbstractData.AbstarctData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstarctData
{
    public WebDriver driver;

    public OrderPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//tr/td[2]")
    List<WebElement> orderNameElement;

    public String ValidateOrder()
    {
        clickonOrders();
        String orderName=orderNameElement.get(0).getText();
        return orderName;


    }

}
