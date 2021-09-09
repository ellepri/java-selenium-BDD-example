package com.exercise.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage {

    private final WebDriver driver;

    public IndexPage (WebDriver driver) {
        this.driver = driver;

        if (!("My Store".equals(driver.getTitle()))) {
            throw new IllegalStateException("This is not the index page.");
        }
    }

    public void clickSignIn(){
        driver.findElement(By.cssSelector(".login")).click();
    }
}
