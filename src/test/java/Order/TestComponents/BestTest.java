package Order.TestComponents;

import PageObjects.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BestTest
{
    public static WebDriver driver;
    public static LandingPage landingPage;
    public WebDriver launchBrowser() throws IOException {
        Properties prop=new Properties();
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\Order\\DataComponents\\Browser.properties";
        FileInputStream fis=new FileInputStream(path);
        prop.load(fis);
        String BrowserName=System.getProperty("browser")!= null ? System.getProperty("browser") : prop.getProperty("browser");
        if(BrowserName.equalsIgnoreCase("chrome"))
        {
             driver = new ChromeDriver();
        }
        else if (BrowserName.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        else if (BrowserName.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
    @BeforeMethod(alwaysRun = true)
    public void initDriver() throws IOException
    {
        driver = launchBrowser();
        landingPage = new LandingPage(driver);
        landingPage.goTO();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        driver.close();
    }

}
