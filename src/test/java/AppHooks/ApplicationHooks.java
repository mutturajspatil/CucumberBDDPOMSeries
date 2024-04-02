package AppHooks;

import com.qa.util.ConfigReader;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.sql.Driver;
import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;

    Properties prop;

    private ConfigReader configReader;

    @Before(order = 0)
    public void getProperty() throws FileNotFoundException {
        configReader = new ConfigReader();
        prop=configReader.init_prop();
    }


    @Before(order = 1)
    public void launchBrowser(){
        String browserName=prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver=driverFactory.init_driver(browserName);
    }


    @After (order = 0 )
    public void quitBrowser(){
        driver.quit();
    }

    @After(order =1)
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            //take screenshot method

            String screenshotName=scenario.getName().replaceAll("","_");
            byte [] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

            scenario.attach(sourcePath,"image/png",screenshotName);
        }


    }
}
