package Order.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/cucumber",
        glue = "Order.stepDefinations",
        monochrome = true,
        plugin = {"html:target/cucumber.html"}
)
public class TestTestNgTestRunner extends AbstractTestNGCucumberTests {
}