package stepsdefinitions;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static BaseClass base;

    @Before
    public void startBrowser() {

        if (base == null) {
            base = new BaseClass();
            base.setup();   //  start only once
        }
    }

    @After
    public void takeScreenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {

            TakesScreenshot ts = (TakesScreenshot) base.driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

        
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
    @AfterAll
    public static void tearDown() {
        if (base != null) {
            base.tearDown();
        }
    }
}