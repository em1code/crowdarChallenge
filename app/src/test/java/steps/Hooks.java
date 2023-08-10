package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import pages.BasePage;

// @author emiliano.molina

public class Hooks extends BasePage {

    public Hooks() {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    
    @After
    public void tearDown(Scenario scenario){
       if(scenario.isFailed()){
            scenario.log("Scenario FAILED");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
       }  
    }
}
