package PageObjects;

import AbstractData.AbstarctData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstarctData {
    public WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(xpath = "//input[contains(@type,'submit')]")
    WebElement submitButton;
    @FindBy(css = ".toast-error")
    WebElement toastmsg;
    public void goTO()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }

    // Renamed for convention
    public ProductCatlogPage login(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        submitButton.click();
        ProductCatlogPage productcatlogpage = new ProductCatlogPage(driver);
        return productcatlogpage;
    }
    public String ErrorPopUp()
    {
        String ToastError=toastmsg.getText();
        return ToastError;

    }
}