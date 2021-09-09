package com.exercise.support;

import org.openqa.selenium.WebDriver;

public class World {
    private WebDriver driver;
    private String baseUrl;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setBaseUrl(String url) {
        this.baseUrl = url;
    }

    public String getBaseUrl(){
        return baseUrl;
    }
}
