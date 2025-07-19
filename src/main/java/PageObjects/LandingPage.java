package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(xpath = "//input[contains(@type,'submit')]")
    WebElement submitButton;

    // Renamed for convention
    public void login(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        submitButton.click();
    }
}