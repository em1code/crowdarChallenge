package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "steps", plugin = {
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "json:target/cucumber-reports.json" }, monochrome = true, tags = "@Login")

public class LoginRunner {
    @BeforeClass
    public static void fullScreen() {
        BasePage.maximizeWindow();
    }

    @AfterClass
    public static void cleanDriver() {
        BasePage.closeBrowser();
    }
}
