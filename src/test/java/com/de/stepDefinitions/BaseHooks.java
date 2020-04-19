package com.de.core;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseHooks {

    @Before
    public void setUP(){
        System.out.println("setup done");
    }
    @After
    public void tearDown(Scenario scenario) throws Exception {
            scenario.embed(((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
//            DriverManager.getDriver().quit();
//    if (scenario.isFailed()) {
//            System.out.println(scenario.getName() + "is Failed");
//            byte[] screenshot = getScreenShot();
//            scenario.embed(screenshot, "image/png");
//            String testName = scenario.getName();
//            scenario.write(testName);
//        } else {
//            byte[] screenshot = getScreenShot();
//            scenario.embed(screenshot, "image/png");
//        }
//        DriverManager.getDriver().quit();
    }

    public byte[] getScreenShot() {
        return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
