package com.exercise.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountPage {
    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;

        if (!("My account - My Store".equals(driver.getTitle()))){
            throw new IllegalStateException("This is not the My Account page.");
        }
    }

    public void clickMenuItem(String menuName){
        List<WebElement> dressesMenuItem = driver.findElements(By.cssSelector("a[title='" + menuName + "']"));
        dressesMenuItem.get(1).click();
    }

    public void logout(){
        WebElement logoutBtn = driver.findElement(By.cssSelector(".logout"));
        logoutBtn.click();
    }
}
