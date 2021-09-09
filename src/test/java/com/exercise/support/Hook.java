package com.exercise.support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hook {
    private final World world;

    public Hook(World world){
        this.world = world;
    }

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        world.setDriver(new ChromeDriver());
        world.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        world.setBaseUrl("http://automationpractice.com/index.php");
    }

    @After()
    public void closeBrowser() {
        world.getDriver().manage().deleteAllCookies();
        world.getDriver().quit();
    }

//    @AfterStep
//    public void afterStep(Scenario scenario) throws IOException {
//        File scrFile = ((TakesScreenshot)world.getDriver()).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File(scenario.getName().trim() + "screenshot.png"));
//    }
}
